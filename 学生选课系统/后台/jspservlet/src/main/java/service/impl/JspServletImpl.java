package service.impl;

import dao.JspDao;
import dao.impl.JspDaoImpl;
import domain.School;
import domain.User;
import service.JspService;

import java.util.List;

public class JspServletImpl implements JspService {
    JspDao  jspDao = new JspDaoImpl();
    @Override
    public List<User> findUserAll() {
        return jspDao.findUserAll();
    }

    @Override
    public Boolean delUser(String studentid) {
        return jspDao.delUser(studentid);
    }

    @Override
    public void updateUser(String studentid, String password, String username) {
        jspDao.updateUser(studentid,password,username);
    }

    @Override
    public List<School> findSchoolAll() {
        return jspDao.findSchoolAll();
    }

    @Override
    public Boolean delSchool(String schoolid) {
        return  jspDao.delSchool(schoolid);
    }

    @Override
    public Boolean updateSchool(School school) {
        return jspDao.updateSchool(school);
    }

    @Override
    public void addSchool(School school) {
        jspDao.addSchool(school);
    }


}
