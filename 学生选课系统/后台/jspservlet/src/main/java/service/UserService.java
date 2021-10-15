package service;

import domain.*;

import java.util.List;
import java.util.Set;

public interface UserService {

    User login(String studentid, String password);

    public boolean reg(String studentid,String password,String username);

    public School findSchoolandInfo(String schoolid);

    boolean password(User user);

    boolean updateinfo(String studentid, String schoolid,String info);

    Boolean ShouCang_Ok(String studentid, String schoolid);

    Boolean ShouCang_No(String studentid, String schoolid);

    List<User_School> findUser_School(String studentid);

    List<Three> finThree();

    List<School> findSchoolBySchooltype(String schooltype);

    List<School> findSchoolByMoHu(String name);

    JspUser jsp_Login(String username, String password);
    Boolean jsp_Password(String username,String password);
    List<Schooltype> findschooltype();
}
