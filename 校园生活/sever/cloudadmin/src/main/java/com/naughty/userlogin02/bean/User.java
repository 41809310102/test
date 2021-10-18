package com.naughty.userlogin02.bean;

import lombok.Data;

@Data
public class User {
    private int id;
    private String username;
    private String password;
    private String email;
    private String root;
    private String comment;
    private String role;
    private String port;
    private boolean state;
    private int isvip;
    private boolean isadmin;
    private boolean isdelect;
}
