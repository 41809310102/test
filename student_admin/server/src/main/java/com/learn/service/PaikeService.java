package com.learn.service;

import com.learn.entity.PaikeEntity;

import java.util.List;
import java.util.Map;

/**
 * 课程安排
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date # 10:23:12
 */
public interface PaikeService {
    /**
    * 查询
	* @return
	*/
	PaikeEntity queryObject(Long id);

    /**
    * 查询列表
    * @return
    */
	List<PaikeEntity> queryList(Map<String, Object> map);

    /**
    * 查询总数
    * @return
    */
	int queryTotal(Map<String, Object> map);

    /**
    * 保存
    * @return
    */
	void save(PaikeEntity paike);

    /**
    * 修改
    * @return
    */
	void update(PaikeEntity paike);

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
