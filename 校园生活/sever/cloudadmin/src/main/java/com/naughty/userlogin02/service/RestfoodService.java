package com.naughty.userlogin02.service;

import com.naughty.userlogin02.bean.Restfood;
import com.naughty.userlogin02.dao.RestfoodDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestfoodService {
    @Autowired

    private RestfoodDao restfoodDao;
    //获得对应食物的餐厅信息
    public List<Restfood>  getAllofrestaurantfood(){
        List<Restfood> res = null;
        int count =  restfoodDao.getfoodCount("%"+""+"%");
        System.out.println(count);
        res = restfoodDao.getAllfood("%"+""+"%",0,count);
        return  res;
    }

    public Restfood getRestfoodofdelis(int id){
        Restfood food = restfoodDao.findFooddec(id);
        return  food;
    }
}
