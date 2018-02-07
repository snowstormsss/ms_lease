package com.snowstorms.ms_lease_client.scheduled;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
/**
 * @author  xieyucheng
 * @create  2018/2/7 17:47
 * @desc 定时执行任务类
 **/

@Component
public class ScheduledScan {
    @Scheduled(cron = "0/30 * * * * ?")
    public void scanOnlineUser(){
        System.out.println("执行定时扫描");
    }
}
