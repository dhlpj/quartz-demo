package com.pj.quartz;

import org.quartz.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * @author Jack
 * @create 2018-11-13 16:25
 */
public class HelloJob implements Job {
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        JobDetail jobDetail = jobExecutionContext.getJobDetail();
        System.out.println("jobDetail in HelloJob hashCode is "+jobDetail.hashCode());
        System.out.println("jobDetail name and group are "+jobDetail.getKey().getName()+":"+jobDetail.getKey().getGroup());
        Trigger trigger = jobExecutionContext.getTrigger();
        System.out.println("trigger name and group are "+trigger.getKey().getName()+":"+trigger.getKey().getGroup());
        JobDataMap jobdetDataMap = jobDetail.getJobDataMap();
        System.out.println("jobDetail message is "+jobdetDataMap.getString("message"));
        System.out.println("jobDetail float is "+jobdetDataMap.getFloat("float"));
        JobDataMap triDataMap = trigger.getJobDataMap();
        System.out.println("trigger message is "+triDataMap.getString("message"));
        System.out.println("trigger double is "+triDataMap.getDouble("double"));
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-HH-dd hh:mm:ss");
        System.out.println("current exec time is "+simpleDateFormat.format(calendar.getTime()));
        System.out.println("hello Job");
    }
}
