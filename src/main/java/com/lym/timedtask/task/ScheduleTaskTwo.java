package com.lym.timedtask.task;

import com.alibaba.fastjson.JSONObject;
import com.lym.timedtask.beans.StuInfo;
import com.lym.timedtask.beans.StuInfoExample;
import com.lym.timedtask.beans.TaskTimeConfig;
import com.lym.timedtask.dao.StuInfoDao;
import com.lym.timedtask.dao.TaskTimeConfigDao;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description 创建定时任务 方式二
 * 利用数据库中配置的 执行时间 动态的执行(不需要每次都重启应用)
 * 修改配置时间后 定时任务执行时间自动修改
 * @Auther lym
 * @Date 2021-09-08 11:13
 * @Version 1.0
 */
@Slf4j
//@Component
public class ScheduleTaskTwo implements SchedulingConfigurer {

    @Autowired
    private TaskTimeConfigDao timeConfigDao;
    @Autowired
    private StuInfoDao stuInfoDao;

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        taskRegistrar.addTriggerTask(new Runnable() {
            @Override
            public void run() {
                List<StuInfo> list = stuInfoDao.selectByExample(new StuInfoExample());
                log.info("方式二 定时查询数据: " + JSONObject.toJSONString(list));
                System.out.println("方式二 定时查询数据: " + JSONObject.toJSONString(list));
            }
        }, triggerContext -> {
            //查询 执行时间配置的 结果 并对结果集以id进行 降序 排序 然后 取第一个
            String cron = timeConfigDao.selectAll().stream().sorted(new Comparator<TaskTimeConfig>() {
                @Override
                //设置比较条件 用来排序 结果>0 降序
                public int compare(TaskTimeConfig o1, TaskTimeConfig o2) {
                    return o2.getId() - o1.getId();
                }
            }).collect(Collectors.toList()).get(0).getCron();

            if (StringUtils.isEmpty(cron)) {
                //如果查询为null 则默认设置为 每隔5 秒执行一次
                cron = "0/5 * * * * ?";
            }
            //返回执行周期
            return new CronTrigger(cron).nextExecutionTime(triggerContext);
        });
    }
}
