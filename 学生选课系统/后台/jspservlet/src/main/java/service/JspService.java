package service;

import domain.School;
import domain.User;

import java.util.List;

public interface JspService {
        List<User> findUserAll();

        Boolean delUser(String studentid);

        void updateUser(String studentid,String password,String username);

        List<School> findSchoolAll();
        Boolean delSchool(String schoolid);
        Boolean updateSchool(School school);

        void addSchool(School school);
}
