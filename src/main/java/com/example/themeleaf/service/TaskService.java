package com.example.themeleaf.service;

import com.example.themeleaf.entity.SenseTaskInfo;
import com.example.themeleaf.entity.TaskPart;

import java.util.List;

public interface TaskService {
    void addTask(SenseTaskInfo senseTaskInfo);

    List<SenseTaskInfo> allTask();

    List<SenseTaskInfo> getInfoList(int before, int after);

    int count();

    List<String> getCompanys();

    int getAllValue();

    List<TaskPart> selectByPart(String part);

    List<TaskPart> selectByTask(String task);

    int partIn(String tid, String username);
}
