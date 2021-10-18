package com.naughty.userlogin02.bean;


public class Flow {
    private String responsetime;
    private String equipment;
    private String  ipv4;
    private double  Port;
    private String  adress;
    private String nowPort;
    private String sendpacked;
    private String bitsend;
    private String starttime;
    private String F11;
    private String rulenum;
    private String intsrface;
    private  String AAA;
    private  String body;
    private  int id;
    private boolean error;


    public Flow() {
    }

    public Flow(String responsetime, String equipment, String ipv4, double port, String adress, String nowPort, String sendpacked, String bitsend, String starttime, String f11, String rulenum, String intsrface, String AAA, String body, int id, boolean error) {
        this.responsetime = responsetime;
        this.equipment = equipment;
        this.ipv4 = ipv4;
        Port = port;
        this.adress = adress;
        this.nowPort = nowPort;
        this.sendpacked = sendpacked;
        this.bitsend = bitsend;
        this.starttime = starttime;
        F11 = f11;
        this.rulenum = rulenum;
        this.intsrface = intsrface;
        this.AAA = AAA;
        this.body = body;
        this.id = id;
        this.error = error;
    }

    public String getResponsetime() {
        return responsetime;
    }

    public void setResponsetime(String responsetime) {
        this.responsetime = responsetime;
    }

    public String getEquipment() {
        return equipment;
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }

    public String getIpv4() {
        return ipv4;
    }

    public void setIpv4(String ipv4) {
        this.ipv4 = ipv4;
    }

    public double getPort() {
        return Port;
    }

    public void setPort(double port) {
        Port = port;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getNowPort() {
        return nowPort;
    }

    public void setNowPort(String nowPort) {
        this.nowPort = nowPort;
    }

    public String getSendpacked() {
        return sendpacked;
    }

    public void setSendpacked(String sendpacked) {
        this.sendpacked = sendpacked;
    }

    public String getBitsend() {
        return bitsend;
    }

    public void setBitsend(String bitsend) {
        this.bitsend = bitsend;
    }

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    public String getF11() {
        return F11;
    }

    public void setF11(String f11) {
        F11 = f11;
    }

    public String getRulenum() {
        return rulenum;
    }

    public void setRulenum(String rulenum) {
        this.rulenum = rulenum;
    }

    public String getIntsrface() {
        return intsrface;
    }

    public void setIntsrface(String intsrface) {
        this.intsrface = intsrface;
    }

    public String getAAA() {
        return AAA;
    }

    public void setAAA(String AAA) {
        this.AAA = AAA;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean getError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }
}