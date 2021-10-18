package com.naughty.userlogin02.service;

import com.naughty.userlogin02.bean.Restaurant;
import com.naughty.userlogin02.dao.ApplyDao;
import com.naughty.userlogin02.dao.RestDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestService {

    @Autowired
    public RestDao restDao;

    public List<Restaurant> getAllRestaurant(){
       int count = restDao.getRestCounts("%"+""+"%");
       return restDao.getAllrestaurant("%"+""+"%",0,count);
    }

}
