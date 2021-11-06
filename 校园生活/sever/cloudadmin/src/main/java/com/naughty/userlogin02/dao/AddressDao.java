package com.naughty.userlogin02.dao;

import com.naughty.userlogin02.bean.Address;
import com.naughty.userlogin02.bean.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressDao {

    //获得数据库中所有数据数
    public int getAddressCounts(@Param("address") String address);
    public List<Address> getAlladdress(@Param("user_id") int user_id, @Param("pageStart") int pageStart, @Param("pageSize") int pageSize);
    public int addAddress(Address address);
    public int updateIsmoren(Boolean ismoren,int id);
    public int updataOtherismoren(Boolean ismoren,int id);
    public void delectAddress(int id);



}
