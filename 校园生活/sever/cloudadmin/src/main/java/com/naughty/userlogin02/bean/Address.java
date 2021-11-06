package com.naughty.userlogin02.bean;

import lombok.Data;

@Data
public class Address {
    private  String  id;
    private  String address;
    private  int user_id;
    private  String username;
    private  String userphone;
    private  String usersex;
    private  Boolean ismoren; //设置为默认
}
