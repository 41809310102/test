package com.learn.controller;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.learn.entity.StucourseEntity;
import com.learn.service.StucourseService;
import com.learn.utils.PageUtils;
import com.learn.utils.Query;
import com.learn.utils.R;


/**
 * 学生课程
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date # 10:23:12
 */
@RestController
@RequestMapping("stucourse")
public class StucourseController extends AbstractController {
    @Autowired
    private StucourseService stucourseService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params) {

        if (super.getUserId() > 1)
            params.put("user", super.getUserId());


        //查询列表数据
        Query query = new Query(params);

        List<StucourseEntity> stucourseList = stucourseService.queryList(query);
        int total = stucourseService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(stucourseList, total, query.getLimit(), query.getPage());

        return R.ok().put("page", pageUtil);
    }


    /**
     * 列表
     */
    @RequestMapping("/list2")
    public R list2(@RequestParam Map<String, Object> params) {
        Query query = new Query(params);
        List<StucourseEntity> stucourseList = stucourseService.queryList(query);
        return R.ok().put("list", stucourseList);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id) {
        StucourseEntity stucourse = stucourseService.queryObject(id);

        return R.ok().put("stucourse", stucourse);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody StucourseEntity stucourse) {

        if (stucourse.getUser() == null)
            stucourse.setUser(super.getUserId());


        stucourseService.save(stucourse);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody StucourseEntity stucourse) {
        stucourseService.update(stucourse);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids) {
        stucourseService.deleteBatch(ids);

        return R.ok();
    }

}
