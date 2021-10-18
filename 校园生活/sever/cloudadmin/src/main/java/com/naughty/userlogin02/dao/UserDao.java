package com.naughty.userlogin02.dao;

import com.naughty.userlogin02.bean.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {

    public int getUserByMassage(@Param("username") String username, @Param("password") String password);
    public List<User> getAllUser(@Param("username") String username,@Param("pageStart") int pageStart, @Param("pageSize") int pageSize);
    public int getUserCounts(@Param("username") String username);
    public int updateState(Integer id, Boolean state);
    public int updateisvip(String applymanname, int isvip);
    public int updateisadmin(String applymanname, Boolean isadmin);
    public int updateisdelect(String applymanname, Boolean isdelect);
    public int addUser(User user);
    public User getUpdateUser(int id);
    public int gettocheckadmin(@Param("username") String username,Boolean isadmin);
    public int editUser(User user);
    public int deleteUser(int id);
}
