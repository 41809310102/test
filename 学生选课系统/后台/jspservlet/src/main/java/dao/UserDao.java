package dao;

import domain.*;

import java.util.List;
import java.util.Set;

public interface UserDao {

    public User login(String studentid, String password);

    public boolean reg(String studentid,String password,String username);

    public boolean loginIsId(String studentid);

    public School findSchoolinfoBySchoolid(String schoolid);

    public List<User_Schoolinfo>  findCommentinfoBySchoolid(String schoolid);

    public boolean password(User user);

    boolean updateinfo(String studentid, String schoolid,String info);

    Boolean ShouCang_Ok(String studentid, String schoolid);

    Boolean ShouCang_No(String studentid, String schoolid);
    boolean isShouCang(String studentid,String schoolid);

    List<User_School> findUser_School(String studentid);

    List<Three> finThree();

    List<School> findSchoolBySchooltype(String schooltype);

    List<School> findSchoolByMoHu(String name);

    JspUser jsp_Login(String username, String password);

    Boolean jsp_Password(String username, String password);

    List<Schooltype> findschooltype();

}
