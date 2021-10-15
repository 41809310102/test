package dao;

import domain.School;
import domain.User;

import java.util.List;

public interface JspDao {
    List<User> findUserAll();

    Boolean delUser(String studentid);

    void updateUser(String studentid, String password, String username);

    List<School> findSchoolAll();

    Boolean delSchool(String schoolid);

    Boolean updateSchool(School school);

    void addSchool(School school);
}
