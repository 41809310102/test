package com.learn.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

						

import com.learn.dao.CourseDao;
import com.learn.entity.CourseEntity;
import com.learn.service.CourseService;
import com.learn.service.*;



@Service("courseService")
public class CourseServiceImpl implements CourseService {
	@Autowired
	private CourseDao courseDao;

			

			

			

			

			

			

	

	
	@Override
	public CourseEntity queryObject(Long id){
			CourseEntity entity = courseDao.queryObject(id);

																			
		return entity;
	}
	
	@Override
	public List<CourseEntity> queryList(Map<String, Object> map){
        List<CourseEntity> list = courseDao.queryList(map);
        for(CourseEntity entity : list){
																																															}
		return list;
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return courseDao.queryTotal(map);
	}
	
	@Override
	public void save(CourseEntity course){
		courseDao.save(course);
	}
	
	@Override
	public void update(CourseEntity course){
		courseDao.update(course);
	}
	
	@Override
	public void delete(Long id){
		courseDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Long[] ids){
		courseDao.deleteBatch(ids);
	}
	
}
