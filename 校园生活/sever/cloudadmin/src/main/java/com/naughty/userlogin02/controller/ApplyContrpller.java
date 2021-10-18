package com.naughty.userlogin02.controller;

import com.alibaba.fastjson.JSON;
import com.naughty.userlogin02.bean.Apply;
import com.naughty.userlogin02.bean.QueryInfo;
import com.naughty.userlogin02.dao.ApplyDao;
import com.naughty.userlogin02.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;

@RestController
public class ApplyContrpller {

    @Autowired
    public ApplyDao applyDao;

    @Autowired

    public UserDao userDao;

    @CrossOrigin
    @RequestMapping("/allApply")
    public String getAllapply(QueryInfo queryInfo){
        System.out.println(queryInfo);
        int numbers = applyDao.getApplyCounts("%"+queryInfo.getQuery()+"%");// 获取数据总数
        int pageStart = (queryInfo.getPageNum()-1)*queryInfo.getPageSize();
        List<Apply> applys = applyDao.getAllApply("%"+queryInfo.getQuery()+"%",pageStart,queryInfo.getPageSize());
        HashMap<String, Object> res = new HashMap<>();
        res.put("numbers",numbers);
        for(int i = 0;i<applys.size();i++){
            SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
            String datestring = date.format(applys.get(i).getCreatetime());
            applys.get(i).setCreatetime1(datestring);
            System.out.println(applys.get(i).toString());
        }
        res.put("data",applys);
        System.out.println("申请总条数："+numbers);
        String applys_json = JSON.toJSONString(res);
        return applys_json;
    }

    //修改vip
    @RequestMapping("/applyisvip")
    public String updateApplyIsvip(@RequestParam("id") Integer  id,
                                   @RequestParam("isvip") Boolean isvip,
                                   @RequestParam("applymanname") String applymannname){
        int i = applyDao.updateIsvip(id,isvip);
        System.out.println("申请编号:"+id);
        System.out.println("用户vip状态:"+isvip);
        if(isvip){
            userDao.updateisvip(applymannname,1);
        }else{
            userDao.updateisvip(applymannname,0);
        }
        String str = i >0?"success":"error";
        return str;
    }

    //修改admin权限
    @RequestMapping("/applyisadmin")
    public String updateApplyIsadmin(@RequestParam("id") Integer  id,
                                     @RequestParam("isadmin") Boolean isadmin,
                                     @RequestParam("applymanname") String applymannname){
        int i = applyDao.updateIsadmin(id,isadmin);
        System.out.println("申请编号:"+id);
        userDao.updateisadmin(applymannname,isadmin);
        System.out.println("用户管理权限状态:"+isadmin);
        String str = i >0?"success":"error";
        return str;
    }

    //修改delect权限
    @RequestMapping("/applyisdelect")
    public String updateApplyIsdelect(@RequestParam("id") Integer  id,
                                      @RequestParam("isdelect") Boolean isdelect,
                                      @RequestParam("applymanname") String applymannname){
        int i = applyDao.updateIsdelect(id,isdelect);
        userDao.updateisdelect(applymannname,isdelect);
        System.out.println("申请编号:"+id);
        System.out.println("用户公共资源删除权限状态:"+isdelect);
        String str = i >0?"success":"error";
        return str;
    }
    //移除申请
    @RequestMapping("/deleteApply")
    public String deleteApply(int id){
        System.out.println(id);
        int i = applyDao.deleteApply(id);
        String str = i >0?"success":"error";
        return str;
    }

}
