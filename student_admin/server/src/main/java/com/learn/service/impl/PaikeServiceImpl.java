package com.learn.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


import com.learn.dao.PaikeDao;
import com.learn.entity.PaikeEntity;
import com.learn.service.PaikeService;
import com.learn.service.*;


@Service("paikeService")
public class PaikeServiceImpl implements PaikeService {
    @Autowired
    private PaikeDao paikeDao;


    @Autowired
    private CourseService courseService;


    @Override
    public PaikeEntity queryObject(Long id) {
        PaikeEntity entity = paikeDao.queryObject(id);


        if (entity.getCourse() != null && this.courseService.queryObject(entity.getCourse()) != null)
            entity.setCourseEntity(this.courseService.queryObject(entity.getCourse()));


        return entity;
    }

    @Override
    public List<PaikeEntity> queryList(Map<String, Object> map) {
        List<PaikeEntity> list = paikeDao.queryList(map);
        for (PaikeEntity entity : list) {

            if (entity.getCourse() != null && this.courseService.queryObject(entity.getCourse()) != null)
                entity.setCourseEntity(this.courseService.queryObject(entity.getCourse()));

        }
        return list;
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return paikeDao.queryTotal(map);
    }

    @Override
    public void save(PaikeEntity paike) {
        paikeDao.save(paike);
    }

    @Override
    public void update(PaikeEntity paike) {
        paikeDao.update(paike);
    }

    @Override
    public void delete(Long id) {
        paikeDao.delete(id);
    }

    @Override
    public void deleteBatch(Long[] ids) {
        paikeDao.deleteBatch(ids);
    }

}
