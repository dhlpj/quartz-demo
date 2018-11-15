package com.pj.timer;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Timer;

/**
 * @author Jack
 * @create 2018-11-13 10:28
 */
public class MyTimer {
    public static void main(String[] args) throws InterruptedException {
        Timer timer = new Timer();
        MyTimerTask timerTask1 = new MyTimerTask("demo1");
        MyTimerTask timerTask2 = new MyTimerTask("demo2");
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(format.format(calendar.getTime()));
        timer.schedule(timerTask1,2000,3000);
        //timer.schedule(timerTask2,1000,1000);
        System.out.println("timerTask1 "+format.format(timerTask1.scheduledExecutionTime()));
        Thread.sleep(3000);
        //System.out.println(format.format(Calendar.getInstance().getTime()));
        timer.cancel();
        Thread.sleep(3000);
        //System.out.println(timer.purge());
    }
}
