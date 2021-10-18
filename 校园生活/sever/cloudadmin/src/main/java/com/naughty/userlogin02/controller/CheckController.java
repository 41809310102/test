package com.naughty.userlogin02.controller;

import com.alibaba.fastjson.JSON;
import com.naughty.userlogin02.bean.Check;
import com.naughty.userlogin02.bean.QueryInfo;
import com.naughty.userlogin02.dao.CheckDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

@RestController
public class CheckController {
    @Autowired
    CheckDao checkDao;
    @CrossOrigin
    @RequestMapping("/allCheck")
    public String getUserList(QueryInfo queryInfo){
        System.out.println(queryInfo);
        int numbers = checkDao.getFlowCounts("%"+queryInfo.getQuery()+"%");// 获取数据总数
        int pageStart = (queryInfo.getPageNum()-1)*queryInfo.getPageSize();
        List<Check> checks= checkDao.getAllFlow("%"+queryInfo.getQuery()+"%",pageStart,queryInfo.getPageSize());
     /*   for(int i = 0;i< flows.size();i++){
            if(!flows.get(i).getEquipment().equals("出口防火墙")){
                boolean flag = true;
                flows.get(i).setError(flag);
            }
        }*/

        //校验
        int n =  foundFlag(getCount(checks));
        System.out.println("计算的阈值是"+n);
        isOk(checks,n);
        //封装校验后的流量日志
        HashMap<String, Object> res = new HashMap<>();
        res.put("numbers",numbers);
        res.put("data",checks);
        System.out.println("流量日志总条数："+numbers);
        String flow_json= JSON.toJSONString(res);
        System.out.println(flow_json.toString());
        return flow_json;
    }
    //通过校验浏览流量日志异常算法
    public static Stack<String> getCount(List<Check> flows){
        if(flows.size()<=0) return null;
        Stack<String> stack = new Stack<>();
        int count=0;
        for(int i = 0;i<flows.size();i++){
            String useradress = flows.get(i).getIpv4();
            String goadress= flows.get(i).getUrl();
            for(int j = 0;j<flows.size();j++){
                if(useradress.equals(flows.get(j).getIpv4())&&goadress.equals(flows.get(j).getUrl())){
                    count++;
                }
            }
            System.out.print(count+" ");
            stack.push(String.valueOf(count));
            count=0;
        }
        return stack;
    }


    public  static   int foundFlag(Stack<String> stack){
        if(stack.size()<=0) return -1;
        int len = stack.size();
        int[] res = new int[len];
        for(int i = 0;i<len;i++){
            res[i] = Integer.parseInt(stack.pop());
        }
        //计算阈值
        int sum=0;
        for(int i = 0;i<len;i++){
            sum+=res[i];
        }
        int flag = sum/len;//该数据就是该时间片上异常流量出现次数


        return (flag+flag/2+1);


        //使用快排获取最大值
        /*  quickSortByStack(res);*/

    }
    //非递归实现，递归往往数据量太多导致算法耗时高
   /* public static void quickSortByStack(int[] arr){
        if(arr.length <= 0) return;
        Stack<Integer> stack = new Stack<Integer>();

        //初始状态的左右指针入栈
        stack.push(0);
        stack.push(arr.length - 1);
        while(!stack.isEmpty()){
            int high = stack.pop();     //出栈进行划分
            int low = stack.pop();
            int pivotIdx = QuickSort1(arr, low, high);
            //保存中间变量
            if(pivotIdx > low) {
                stack.push(low);
                stack.push(pivotIdx - 1);
            }
            if(pivotIdx < high && pivotIdx >= 0){
                stack.push(pivotIdx + 1);
                stack.push(high);
            }
        }
    }

    private static int QuickSort1(int[] arr, int low, int high){
        if(arr.length <= 0) return -1;
        if(low >= high) return -1;
        int l = low;
        int r = high;

        int pivot = arr[l];    //挖坑1：保存基准的值
        while(l < r){
            while(l < r && arr[r] >= pivot){  //坑2：从后向前找到比基准小的元素，插入到基准位置坑1中
                r--;
            }
            arr[l] = arr[r];
            while(l < r && arr[l] <= pivot){   //坑3：从前往后找到比基准大的元素，放到刚才挖的坑2中
                l++;
            }
            arr[r] = arr[l];
        }
        arr[l] = pivot;   //基准值填补到坑3中，准备分治递归快排
        System.out.println(Arrays.toString(arr));
        return l;
    }*/
    public  static void isOk(List<Check> checks,int flag){
        int count=0;
        System.out.println("计算同一ip地址单位时间访问次数");
        for(int i = 0;i<checks.size();i++){
            String useradress = checks.get(i).getIpv4();
            String goadress= checks.get(i).getUrl();
            for(int j = 0;j<checks.size();j++){
                if(useradress.equals(checks.get(j).getIpv4())&&goadress.equals(checks.get(j).getUrl())){
                    count++;
                }
            }
            System.out.print(count+" ");
            if(count>flag){
                checks.get(i).setError(true);
            }
            count=0;
        }
    }


    @RequestMapping("/checkError")
    public String updateUserState(@RequestParam("id") Integer  id,
                                  @RequestParam("error") Boolean error){
        int i = checkDao.updateState(id, error);
        System.out.println("流量日志编号:"+id);
        System.out.println("流量日志是否异常:"+error);
        String str = i >0?"success":"error";
        return str;
    }

    @RequestMapping("/deletecheck")
    public String deleteFlow(int id){
        System.out.println(id);
        int i = checkDao.deleteFlow(id);
        String str = i >0?"success":"error";
        return str;
    }
}
