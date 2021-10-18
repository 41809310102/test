package com.naughty.userlogin02.controller;

import com.alibaba.fastjson.JSON;
import com.naughty.userlogin02.bean.Check;
import com.naughty.userlogin02.bean.QueryInfo;
import com.naughty.userlogin02.bean.Safe;
import com.naughty.userlogin02.dao.CheckDao;
import com.naughty.userlogin02.dao.SafeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

@RestController
public class SafeController {
    @Autowired
    SafeDao safeDao;
    @CrossOrigin
    @RequestMapping("/allsafe")
    public String getUserList(QueryInfo queryInfo){
        System.out.println(queryInfo);
        int numbers = safeDao.getFlowCounts("%"+queryInfo.getQuery()+"%");// 获取数据总数
        int pageStart = (queryInfo.getPageNum()-1)*queryInfo.getPageSize();
        List<Safe> safes= safeDao.getAllFlow("%"+queryInfo.getQuery()+"%",pageStart,queryInfo.getPageSize());
     /*   for(int i = 0;i< flows.size();i++){
            if(!flows.get(i).getEquipment().equals("出口防火墙")){
                boolean flag = true;
                flows.get(i).setError(flag);
            }
        }*/
        for(int i = 0;i<safes.size();i++){
            if(safes.get(i).getGrade().equals("\t\n" +
                    "Warning")){
                System.out.print(safes.get(i).getGrade());
                safes.get(i).setError(true);
            }
        }


        //封装校验后的流量日志
        HashMap<String, Object> res = new HashMap<>();
        res.put("numbers",numbers);
        res.put("data",safes);
        System.out.println("威胁日志总条数："+numbers);
        String flow_json= JSON.toJSONString(res);
        System.out.println(flow_json.toString());
        return flow_json;
    }





    @RequestMapping("/safeError")
    public String updateUserState(@RequestParam("id") Integer  id,
                                  @RequestParam("error") Boolean error){
        int i = safeDao.updateState(id, error);
        System.out.println("流量日志编号:"+id);
        System.out.println("流量日志是否异常:"+error);
        String str = i >0?"success":"error";
        return str;
    }

    @RequestMapping("/deletesafe")
    public String deleteFlow(int id){
        System.out.println(id);
        int i = safeDao.deleteFlow(id);
        String str = i >0?"success":"error";
        return str;
    }
}
