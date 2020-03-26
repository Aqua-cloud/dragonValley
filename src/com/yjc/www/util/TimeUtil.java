package com.yjc.www.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtil {

    private TimeUtil() {
    }

    public static String timeToString(Date date) {
        //Date指定格式：yyyy-MM-dd HH:mm:ss:SSS
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String timeStr = simpleDateFormat.format(date);//format()方法将Date转换成指定格式的String
        return timeStr;
    }

    public static String dateToString(Date date) {
        //Date指定格式：yyyy-MM-dd
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd ");
        String dateStr = simpleDateFormat.format(date);//format()方法将Date转换成指定格式的String
        return dateStr;
    }

}
