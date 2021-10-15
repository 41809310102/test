package com.learn.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.learn.entity.StucourseEntity;
import com.learn.service.StucourseService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.learn.entity.PaikeEntity;
import com.learn.service.PaikeService;
import com.learn.utils.PageUtils;
import com.learn.utils.Query;
import com.learn.utils.R;


/**
 * 课程安排
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date # 10:23:12
 */
@RestController
@RequestMapping("paike")
public class PaikeController extends AbstractController {
    @Autowired
    private PaikeService paikeService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params) {
        if (super.getUserId() > 1) {
            //获取我能学习的课程
            List<Long> courses = new ArrayList<>();
            Map<String, Object> params1 = new HashMap<>();
            params1.put("user", super.getUserId());
            String ss = "";
            for (StucourseEntity s : this.stucourseService.queryList(params1)) {
                ss += s.getCourse() + ",";
            }
            ss = ss.substring(0, ss.length() - 1);
            params.put("courses", ss);
        }

        //查询列表数据
        Query query = new Query(params);

        List<PaikeEntity> paikeList = paikeService.queryList(query);
        int total = paikeService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(paikeList, total, query.getLimit(), query.getPage());

        return R.ok().put("page", pageUtil);
    }

    @Autowired
    StucourseService stucourseService;

    /**
     * 列表
     */
    @RequestMapping("/list2")
    public R list2(@RequestParam Map<String, Object> params) {
        if (super.getUserId() > 1) {
            //获取我能学习的课程
            List<Long> courses = new ArrayList<>();
            Map<String, Object> params1 = new HashMap<>();
            params1.put("user", super.getUserId());
            String ss = "";
            for (StucourseEntity s : this.stucourseService.queryList(params1)) {
                ss += s.getCourse() + ",";
            }
            ss = ss.substring(0, ss.length() - 1);
            params.put("courses", ss);
        }
        Query query = new Query(params);
        List<PaikeEntity> paikeList = paikeService.queryList(query);
        return R.ok().put("list", paikeList);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id) {
        PaikeEntity paike = paikeService.queryObject(id);

        return R.ok().put("paike", paike);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody PaikeEntity paike) {


        paikeService.save(paike);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody PaikeEntity paike) {
        paikeService.update(paike);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids) {
        paikeService.deleteBatch(ids);

        return R.ok();
    }

}
