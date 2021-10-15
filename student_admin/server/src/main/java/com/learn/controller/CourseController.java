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

import com.learn.entity.CourseEntity;
import com.learn.service.CourseService;
import com.learn.utils.PageUtils;
import com.learn.utils.Query;
import com.learn.utils.R;


/**
 * 课程信息
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date # 10:23:12
 */
@RestController
@RequestMapping("course")
public class CourseController extends AbstractController {
	@Autowired
	private CourseService courseService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	public R list(@RequestParam Map<String, Object> params){

																																

		//查询列表数据
        Query query = new Query(params);

		List<CourseEntity> courseList = courseService.queryList(query);
		int total = courseService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(courseList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	

	/**
	 * 列表
	 */
	@RequestMapping("/list2")
	public R list2(@RequestParam Map<String, Object> params){
        Query query = new Query(params);
		List<CourseEntity> courseList = courseService.queryList(query);
		return R.ok().put("list", courseList );
	}


	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	public R info(@PathVariable("id") Long id){
		CourseEntity course = courseService.queryObject(id);
		
		return R.ok().put("course", course);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	public R save(@RequestBody CourseEntity course){

																																

        courseService.save(course);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	public R update(@RequestBody CourseEntity course){
		courseService.update(course);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	public R delete(@RequestBody Long[] ids){
		courseService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
