package com.pj.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * @author Jack
 * @create 2018-11-13 16:29
 */
public class HelloScheduler {
    public static void main(String[] args) throws SchedulerException {
        JobDetail jobDetail = JobBuilder.newJob(HelloJob.class).withIdentity("helloJob", "group1")
                .usingJobData("message", "jobdetail")
                .usingJobData("float", 1.25f)
                .build();
        System.out.println("jobDetail in main hashCode is " + jobDetail.hashCode());
        Trigger trigger = TriggerBuilder.newTrigger().withIdentity("myTrigger", "group")
                .startNow().withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(2).repeatForever())
                .usingJobData("message", "trigger").usingJobData("double", 2.5)
                .build();
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();
        scheduler.start();
        java.util.Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-HH-dd hh:mm:ss");
        System.out.println("current time is " + simpleDateFormat.format(calendar.getTime()));
        scheduler.scheduleJob(jobDetail, trigger);
    }
}
