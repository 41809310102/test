package com.learn.service;

import com.learn.entity.CourseEntity;

import java.util.List;
import java.util.Map;

/**
 * 课程信息
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date # 10:23:12
 */
public interface CourseService {
    /**
    * 查询
	* @return
	*/
	CourseEntity queryObject(Long id);

    /**
    * 查询列表
    * @return
    */
	List<CourseEntity> queryList(Map<String, Object> map);

    /**
    * 查询总数
    * @return
    */
	int queryTotal(Map<String, Object> map);

    /**
    * 保存
    * @return
    */
	void save(CourseEntity course);

    /**
    * 修改
    * @return
    */
	void update(CourseEntity course);

    /**
    * 删除
    * @return
    */
	void delete(Long id);

    /**
    * 批量删除
    * @return
    */
	void deleteBatch(Long[] ids);
}
