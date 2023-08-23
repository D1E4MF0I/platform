package com.than.time;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Than
 * @package: com.than.time
 * @className: TimeUtil
 * @description: TODO
 * @date: 2023/8/23 18:11
 */
public class TimeUtil {
    private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒 E ");

    public static String getThisTime(){
        Date now = new Date();
        return simpleDateFormat.format(now);
    }


}
