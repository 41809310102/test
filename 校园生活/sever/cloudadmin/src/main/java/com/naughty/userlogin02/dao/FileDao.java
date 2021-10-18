package com.naughty.userlogin02.dao;

import com.naughty.userlogin02.bean.File;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface FileDao {

    //获得文件信息
    public int getFilsofimageCounts(@Param("filename") String filename,@Param("filename1") String filename1,
                                    @Param("filename2") String filename2);
    //获得所有信息
    public List<File> getAllimagefile(@Param("filename") String filename,@Param("filename1") String filename1,
                                      @Param("filename2") String filename2,  @Param("pageStart") int pageStart,
                                      @Param("pageSize") int pageSize);


    //获得搜索文件
    public int getFileCounts(@Param("filename") String filename);

    //获得搜索的所有文件信息
    public List<File> getAllFile(@Param("filename") String filename, @Param("pageStart") int pageStart,
                                      @Param("pageSize") int pageSize);



    public int getFilsofallsize(@Param("filename") String filename);

   //查找文件名称
    public File findFile(@Param("id") int id);

    //删除文件
    public int deleteFileById(@Param("id")  int id);

}
