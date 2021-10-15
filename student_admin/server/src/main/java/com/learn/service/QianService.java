package com.learn.service;

import com.learn.entity.QianEntity;

import java.util.List;
import java.util.Map;

/**
 * 签到信息
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date # 10:23:12
 */
public interface QianService {
    /**
    * 查询
	* @return
	*/
	QianEntity queryObject(Long id);

    /**
    * 查询列表
    * @return
    */
	List<QianEntity> queryList(Map<String, Object> map);

    /**
    * 查询总数
    * @return
    */
	int queryTotal(Map<String, Object> map);

    /**
    * 保存
    * @return
    */
	void save(QianEntity qian);

    /**
    * 修改
    * @return
    */
	void update(QianEntity qian);

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
