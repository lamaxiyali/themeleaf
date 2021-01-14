package com.example.themeleaf.dao;

import com.example.themeleaf.entity.TaskPart;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import javax.swing.*;

@Mapper
@Repository
public interface TaskPartMapper {
    int deleteByPrimaryKey(@Param("task_id") String task_id, @Param("task_userid") String task_userid);

    int insert(TaskPart record);

    List<TaskPart> selectAll();

    List<TaskPart> selectByPart(String part);

    List<TaskPart> selectByTask(String task);
}
