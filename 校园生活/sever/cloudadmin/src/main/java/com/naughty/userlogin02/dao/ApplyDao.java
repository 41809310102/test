package com.naughty.userlogin02.dao;

import com.naughty.userlogin02.bean.Apply;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplyDao {
    //获得数据库中所有数据数
    public int getApplyCounts(@Param("applymanname") String applymanname);
    //获得所有申请信息；
    public List<Apply> getAllApply(@Param("applymanname") String applymanname, @Param("pageStart") int pageStart, @Param("pageSize") int pageSize);

    //修改vip状态
    public int updateIsvip(Integer id, Boolean isvip);

    //修改admin状态
    public int updateIsadmin(Integer id, Boolean isadmin);

    //得到admin状态
    public int getApplyByusername(String applymanname,Boolean isadmin);
    //修改delect状态
    public int updateIsdelect(Integer id, Boolean isdelect);

    //移除apply
    public int deleteApply(int id);

}
