package com.naughty.userlogin02.dao;

import com.naughty.userlogin02.bean.Check;
import com.naughty.userlogin02.bean.Safe;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface SafeDao {
    public List<Safe> getAllFlow(@Param("createtime") String url, @Param("pageStart") int pageStart, @Param("pageSize") int pageSize);
    public int getFlowCounts(@Param("createtime") String url);
    public int updateState(Integer id, Boolean error);
    public int addUser(Safe safe);
    public Safe getUpdateFlow(int id);
    public int editUser(Safe safe);
    public int deleteFlow(int id);
}
