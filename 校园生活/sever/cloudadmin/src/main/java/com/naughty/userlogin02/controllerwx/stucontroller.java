package com.naughty.userlogin02.controllerwx;



import com.alibaba.fastjson.JSON;
import com.naughty.userlogin02.bean.User;
import com.naughty.userlogin02.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class stucontroller {

    @Autowired
    UserDao userDao;


    @CrossOrigin
    @PostMapping("/stuoflogin")
    public String studentLogin(@RequestParam("studentid") String  username,
                               @RequestParam("password") String  password) {

        User user = userDao.getUserByMassagess(username, password);
     //   String username = user.getUsername();
      //  int res = userDao.gettocheckadmin(username,true);

        System.out.println("微信端用户"+username+"登录成功");
        System.out.println(JSON.toJSONString(user));
        return JSON.toJSONString(user);
    }
}
