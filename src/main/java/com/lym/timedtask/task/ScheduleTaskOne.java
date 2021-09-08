package com.lym.timedtask.task;

import com.alibaba.fastjson.JSONObject;
import com.lym.timedtask.beans.StuInfo;
import com.lym.timedtask.beans.StuInfoExample;
import com.lym.timedtask.dao.StuInfoDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.List;

/**
 * @Description 定时任务创建方式一 使用@Schedule注解 静态创建
 * @Auther lym
 * @Date 2021-09-08 10:51
 * @Version 1.0
 */
@Slf4j
@Configuration
public class ScheduleTaskOne {

    @Autowired
    private StuInfoDao stuInfoDao;

//    @Scheduled(cron = "0/5 * * * * ?") //每隔 5 秒执行一次
//    @Scheduled(fixedRate = 5000) //每隔 5 秒执行一次
    public void task() {
        List<StuInfo> list = stuInfoDao.selectByExample(new StuInfoExample());
        log.info("创建定时任务方式一 定时查询数据: " + JSONObject.toJSONString(list));
        System.out.println("创建定时任务方式一 定时查询数据: " + JSONObject.toJSONString(list));
    }

}
