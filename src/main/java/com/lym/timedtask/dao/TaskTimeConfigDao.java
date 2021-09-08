package com.lym.timedtask.dao;

import com.lym.timedtask.beans.TaskTimeConfig;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TaskTimeConfigDao {
    int deleteByPrimaryKey(Integer id);

    int insert(TaskTimeConfig record);

    int insertSelective(TaskTimeConfig record);

    TaskTimeConfig selectByPrimaryKey(Integer id);

    List<TaskTimeConfig> selectAll();

    int updateByPrimaryKeySelective(TaskTimeConfig record);

    int updateByPrimaryKey(TaskTimeConfig record);
}