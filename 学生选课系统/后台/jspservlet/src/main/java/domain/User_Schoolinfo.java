package domain;

import java.io.Serializable;

public class User_Schoolinfo implements Serializable {

    private String username;//用户名
    private String info;//评论信息

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
