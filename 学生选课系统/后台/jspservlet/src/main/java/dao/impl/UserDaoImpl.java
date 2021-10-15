package dao.impl;

import dao.UserDao;
import domain.*;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import utils.JDBCUtils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserDaoImpl implements UserDao {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());

    /**根据学号密码登录
     * @param studentid
     * @param password
     * @return
     */
    @Override
    public User login(String studentid, String password) {
        String sql="select * from userinfo where studentid =? and password =?";
        User user =null;
        try {
             user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), studentid, password);
        } catch (DataAccessException e) {
            return null;
        }
        return user;
    }

    /**
     * 注册账号 学号 密码  姓名
     * @param studentid
     * @param password
     * @param username
     * @return
     */
    @Override
    public boolean reg(String studentid, String password, String username) {
        String sql = "INSERT INTO userinfo VALUES(?,?,?)";
        int update = jdbcTemplate.update(sql, studentid, password, username);
        if (update>0){
            return true;
        }
        return false;
    }

    /**
     * 判断用户(学号)是否存在
     * @param studentid
     * @return
     */
    @Override
    public boolean loginIsId(String studentid) {
        String sql = "select * from userinfo where studentid = ?";

        //判断该学号的用户是否存在 ，存在返回false 不存在抛异常返回true
        try {
            jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), studentid);
        } catch (DataAccessException e) {
            return true;
        }
        return false;
    }

    /**
     * 根据课程编号查课程信息
     * @param schoolid
     * @return 课程的详细信息
     */
    @Override
    public School findSchoolinfoBySchoolid(String schoolid) {
        String sql = "select * from schoolinfo where schoolid = ?";
        School school = null;
        try {
            school = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<School>(School.class), schoolid);
        } catch (DataAccessException e) {
            return null;
        }
        return school;
    }
    /**
     * 根据课程编号查询评论内容
     * @param schoolid
     * @return 对应用户的评论  姓名跟评论内容
     */
    @Override
    public   List<User_Schoolinfo>  findCommentinfoBySchoolid(String schoolid) {
        String sql = "SELECT userinfo.`username`,info FROM commentinfo,userinfo WHERE schoolid =? AND userinfo.`studentid`=commentinfo.`studentid`";
        try {
            return  jdbcTemplate.query(sql, new BeanPropertyRowMapper<User_Schoolinfo>(User_Schoolinfo.class), schoolid);
        } catch (DataAccessException e) {
            return null;
        }
    }


    /**
     * 修改密码
     * @param user 学号跟新密码
     * @return true
     */
    @Override
    public boolean password(User user) {
        String sql =" UPDATE userinfo SET PASSWORD=? WHERE studentid=?";
        int update = jdbcTemplate.update(sql, user.getPassword(), user.getStudentid());
        if (update>=0){
            return true;
        }
        return false;
    }

    /**
     * 用户评论
     * @param studentid 学号
     * @param schoolid 课程编号
     * @param info 评论内容
     * @return true
     */
    @Override
    public boolean updateinfo(String studentid, String schoolid,String info) {
        String sql = "insert into commentinfo(studentid,schoolid,info) values(?,?,?)";
        int update = jdbcTemplate.update(sql,studentid,schoolid,info);
        if (update>0){
            return true;
        }
        return false;
    }

    /**
     * 收藏
     * @param studentid
     * @param schoolid
     * @return
     */
    @Override
    public Boolean ShouCang_Ok(String studentid, String schoolid) {
        boolean flag = this.isShouCang(studentid, schoolid);
        if (!flag){
            String sql ="insert into user_school(studentid,schoolid) values(?,?) ";
            int update = jdbcTemplate.update(sql, studentid, schoolid);
            if (update>0){
                String sql2="UPDATE schoolinfo SET schoolcount=schoolcount+1 WHERE schoolid=?";
                jdbcTemplate.update(sql2,schoolid);
            }
        }
        return true;
    }

    /**
     * 取消收藏
     * @param studentid
     * @param schoolid
     * @return
     */
    @Override
    public Boolean ShouCang_No(String studentid, String schoolid) {
        String sql = "delete from  user_school where studentid=? and schoolid = ?";
        try {
            int update = jdbcTemplate.update(sql, studentid, schoolid);
            if (update>0){
                String sql2="UPDATE schoolinfo SET schoolcount=schoolcount-1 WHERE schoolid=?";
                jdbcTemplate.update(sql2,schoolid);
            }
        } catch (DataAccessException e) {

        }
        return true;
    }

    /**
     * 判断收藏的状态
     * @param studentid
     * @param schoolid
     * @return
     */
    @Override
    public boolean isShouCang(String studentid, String schoolid) {
        String sql = "select * from  user_school where studentid = ? and schoolid = ?";
        try {
            User_School user_school = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<User_School>(User_School.class), studentid, schoolid);
        } catch (DataAccessException e) {
           //空 代表未收藏
            return false;
        }
        // true 已经收藏
        return true;
    }

    /**
     * 查询该学生收藏的课程编号
     * @param studentid
     * @return
     */
    @Override
    public List<User_School> findUser_School(String studentid) {
        String sql ="select * from user_school where studentid = ?";
        List<User_School> list = null;
        try {
            list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<User_School>(User_School.class), studentid);
        } catch (DataAccessException e) {
            return null;
        }
        return list;
    }

    /**
     * 查询三个参数 课程编号 课程名称 老师名称  无参数
     * @return
     */
    @Override
    public List<Three> finThree() {
        String sql = "select schoolid,schoolname,schoolteachername,schoolurl,schoolimg from schoolinfo";
        List<Three> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Three>(Three.class));
        return list;
    }


    /**
     * 根据科目类型查询 符合该类型的科目
     * @param schooltype
     * @return
     */
    @Override
    public List<School> findSchoolBySchooltype(String schooltype) {
        String sql ="SELECT * FROM schoolinfo WHERE schooltype =?";
        List<School> list = null;
        try {
            list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<School>(School.class),schooltype);
        } catch (DataAccessException e) {
            return null;

        }

        return list;
    }

    @Override
    public List<School> findSchoolByMoHu(String name) {
        String sql = "SELECT * FROM schoolinfo WHERE schoolname LIKE ?;";
        List<School> list = null;
        try {
            list  = jdbcTemplate.query(sql, new BeanPropertyRowMapper<School>(School.class), "%"+name+"%");
        } catch (DataAccessException e) {
            return null;
        }
        return list;

    }

    /**
     * jsp.登录
     * @param username
     * @param password
     * @return
     */
    @Override
    public JspUser jsp_Login(String username, String password) {
        String sql ="select * from jspuser where username=? and password = ?";
        JspUser jspUser = null;
        try {
            jspUser = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<JspUser>(JspUser.class), username, password);
        } catch (DataAccessException e) {
            return null;
        }
        return jspUser;
    }

    /**
     * jsp.修改密码
     * @param username
     * @param password
     * @return
     */
    @Override
    public Boolean jsp_Password(String username, String password) {
        String sql = "update jspuser set password =? where username= ?";
        int update = jdbcTemplate.update(sql, password, username);
        if (update>0){
            return true;
        }
        return false;
    }

    @Override
    public List<Schooltype> findschooltype() {
        String sql = "select schooltype from schoolinfo";
        List<Schooltype> list =null;
        try {
         list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Schooltype>(Schooltype.class));
        } catch (DataAccessException e) {
            return null;
        }
        return list;
    }


}
