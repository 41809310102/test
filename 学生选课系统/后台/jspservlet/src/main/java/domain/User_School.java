package domain;

import java.io.Serializable;

public class User_School implements Serializable {
    private String studentid;//学号
    private  String schoolid;//课程编号

    public String getStudentid() {
        return studentid;
    }

    public void setStudentid(String studentid) {
        this.studentid = studentid;
    }

    public String getSchoolid() {
        return schoolid;
    }

    public void setSchoolid(String schoolid) {
        this.schoolid = schoolid;
    }
}
