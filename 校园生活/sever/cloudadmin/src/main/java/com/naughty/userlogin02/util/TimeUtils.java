package com.naughty.userlogin02.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtils {


    public  String  timeUtils(Date str){

        if(str==null) return "null";

        SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");

        String datestring = date.format(str);

        return  datestring;
    }
}
