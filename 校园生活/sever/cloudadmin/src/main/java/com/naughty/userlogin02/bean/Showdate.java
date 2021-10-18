package com.naughty.userlogin02.bean;

public class Showdate {
    private  String name;
    private  String itemStyle;
    private  int value;


    public Showdate() {

    }

    public Showdate(String name, String itemStyle, int value) {
        this.name = name;
        this.itemStyle = itemStyle;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName1(String name) {
        this.name= name;
    }

    public String getItemStyle() {
        return itemStyle;
    }

    public void setItemStyle(String itemStyle) {
        this.itemStyle = itemStyle;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Showdate{" +
                "name='" + name + '\'' +
                ", itemStyle='" + itemStyle + '\'' +
                ", value=" + value +
                '}';
    }
}
