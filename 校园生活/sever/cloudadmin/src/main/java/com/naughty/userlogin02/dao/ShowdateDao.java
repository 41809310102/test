package com.naughty.userlogin02.dao;

import com.naughty.userlogin02.bean.Safe;
import com.naughty.userlogin02.bean.Showdate;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ShowdateDao {

    public List<Showdate> getAlldate(@Param("name") String name, @Param("pageStart") int pageStart, @Param("pageSize") int pageSize);

    public int updatenew(String name, int count);

    public List<Showdate> getAlldate1(@Param("name") String name, @Param("pageStart") int pageStart, @Param("pageSize") int pageSize);

    public int updatenew2(String name, int count);
}
