package com.pj.timer;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author Jack
 * @create 2018-11-13 13:59
 */
public class DifferenceTest {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("current time is "+format.format(calendar.getTime()));
        //1、当前时间已经超过了设置的执行时间
        calendar.add(Calendar.SECOND,-6);
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                System.out.println("执行的时间："+format.format(scheduledExecutionTime()));
            }
        },calendar.getTime(),4000);
        /*Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("执行的时间："+format.format(scheduledExecutionTime()));
            }
        },calendar.getTime(),2000);
        */
    }
}
