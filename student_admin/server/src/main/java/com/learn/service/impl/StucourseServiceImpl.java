package com.learn.service.impl;

import com.learn.utils.RRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

			            import com.learn.service.SysUserService;
		

import com.learn.dao.StucourseDao;
import com.learn.entity.StucourseEntity;
import com.learn.service.StucourseService;
import com.learn.service.*;



@Service("stucourseService")
public class StucourseServiceImpl implements StucourseService {
	@Autowired
	private StucourseDao stucourseDao;

			

			            @Autowired
            private  CourseService  courseService;

		

			            @Autowired
            private SysUserService sysUserService;

		

			

	

	
	@Override
	public StucourseEntity queryObject(Long id){
			StucourseEntity entity = stucourseDao.queryObject(id);

						
            if ( entity.getCourse() != null &&  this.courseService.queryObject(entity.getCourse()) != null)
                entity.setCourseEntity(this.courseService.queryObject(entity.getCourse()));

					            if (this.sysUserService.queryObject(entity.getUser()) != null)
                entity.setSysUserEntity(this.sysUserService.queryObject(entity.getUser()));

						
		return entity;
	}
	
	@Override
	public List<StucourseEntity> queryList(Map<String, Object> map){
        List<StucourseEntity> list = stucourseDao.queryList(map);
        for(StucourseEntity entity : list){
														
                    if ( entity.getCourse() != null &&  this.courseService.queryObject(entity.getCourse()) != null)
                        entity.setCourseEntity(this.courseService.queryObject(entity.getCourse()));

											                    if (this.sysUserService.queryObject(entity.getUser()) != null)
                        entity.setSysUserEntity(this.sysUserService.queryObject(entity.getUser()));

																}
		return list;
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return stucourseDao.queryTotal(map);
	}
	
	@Override
	public void save(StucourseEntity stucourse){
		Map<String, Object> map = new HashMap<>();
		map.put("user",stucourse.getUser());
		map.put("course",stucourse.getCourse());

		if(this.stucourseDao.queryList(map).size() >0){
			throw new RRException("请勿重复设置");
		}

		stucourseDao.save(stucourse);
	}
	
	@Override
	public void update(StucourseEntity stucourse){
		stucourseDao.update(stucourse);
	}
	
	@Override
	public void delete(Long id){
		stucourseDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Long[] ids){
		stucourseDao.deleteBatch(ids);
	}
	
}
