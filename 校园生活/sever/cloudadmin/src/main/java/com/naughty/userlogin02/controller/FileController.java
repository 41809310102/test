package com.naughty.userlogin02.controller;

import com.alibaba.fastjson.JSON;
import com.naughty.userlogin02.bean.File;
import com.naughty.userlogin02.bean.QueryInfo;
import com.naughty.userlogin02.dao.FileDao;
import com.naughty.userlogin02.util.OBSUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;

import static java.lang.System.out;
import static java.lang.System.setOut;

@RestController
public class FileController {

@Autowired
 private FileDao fileDao;
//搜索
    @CrossOrigin
    @RequestMapping("/searchfile")
    public String getUserList(QueryInfo queryInfo){
        System.out.println(queryInfo);
        int numbers = fileDao.getFileCounts("%"+queryInfo.getQuery()+"%");// 获取数据总数
        int pageStart = (queryInfo.getPageNum()-1)*queryInfo.getPageSize();
        List<File> files = fileDao.getAllFile("%"+queryInfo.getQuery()+"%",pageStart,queryInfo.getPageSize());
        HashMap<String, Object> res = new HashMap<>();
        res.put("numbers",numbers);
        for(int i = 0;i<files.size();i++){
            SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
            String datestring = date.format(files.get(i).getCreatetime());
            files.get(i).setCreatetime1(datestring);
            System.out.println(files.get(i).toString());
        }
        res.put("data",files);
        System.out.println("总条数："+numbers);
        String users_json = JSON.toJSONString(res);
        return users_json;
    }




    @CrossOrigin
    @RequestMapping("/allImagefile")
    public String getFilesofimg(QueryInfo queryInfo){
        System.out.println(queryInfo);
        String s = ".png";
        String s1=".jpg";
        int numbers = fileDao.getFilsofimageCounts("%"+s+"%","%"+s1+"%","%"+queryInfo.getQuery()+"%");// 获取数据总数
        int pageStart = (queryInfo.getPageNum()-1)*queryInfo.getPageSize();
        List<File> files = fileDao.getAllimagefile("%"+".png"+"%","%"+".jpg"+"%","%"+queryInfo.getQuery()+"%",pageStart,queryInfo.getPageSize());
        HashMap<String, Object> res = new HashMap<>();
        res.put("numbers",numbers);

        for(int i = 0;i<files.size();i++){
            SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
            String datestring = date.format(files.get(i).getCreatetime());
            files.get(i).setCreatetime1(datestring);
            System.out.println(files.get(i).toString());
        }
        res.put("data",files);
        System.out.println("总条数："+numbers);
        String files_json = JSON.toJSONString(res);
        return files_json;
    }

    
    @RequestMapping("/allMusicfile")
    public String getFilesofmusic(QueryInfo queryInfo){
        System.out.println(queryInfo);
        int numbers = fileDao.getFilsofimageCounts("%"+".aac"+"%","%"+".mp3"+"%","%"+queryInfo.getQuery()+"%");// 获取数据总数
        int pageStart = (queryInfo.getPageNum()-1)*queryInfo.getPageSize();
        List<File> files = fileDao.getAllimagefile("%"+".aac"+"%","%"+".mp3"+"%","%"+queryInfo.getQuery()+"%",pageStart,queryInfo.getPageSize());
        HashMap<String, Object> res = new HashMap<>();
        res.put("numbers",numbers);
        res.put("data",files);
        for(int i = 0;i<files.size();i++){
            SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
            String datestring = date.format(files.get(i).getCreatetime());
            files.get(i).setCreatetime1(datestring);
            System.out.println(files.get(i).toString());
        }
        System.out.println("总条数："+numbers);
        String files_json = JSON.toJSONString(res);
        return files_json;
    }


    @RequestMapping("/allVideofile")
    public String getFilesofvideo(QueryInfo queryInfo){
        System.out.println(queryInfo);
        int numbers = fileDao.getFilsofimageCounts("%"+".mp4"+"%","%"+".avi"+"%","%"+queryInfo.getQuery()+"%");// 获取数据总数
        int pageStart = (queryInfo.getPageNum()-1)*queryInfo.getPageSize();
        List<File> files = fileDao.getAllimagefile("%"+".mp4"+"%","%"+".avi"+"%","%"+queryInfo.getQuery()+"%",pageStart,queryInfo.getPageSize());
        HashMap<String, Object> res = new HashMap<>();

        res.put("numbers",numbers);
        for(int i = 0;i<files.size();i++){
            SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
            String datestring = date.format(files.get(i).getCreatetime());
            files.get(i).setCreatetime1(datestring);
            System.out.println(files.get(i).toString());
        }
        res.put("data",files);
        System.out.println("总条数："+numbers);
        String files_json = JSON.toJSONString(res);
        return files_json;
    }


    @RequestMapping("/allDocxfile")
    public String getFilesofdesc(QueryInfo queryInfo){
        System.out.println(queryInfo);
        int numbers = fileDao.getFilsofimageCounts("%"+".docx"+"%","%"+".xml"+"%","%"+queryInfo.getQuery()+"%");// 获取数据总数
        int pageStart = (queryInfo.getPageNum()-1)*queryInfo.getPageSize();
        List<File> files = fileDao.getAllimagefile("%"+".docx"+"%","%"+".pdf"+"%","%"+queryInfo.getQuery()+"%",pageStart,queryInfo.getPageSize());
        HashMap<String, Object> res = new HashMap<>();
        res.put("numbers",numbers);
        res.put("data",files);
        for(int i = 0;i<files.size();i++){
            SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
            String datestring = date.format(files.get(i).getCreatetime());
            files.get(i).setCreatetime1(datestring);
            System.out.println(files.get(i).toString());
        }
        System.out.println("总条数："+numbers);
        String files_json = JSON.toJSONString(res);
        return files_json;
    }


    @RequestMapping("/deleteFile")
    public String Del(int id, HttpSession session, HttpServletRequest req) {
        //判断该用户是否拥有此文件
        int i = 0;
        try {
            String login_user = (String) session.getAttribute("user_name");
            String filename = fileDao.findFile(id).getFilename(); //查出文件名
            out.println(filename+"id:"+id);
            if (filename!=null) {
                fileDao.deleteFileById(id); //删除数据库的该文件记录
                //从硬盘上删除文件
                String storepath = new String("C:" + java.io.File.separator + "upload" + java.io.File.separator + login_user + java.io.File.separator);
                storepath = storepath + filename;
                out.println(storepath);
                //obs
                java.io.File file = new java.io.File(storepath);
                OBSUtils obs = new OBSUtils();
                obs.deleteFile(filename);
                if (file.exists()) {
                    file.delete();

                } else {
                    req.setAttribute("globalmessage", "文件已不存在");
                    return "success";
                }
                return "success";
            } else { //不通过，可能是人为篡改数据，转发至全局消息页面
                req.setAttribute("globalmessage", "该文件可能不属于你");
                return "success";
            }
        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("globalmessage", "该文件可能不属于你");
            return "success";
        }
    }

}
