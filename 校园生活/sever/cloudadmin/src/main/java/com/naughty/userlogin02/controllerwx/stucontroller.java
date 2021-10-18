package com.naughty.userlogin02.controllerwx;



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
        String str = "error";
        int count = userDao.getUserByMassage(username, password);
     //   String username = user.getUsername();
      //  int res = userDao.gettocheckadmin(username,true);

        System.out.println("微信端用户"+username+"登录成功");
        if (count > 0) {
            str = "ok";
        }
        return str;
    }
}
