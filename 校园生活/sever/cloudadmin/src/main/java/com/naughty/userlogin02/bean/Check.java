package com.naughty.userlogin02.bean;

public class Check {
    private  int id;
    private  String sendtime;
    private  String createtime;
    private  String ipv4;
    private  String type;
    private  String url;
    private  String method;
    private  String doit;
    private  String because;
    private  String body;
    private   Boolean error;
    public Check() {

    }

    public Check(int id, String sendtime, String createtime, String ipv4, String type, String url, String method, String doit, String because, String body, Boolean error) {
        this.id = id;
        this.sendtime = sendtime;
        this.createtime = createtime;
        this.ipv4 = ipv4;
        this.type = type;
        this.url = url;
        this.method = method;
        this.doit = doit;
        this.because = because;
        this.body = body;
        this.error = error;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSendtime() {
        return sendtime;
    }

    public void setSendtime(String sendtime) {
        this.sendtime = sendtime;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getIpv4() {
        return ipv4;
    }

    public void setIpv4(String ipv4) {
        this.ipv4 = ipv4;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getDoit() {
        return doit;
    }

    public void setDoit(String doit) {
        this.doit = doit;
    }

    public String getBecause() {
        return because;
    }

    public void setBecause(String because) {
        this.because = because;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Boolean getError() {
        return error;
    }

    public void setError(Boolean error) {
        this.error = error;
    }
}
