package com.learn.service.impl;

import com.learn.entity.PaikeEntity;
import com.learn.entity.StucourseEntity;
import com.learn.entity.SysUserEntity;
import com.learn.utils.RRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.learn.service.SysUserService;


import com.learn.dao.QianDao;
import com.learn.entity.QianEntity;
import com.learn.service.QianService;
import com.learn.service.*;


@Service("qianService")
public class QianServiceImpl implements QianService {
    @Autowired
    private QianDao qianDao;


    @Autowired
    private PaikeService paikeService;


    @Autowired
    private SysUserService sysUserService;

    @Autowired
    StucourseService stucourseService;
    @Autowired
    HolidayService holidayService;


    @Override
    public QianEntity queryObject(Long id) {
        QianEntity entity = qianDao.queryObject(id);


        if (entity.getPaike() != null && this.paikeService.queryObject(entity.getPaike()) != null)
            entity.setPaikeEntity(this.paikeService.queryObject(entity.getPaike()));

        if (entity.getUser() != null && this.sysUserService.queryObject(entity.getUser()) != null)
            entity.setSysUserEntity(this.sysUserService.queryObject(entity.getUser()));


        return entity;
    }


    @Override
    public List<QianEntity> queryList(Map<String, Object> map) {

        //处理过期时间，缺勤
        for(PaikeEntity entity :this.paikeService.queryList(new HashMap<String, Object>())){
            //开始处理
            //获取选择这个课程的人
            if(System.currentTimeMillis() > entity.getEnd().getTime()){
                Map<String, Object> map1 = new HashMap<>();
                map1.put("course",entity.getCourse());
                for(StucourseEntity stucourseEntity : this.stucourseService.queryList(map1)){

                    //有这些人
                    Map<String, Object> map2 = new HashMap<>();
                    map2.put("user", stucourseEntity.getUser());
                    map2.put("paike", entity.getId());

                    if(this.qianDao.queryList(map2).size() == 0){
                        //没有考勤记录

                        //判断是否有请假记录
                        //同意
                        map2.put("state","同意");

                        QianEntity qianEntity  = new QianEntity();
                        qianEntity.setUser(stucourseEntity.getUser());
                        qianEntity.setPaike(entity.getId());
                        if(this.holidayService.queryList(map2).size() >0){
                            qianEntity.setState("请假");
                        }else{
                            qianEntity.setState("缺勤");
                        }



                        this.qianDao.save(qianEntity);

                    }

                }

            }
        }


        List<QianEntity> list = qianDao.queryList(map);
        for (QianEntity entity : list) {

            if (entity.getPaike() != null && this.paikeService.queryObject(entity.getPaike()) != null)
                entity.setPaikeEntity(this.paikeService.queryObject(entity.getPaike()));

            if (entity.getUser() != null && this.sysUserService.queryObject(entity.getUser()) != null)
                entity.setSysUserEntity(this.sysUserService.queryObject(entity.getUser()));

        }
        return list;
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return qianDao.queryTotal(map);
    }

    @Override
    public void save(QianEntity qian) {


        Map<String, Object> map = new HashMap<>();
        map.put("user", qian.getUser());
        map.put("paike", qian.getPaike());
        if (this.qianDao.queryTotal(map) > 0) {
            System.out.println("请勿重复签到");
        }

        PaikeEntity paikeEntity = this.paikeService.queryObject(qian.getPaike());

        //计算签到结果
        if(System.currentTimeMillis() > paikeEntity.getTime().getTime() &&  System.currentTimeMillis() < paikeEntity.getEnd().getTime()){
            qian.setState("迟到");
        }
        if(System.currentTimeMillis() < paikeEntity.getTime().getTime()){
            qian.setState("正常");
        }
        if(System.currentTimeMillis() > paikeEntity.getEnd().getTime()){
            throw new RRException("上课时间已过，无法签到");
        }

        qianDao.save(qian);
    }

    @Override
    public void update(QianEntity qian) {
        qianDao.update(qian);
    }

    @Override
    public void delete(Long id) {
        qianDao.delete(id);
    }

    @Override
    public void deleteBatch(Long[] ids) {
        qianDao.deleteBatch(ids);
    }

}
