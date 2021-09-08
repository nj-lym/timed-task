package com.lym.timedtask.beans;

import lombok.Data;

import java.io.Serializable;

/**
 * stu_info
 * @author 
 */
@Data
public class StuInfo implements Serializable {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 2k评分
     */
    private String score;

    private static final long serialVersionUID = 1L;
}