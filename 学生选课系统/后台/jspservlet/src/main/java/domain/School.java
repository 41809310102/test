package domain;

import java.io.Serializable;
import java.util.List;

public class School implements Serializable {
    private String schoolid; //课程编号
    private String schoolname; //课程名称
    private String schooltype; //课程类别
    private String schoolcount; //课程收藏人数
    private String schoolinfo; //课程简介
    private String schoolteacherinfo;//老师简介
    private String schoolteachername;//老师姓名

    public String getSchoolid() {
        return schoolid;
    }

    public void setSchoolid(String schoolid) {
        this.schoolid = schoolid;
    }

    public String getSchoolname() {
        return schoolname;
    }

    public void setSchoolname(String schoolname) {
        this.schoolname = schoolname;
    }

    public String getSchooltype() {
        return schooltype;
    }

    public void setSchooltype(String schooltype) {
        this.schooltype = schooltype;
    }

    public String getSchoolcount() {
        return schoolcount;
    }

    public void setSchoolcount(String schoolcount) {
        this.schoolcount = schoolcount;
    }

    public String getSchoolinfo() {
        return schoolinfo;
    }

    public void setSchoolinfo(String schoolinfo) {
        this.schoolinfo = schoolinfo;
    }

    public String getSchoolteacherinfo() {
        return schoolteacherinfo;
    }

    public void setSchoolteacherinfo(String schoolteacherinfo) {
        this.schoolteacherinfo = schoolteacherinfo;
    }

    public String getSchoolteachername() {
        return schoolteachername;
    }

    public void setSchoolteachername(String schoolteachername) {
        this.schoolteachername = schoolteachername;
    }

    public String getSchoolurl() {
        return schoolurl;
    }

    public void setSchoolurl(String schoolurl) {
        this.schoolurl = schoolurl;
    }

    public String getSchoolimg() {
        return schoolimg;
    }

    public void setSchoolimg(String schoolimg) {
        this.schoolimg = schoolimg;
    }

    public List<User_Schoolinfo> getUser_schoolinfos() {
        return user_schoolinfos;
    }

    public void setUser_schoolinfos(List<User_Schoolinfo> user_schoolinfos) {
        this.user_schoolinfos = user_schoolinfos;
    }

    private String schoolurl;//视频url
    private String schoolimg;//图片url
    private List<User_Schoolinfo> user_schoolinfos; //用户名跟该用户名的评论

}