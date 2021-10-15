package domain;

import java.io.Serializable;

public class Three implements Serializable {
    private String schoolid;
    private String schoolname;
    private String schoolteachername;
    private String schoolurl;
    private String schoolimg;

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
}
