package com.naughty.userlogin02.controller;

import com.alibaba.fastjson.JSON;
import com.naughty.userlogin02.bean.Apply;
import com.naughty.userlogin02.bean.User;
import com.naughty.userlogin02.dao.ApplyDao;
import com.naughty.userlogin02.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @Autowired
    UserDao userDao;


    @CrossOrigin
    @RequestMapping("/login")
    public String userLogin(@RequestBody User user) {
        System.out.println("User : " + user);
        String str = "error";
        int count = userDao.getUserByMassage(user.getUsername(), user.getPassword());
        String username = user.getUsername();
        int res = userDao.gettocheckadmin(username,true);

        System.out.println(count);
        if (count > 0&&res>0) {
            str = "ok";
        }
        return str;
    }


}
