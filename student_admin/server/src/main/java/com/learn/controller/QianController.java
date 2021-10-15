package com.learn.controller;

import java.util.List;
import java.util.Map;

import com.learn.entity.SysUserEntity;
import com.learn.service.SysUserService;
import com.learn.utils.*;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.learn.entity.QianEntity;
import com.learn.service.QianService;

import javax.servlet.http.HttpServletRequest;


/**
 * 签到信息
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date # 10:23:12
 */
@RestController
@RequestMapping("qian")
public class QianController extends AbstractController {
    @Autowired
    private QianService qianService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params) {

        if (super.getUserId() > 1)
            params.put("user", super.getUserId());


        //查询列表数据
        Query query = new Query(params);

        List<QianEntity> qianList = qianService.queryList(query);
        int total = qianService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(qianList, total, query.getLimit(), query.getPage());

        return R.ok().put("page", pageUtil);
    }


    /**
     * 列表
     */
    @RequestMapping("/list2")
    public R list2(@RequestParam Map<String, Object> params) {
        Query query = new Query(params);
        List<QianEntity> qianList = qianService.queryList(query);
        return R.ok().put("list", qianList);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id) {
        QianEntity qian = qianService.queryObject(id);

        return R.ok().put("qian", qian);
    }

    @Autowired
    SysUserService sysUserService;
    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody QianEntity qian, HttpServletRequest request) {

        SysUserEntity user = this.sysUserService.queryObject(qian.getUser());

        int a =  FaceUtils.compare(MultipartFileUtil.getRootPath(request)+user.getUrl(), MultipartFileUtil.getRootPath(request)+qian.getUrl());
        if(a < 80){
            throw new RRException("人脸识别未通过");
        }
        qianService.save(qian);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody QianEntity qian) {
        qianService.update(qian);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids) {
        qianService.deleteBatch(ids);

        return R.ok();
    }

}
