package com.lym.timedtask.task;

import com.alibaba.fastjson.JSONObject;
import com.lym.timedtask.beans.StuInfo;
import com.lym.timedtask.beans.StuInfoExample;
import com.lym.timedtask.dao.StuInfoDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Description 创建多线程定时任务
 * @Auther lym
 * @Date 2021-09-08 13:45
 * @Version 1.0
 */
@Slf4j
@Component
public class ScheduleTaskThree {

    @Autowired
    private StuInfoDao stuInfoDao;

    @Scheduled(fixedRate = 3000)
    @Async //声明方法为异步调用
    public void task1() {
        List<StuInfo> list = stuInfoDao.selectByExample(new StuInfoExample());
        log.info("方式三, 第一个线程 : " + JSONObject.toJSONString(list));
        System.out.println("第一个线程: " + JSONObject.toJSONString(list));
    }

    @Async //声明方法为异步调用
    @Scheduled(fixedRate = 5000)
    public void task2() {
        List<StuInfo> list = stuInfoDao.selectByExample(new StuInfoExample());
        log.info("方式三, 第二个线程 : " + JSONObject.toJSONString(list));
        System.out.println("第二个线程: " + JSONObject.toJSONString(list));
    }

    @Async //声明方法为异步调用
    @Scheduled(fixedRate = 7000)
    public void task3() {
        List<StuInfo> list = stuInfoDao.selectByExample(new StuInfoExample());
        log.info("方式三, 第三个线程 : " + JSONObject.toJSONString(list));
        System.out.println("第三个线程: " + JSONObject.toJSONString(list));
    }

}
