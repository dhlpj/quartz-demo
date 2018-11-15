package com.pj.timer;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * @author Jack
 * @create 2018-11-13 11:09
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(format.format(calendar.getTime()));
        Thread.sleep(2000);
        System.out.println(format.format(calendar.getTime()));
    }
}
