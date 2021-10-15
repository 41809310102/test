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

import com.learn.entity.ZiliaoEntity;
import com.learn.service.ZiliaoService;
import com.learn.utils.PageUtils;
import com.learn.utils.Query;
import com.learn.utils.R;


/**
 * 教学资料
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date # 10:23:12
 */
@RestController
@RequestMapping("ziliao")
public class ZiliaoController extends AbstractController {
	@Autowired
	private ZiliaoService ziliaoService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	public R list(@RequestParam Map<String, Object> params){

																											

		//查询列表数据
        Query query = new Query(params);

		List<ZiliaoEntity> ziliaoList = ziliaoService.queryList(query);
		int total = ziliaoService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(ziliaoList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	

	/**
	 * 列表
	 */
	@RequestMapping("/list2")
	public R list2(@RequestParam Map<String, Object> params){
        Query query = new Query(params);
		List<ZiliaoEntity> ziliaoList = ziliaoService.queryList(query);
		return R.ok().put("list", ziliaoList );
	}


	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	public R info(@PathVariable("id") Long id){
		ZiliaoEntity ziliao = ziliaoService.queryObject(id);
		
		return R.ok().put("ziliao", ziliao);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	public R save(@RequestBody ZiliaoEntity ziliao){

																											

        ziliaoService.save(ziliao);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	public R update(@RequestBody ZiliaoEntity ziliao){
		ziliaoService.update(ziliao);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	public R delete(@RequestBody Long[] ids){
		ziliaoService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
