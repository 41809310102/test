package service.impl;

import dao.impl.UserDaoImpl;
import domain.*;
import service.UserService;

import java.util.List;
import java.util.Set;

public class UserServiceImpl implements UserService {
    UserDaoImpl userDao= new UserDaoImpl();


    @Override
    public User login(String studentid, String password) {
            return userDao.login(studentid, password);
    }

    @Override
    public boolean reg(String studentid, String password, String username) {
        boolean flag = userDao.loginIsId(studentid);
        if (flag){
            return  userDao.reg(studentid,password,username);
        }else {
            //用户名已存在
            return false;
        }

    }

    @Override
    public School findSchoolandInfo(String schoolid) {
        School school = userDao.findSchoolinfoBySchoolid(schoolid);
        if (school!=null){
            List<User_Schoolinfo> list = userDao.findCommentinfoBySchoolid(schoolid);
            school.setUser_schoolinfos(list);
        }


        return school;
    }

    @Override
    public boolean password(User user) {
        return userDao.password(user);
    }

    @Override
    public boolean updateinfo(String studentid, String schoolid,String info) {
     return userDao.updateinfo(studentid,schoolid,info);
    }

    /**
     * 收藏
     * @param studentid
     * @param schoolid
     * @return
     */
    @Override
    public Boolean ShouCang_Ok(String studentid, String schoolid) {
        return userDao.ShouCang_Ok(studentid,schoolid);
    }

    /**
     * 取消收藏
     * @param studentid
     * @param schoolid
     * @return
     */
    @Override
    public Boolean ShouCang_No(String studentid, String schoolid) {
        return userDao.ShouCang_No(studentid,schoolid);
    }

    @Override
    public List<User_School> findUser_School(String studentid) {
        return userDao.findUser_School(studentid);
    }

    @Override
    public List<Three> finThree() {
        return userDao.finThree();
    }

    @Override
    public List<School> findSchoolBySchooltype(String schooltype) {
        return userDao.findSchoolBySchooltype(schooltype);
    }

    @Override
    public List<School> findSchoolByMoHu(String name) {
        return  userDao.findSchoolByMoHu(name);
    }

    @Override
    public JspUser jsp_Login(String username, String password) {
        return userDao.jsp_Login(username,password);
    }

    @Override
    public Boolean jsp_Password(String username, String password) {
        return userDao.jsp_Password(username,password);
    }

    @Override
    public List<Schooltype> findschooltype() {
        return userDao.findschooltype();
    }

}
