package com.naughty.userlogin02.dao;


import com.naughty.userlogin02.bean.Check;
import com.naughty.userlogin02.bean.Flow;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CheckDao {
    public List<Check> getAllFlow(@Param("url") String url, @Param("pageStart") int pageStart, @Param("pageSize") int pageSize);
    public int getFlowCounts(@Param("url") String url);
    public int updateState(Integer id, Boolean error);
    public int addUser(Check check);
    public Check getUpdateFlow(int id);
    public int editUser(Check check);
    public int deleteFlow(int id);
}
