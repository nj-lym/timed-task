package com.lym.timedtask.beans;

import java.io.Serializable;
import lombok.Data;

/** 定时器指定时间配置表
 * task_time_config
 * @author 
 */
@Data
public class TaskTimeConfig implements Serializable {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 定时任务执行时间配置
     */
    private String cron;

    private static final long serialVersionUID = 1L;
}