package com.naughty.userlogin02.bean;

import java.sql.Date;

public class File {
    private int id;
    private String filename;
    private String filepath;
    private String filesize;
    private Date createtime;

    private String createtime1;
    private int canshare;
    private int user_id;
    private int sharenums;

    public int getId() {
        return id;
    }

    public String getCreatetime1() {
        return createtime1;
    }

    public void setCreatetime1(String createtime1) {
        this.createtime1 = createtime1;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }

    public String getFilesize() {
        return filesize;
    }

    public void setFilesize(String filesize) {
        this.filesize = filesize;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public int getCanshare() {
        return canshare;
    }

    public void setCanshare(int canshare) {
        this.canshare = canshare;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getSharenums() {
        return sharenums;
    }

    public void setSharenums(int sharenums) {
        this.sharenums = sharenums;
    }

    @Override
    public String toString() {
        return "File{" +
                "id=" + id +
                ", filename='" + filename + '\'' +
                ", filepath='" + filepath + '\'' +
                ", filesize='" + filesize + '\'' +
                ", createtime=" + createtime +
                ", createtime1='" + createtime1 + '\'' +
                ", canshare=" + canshare +
                ", user_id=" + user_id +
                ", sharenums=" + sharenums +
                '}';
    }

    public File() {

    }
}
