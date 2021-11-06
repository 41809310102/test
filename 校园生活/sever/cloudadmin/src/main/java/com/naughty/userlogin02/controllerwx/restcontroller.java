package com.naughty.userlogin02.controllerwx;

import com.alibaba.fastjson.JSON;
import com.naughty.userlogin02.bean.Address;
import com.naughty.userlogin02.bean.Restaurant;
import com.naughty.userlogin02.bean.Restfood;
import com.naughty.userlogin02.bean.User;
import com.naughty.userlogin02.dao.AddressDao;
import com.naughty.userlogin02.dao.RestfoodDao;
import com.naughty.userlogin02.dao.UserDao;
import com.naughty.userlogin02.service.RestService;
import com.naughty.userlogin02.service.RestfoodService;
import com.naughty.userlogin02.util.TimeUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.sound.midi.Soundbank;
import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
public class restcontroller {
   @Autowired
   private RestService rest;
   @Autowired
   private RestfoodService restfoodService;

   @Autowired
   private AddressDao addressDao;
   @Autowired
    private UserDao userDao;
   @CrossOrigin
   @PostMapping("/getrestaurant")
   public String getRest(){

    List<Restaurant> res = rest.getAllRestaurant();
    String rest_json = JSON.toJSONString(res);
    System.out.println(rest_json);
    return  rest_json;
   }

    @PostMapping("/getrestfood")
    public  String getRestfood(){

        List<Restfood> res=  restfoodService.getAllofrestaurantfood();
        for(int i = 0;i<res.size();i++){
            if(res.get(i).getZhekou()!=0){
               res.get(i).setZhekou(res.get(i).getPirce()*res.get(i).getZhekou());
            }
        }
        String restfood_json = JSON.toJSONString(res);
        System.out.println(restfood_json);
        return  restfood_json;
    }

    @PostMapping("/getrestfooddesc")
    public String getRestfooddec(@RequestParam("id") int id){
      //  System.out.println("食物详情"+JSON.toJSONString(restfoodService.getRestfoodofdelis(id)));
        TimeUtils utils = new TimeUtils();

        Restfood restfood = restfoodService.getRestfoodofdelis(id);

        if(restfood.getZhekou()!=0){
                restfood.setZhekou(restfood.getPirce()*restfood.getZhekou());
        }


        Date creatime = restfood.getCreatetime();
        String time =   utils.timeUtils(creatime);
        restfood.setCreatetime1(time);
       return  JSON.toJSONString(restfood);
    }


    @PostMapping("/getuseraddress")
    public String getUseraddress(@RequestParam("user_id") int user_id){
        System.out.println("正在获取地址");
       int count = addressDao.getAddressCounts("%"+""+"%");
       List<Address> res = addressDao.getAlladdress(user_id,0,count);
       User user = userDao.getUserByMassages(user_id);
       for(int i = 0;i<res.size();i++){
           res.get(i).setUsername(user.getUsername());
           res.get(i).setUserphone(user.getPhone());
           res.get(i).setUsersex(user.getSex());
       }
       String address_JSON = JSON.toJSONString(res);
        System.out.println(address_JSON);
       return  address_JSON;
    }

    @RequestMapping("/getuseraddressok")
    public  String getAddressok(int user_id){
        return getUseraddress(user_id);
    }


    @RequestMapping("/addaddress")
    public String addaddress(String name,String sex,String phone,String city,String cityDetail) {
        System.out.println(city + cityDetail);
        //根据当前name信息查找是否有该用户
        int user_id = userDao.getUserid(name);

        Address address = new Address();
        address.setUsersex(sex);
        address.setUser_id(user_id);
        address.setIsmoren(false);
        address.setAddress(city + cityDetail);
        addressDao.addAddress(address);
        return "ok";
    }
    @RequestMapping("/updateismoren")//修改默认地址
    public  String updateIsmoren(Boolean ismoren,int id){
       String res="error";

       int cont = addressDao.updateIsmoren(ismoren,id);
       int count = addressDao.updataOtherismoren(false,id);
       if(cont>0){
           res="ok";
       }

       return res;
    }

    @RequestMapping("/delectaddress")//删除地址
    public  String delectAddress(int id){
        String res="error";
        addressDao.delectAddress(id);
        res="ok";
        return res;
    }
}
