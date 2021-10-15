package com.learn.service;

import com.learn.entity.StucourseEntity;

import java.util.List;
import java.util.Map;

/**
 * 学生课程
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date # 10:23:12
 */
public interface StucourseService {
    /**
    * 查询
	* @return
	*/
	StucourseEntity queryObject(Long id);

    /**
    * 查询列表
    * @return
    */
	List<StucourseEntity> queryList(Map<String, Object> map);

    /**
    * 查询总数
    * @return
    */
	int queryTotal(Map<String, Object> map);

    /**
    * 保存
    * @return
    */
	void save(StucourseEntity stucourse);

    /**
    * 修改
    * @return
    */
	void update(StucourseEntity stucourse);

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
