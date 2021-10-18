package com.naughty.userlogin02.dao;

import com.naughty.userlogin02.bean.File;
import com.naughty.userlogin02.bean.Restfood;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface RestfoodDao {

    public int  getfoodCount(@Param("name") String name);
    public List<Restfood> getAllfood(@Param("name") String name,@Param("start") int start,@Param("end") int end);
    //查找食物详情
    public Restfood findFooddec(@Param("id") int id);
}
