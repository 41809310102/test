package dao.impl;

import dao.JspDao;
import domain.School;
import domain.User;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import utils.JDBCUtils;

import java.util.List;

public class JspDaoImpl implements JspDao {
    JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());

    /**
     * 查询所有学生
     * @return
     */
    @Override
    public List<User> findUserAll() {
        String sql = "select * from userinfo";
        List<User> users = null;
        try {
            users = jdbcTemplate.query(sql, new BeanPropertyRowMapper<User>(User.class));
        } catch (DataAccessException e) {
            return null;
        }
        return users;
    }

    /**
     * 删除指定用户 根据学号
     * @param studentid
     * @return
     */
    @Override
    public Boolean delUser(String studentid) {
        String sql ="DELETE FROM userinfo WHERE studentid =?";
        String sql2="delete from user_school where studentid = ?";
        int update = jdbcTemplate.update(sql, studentid);
        if (update>0){
            try {
                jdbcTemplate.update(sql2,studentid);
            } catch (DataAccessException e) {

            }
            return true;
        }
        return false;
    }

    /**
     * 更新用户信息 根据学号
     * @param studentid
     * @param password
     * @param username
     * @return
     */
    @Override
    public void updateUser(String studentid, String password, String username) {
        String sql = "UPDATE  userinfo SET PASSWORD =? , username=? WHERE studentid=?";
        try {
            jdbcTemplate.update(sql, password, username, studentid);
        } catch (DataAccessException e) {
        }
    }

    /**
     * 查询所有课程详细信息
     * @return
     */
    @Override
    public List<School> findSchoolAll() {
        String sql = "select * from schoolinfo";
        List<School> list = null;
        try {
          list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<School>(School.class));
        } catch (DataAccessException e) {
            return null;
        }
        return list;
    }

    /**
     * 删除指定课程
     * @param schoolid
     * @return
     */
    @Override
    public Boolean delSchool(String schoolid) {
        String sql ="delete from schoolinfo where schoolid = ?";
        int update = jdbcTemplate.update(sql, schoolid);
        if (update>0){
            return true;
        }
        else {return false;}
    }

    /**
     * 更新单个课程
     */
    @Override
    public Boolean updateSchool(School school) {
        String sql ="update schoolinfo set schoolname=? ,schooltype = ?, schoolcount =?,schoolinfo=?, schoolteacherinfo=?,schoolteachername=?,schoolurl=?,schoolimg=?  where schoolid =?";
        try {
            int update = jdbcTemplate.update(sql, school.getSchoolname(), school.getSchooltype(), school.getSchoolcount(), school.getSchoolinfo(), school.getSchoolteacherinfo(), school.getSchoolteachername(), school.getSchoolurl(), school.getSchoolimg(), school.getSchoolid());
        } catch (DataAccessException e) {

        }
        return true;
    }

    /**
     * 添加课程
     * @param school
     */
    @Override
    public void addSchool(School school) {
        String sql="INSERT INTO schoolinfo(schoolname,schooltype,schoolcount,schoolinfo,schoolteacherinfo,schoolteachername,schoolurl,schoolimg) VALUES(?,?,?,?,?,?,?,?)" ;
        try {
            jdbcTemplate.update(sql,school.getSchoolname(),school.getSchooltype(),school.getSchoolcount(),school.getSchoolinfo(),school.getSchoolteacherinfo(),school.getSchoolteachername(),school.getSchoolurl(),school.getSchoolimg());
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
    }


}
