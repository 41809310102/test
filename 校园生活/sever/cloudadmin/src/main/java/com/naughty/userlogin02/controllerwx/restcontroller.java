package com.naughty.userlogin02.controllerwx;

import com.alibaba.fastjson.JSON;
import com.naughty.userlogin02.bean.Restaurant;
import com.naughty.userlogin02.bean.Restfood;
import com.naughty.userlogin02.dao.RestfoodDao;
import com.naughty.userlogin02.service.RestService;
import com.naughty.userlogin02.service.RestfoodService;
import com.naughty.userlogin02.util.TimeUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

}
