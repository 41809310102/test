package com.naughty.userlogin02.controller;

import com.alibaba.fastjson.JSON;
import com.naughty.userlogin02.bean.*;
import com.naughty.userlogin02.dao.CheckDao;
import com.naughty.userlogin02.dao.FileDao;

import com.naughty.userlogin02.dao.SafeDao;
import com.naughty.userlogin02.dao.ShowdateDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

@RestController
public class ShowdateController {

    @Autowired
    ShowdateDao showdateDao;
    @Autowired
    FileDao fileDao;
    //前台刷新日志数据
    @CrossOrigin
    @RequestMapping("/alldate")//前端请求通道
    public String getAlldateList(QueryInfo queryInfo){
        System.out.println(queryInfo);
        int pageStart = (queryInfo.getPageNum()-1)*queryInfo.getPageSize();
        List<Showdate> dates = showdateDao.getAlldate("%"+queryInfo.getQuery()+"%",pageStart,queryInfo.getPageSize());

        for(int i =0;i<dates.size();i++){
            System.out.println(dates.get(i).toString());
        }
        //校验
        //封装校验后的流量日志
        HashMap<String, Object> res = new HashMap<>();
        res.put("flag","success");
        res.put("opinionData2",dates );
        String date_json= JSON.toJSONString(res);
        System.out.println(date_json.toString());
        return date_json;
    }


    @CrossOrigin
    @RequestMapping("/allclouddate")//前端请求通道
    public String getAlldateList1(QueryInfo queryInfo){
        System.out.println(queryInfo);
        int pageStart = (queryInfo.getPageNum()-1)*queryInfo.getPageSize();
     //   List<Showdate> dates = showdateDao.getAlldate("%"+queryInfo.getQuery()+"%",pageStart,queryInfo.getPageSize());
        List<Showdate> dates = showdateDao.getAlldate1("%"+queryInfo.getQuery()+"%",pageStart,queryInfo.getPageSize());
        for(int i =0;i<dates.size();i++){
            System.out.println(dates.get(i).toString());
        }
        //校验
        //封装校验后的流量日志
        HashMap<String, Object> res = new HashMap<>();
        res.put("flag","success");
        res.put("opinionData2",dates );
        String date_json= JSON.toJSONString(res);
        System.out.println(date_json.toString());
        return date_json;
    }

    //数据库数据来源的实现方法，就是改变数据库表Date1中得数据
    @RequestMapping("/getupdata")
    public String updateDate(QueryInfo queryInfo){

        String s = "图片文件";
        String s1 ="视频文件";
        String s2 ="音频文件";
        String s3 ="文档文件";
        int count = fileDao.getFilsofimageCounts("%"+".png"+"%","%"+".jpg"+"%","%"+queryInfo.getQuery()+"%");// 获取数据总数
        int count1 =fileDao.getFilsofimageCounts("%"+".aac"+"%","%"+".mp3"+"%","%"+queryInfo.getQuery()+"%");  //四个方法需要你自己根据具体业务实现
        int count2 =fileDao.getFilsofimageCounts("%"+".mp4"+"%","%"+".avi"+"%","%"+queryInfo.getQuery()+"%");
        int count3 =fileDao.getFilsofimageCounts("%"+".docx"+"%","%"+".pdf"+"%","%"+queryInfo.getQuery()+"%");
        showdateDao.updatenew(s,count);
        showdateDao.updatenew(s1,count1);
        showdateDao.updatenew(s2,count2);
        int i= showdateDao.updatenew(s3,count3);
        String str = i >0?"success":"error";
        return str;
    }

    //数据库数据来源的实现方法，就是改变数据库表Date1中得数据,监控流量使用情况
    @RequestMapping("/getcloudupdata")
    public String updateDate1(QueryInfo queryInfo){

        String s = "已用流量";
        String s1 ="剩余流量";
        int count = fileDao.getFilsofallsize("%"+queryInfo.getQuery()+"%")/1024;// 获取数据总数
        System.out.println("count"+count);
        int count1 =40*1024-count;  //四个方法需要你自己根据具体业务实现
        showdateDao.updatenew2(s,count);
        int i= showdateDao.updatenew2(s1,count1);
        String str = i >0?"success":"error";
        return str;
    }

}

