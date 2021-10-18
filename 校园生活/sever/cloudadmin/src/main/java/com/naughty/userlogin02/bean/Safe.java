package com.naughty.userlogin02.bean;

public class Safe {
    private int id;
    private String createtime;
    private String  type;
    private String chirdtype;
    private String grade;
    private String shouhai;
    private String port;
    private String attck;
    private String newport;
    private String tcp_ip;
    private String yiqing;
    private String body;
    private  Boolean error;

    public Safe(int id, String createtime, String type, String chirdtype, String grade, String shouhai, String port, String attck, String newport, String tcp_ip, String yiqing, String body, Boolean error) {
        this.id = id;
        this.createtime = createtime;
        this.type = type;
        this.chirdtype = chirdtype;
        this.grade = grade;
        this.shouhai = shouhai;
        this.port = port;
        this.attck = attck;
        this.newport = newport;
        this.tcp_ip = tcp_ip;
        this.yiqing = yiqing;
        this.body = body;
        this.error = error;
    }

    public Boolean getError() {
        return error;
    }

    public void setError(Boolean error) {
        this.error = error;
    }

    public Safe() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getChirdtype() {
        return chirdtype;
    }

    public void setChirdtype(String chirdtype) {
        this.chirdtype = chirdtype;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getShouhai() {
        return shouhai;
    }

    public void setShouhai(String shouhai) {
        this.shouhai = shouhai;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getAttck() {
        return attck;
    }

    public void setAttck(String attck) {
        this.attck = attck;
    }

    public String getNewport() {
        return newport;
    }

    public void setNewport(String newport) {
        this.newport = newport;
    }

    public String getTcp_ip() {
        return tcp_ip;
    }

    public void setTcp_ip(String tcp_ip) {
        this.tcp_ip = tcp_ip;
    }

    public String getYiqing() {
        return yiqing;
    }

    public void setYiqing(String yiqing) {
        this.yiqing = yiqing;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
