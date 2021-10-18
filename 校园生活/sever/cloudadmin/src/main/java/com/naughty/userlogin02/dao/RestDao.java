package com.naughty.userlogin02.dao;

import com.naughty.userlogin02.bean.Restaurant;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestDao {

    //获得数据库中所有数据数
    public int getRestCounts(@Param("name") String name);
    public List<Restaurant> getAllrestaurant(@Param("name") String name, @Param("pageStart") int pageStart, @Param("pageSize") int pageSize);
}
