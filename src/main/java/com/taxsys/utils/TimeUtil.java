package com.taxsys.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Sinner on 2017/6/18.
 */
public class TimeUtil {
    public static String now() {
        Date now = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = dateFormat.format( now );
        return time;
    }
    public static String formatDate(Date date) {
        // 初始化时设置 日期和时间模式
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        // 修改日期和时间模式
        sdf.applyPattern("yyyy-MM-dd");
        return sdf.format(date);
    }
}
