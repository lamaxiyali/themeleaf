package com.example.themeleaf.service.impl;

import com.example.themeleaf.dao.SenseTaskInfoMapper;
import com.example.themeleaf.dao.TaskPartMapper;
import com.example.themeleaf.entity.SenseTaskInfo;
import com.example.themeleaf.entity.TaskPart;
import com.example.themeleaf.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    SenseTaskInfoMapper senseTaskInfoMapper;
    @Autowired
    TaskPartMapper taskPartMapper;
    @Override
    public void addTask(SenseTaskInfo senseTaskInfo) {
        senseTaskInfoMapper.insert(senseTaskInfo);
    }

    @Override
    public List<SenseTaskInfo> allTask() {
        System.out.println(senseTaskInfoMapper.selectAll());
        return senseTaskInfoMapper.selectAll();
    }

    @Override
    public List<SenseTaskInfo> getInfoList(int before, int after) {
        System.out.println(senseTaskInfoMapper.getInfoList(before, after));
        return senseTaskInfoMapper.getInfoList(before, after);
    }

    @Override
    public int count() {
        return senseTaskInfoMapper.count();
    }

    @Override
    public List<String> getCompanys() {
        List<SenseTaskInfo> senseTaskInfos = senseTaskInfoMapper.selectAll();
        List<String> com = new ArrayList<>();
        for (SenseTaskInfo s: senseTaskInfos
             ) {
            com.add(s.getTask_from());
        }
        List newcom = com.stream().distinct().collect(Collectors.toList());
        return newcom;
    }

    @Override
    public int getAllValue() {
        List<SenseTaskInfo> senseTaskInfos = senseTaskInfoMapper.selectAll();
        int coin = 0;
        for (SenseTaskInfo s: senseTaskInfos
             ) {
            coin += s.getTask_price();
        }
        return coin;
    }

    @Override
    public List<TaskPart> selectByPart(String part) {
        System.out.println(part);
        System.out.println(taskPartMapper.selectByPart(part));
        System.out.println(taskPartMapper.selectByPart("admin"));
        return taskPartMapper.selectByPart(part);
    }

    @Override
    public List<TaskPart> selectByTask(String task) {
        return taskPartMapper.selectByTask(task);
    }

    @Override
    public int partIn(String tid, String username) {
        List<TaskPart> taskPart = taskPartMapper.selectByPart(username);
        System.out.println(taskPart);
        for (TaskPart t: taskPart
             ) {
            if (t.getTask_id().equals(tid)){
                return 1;
            }
        }
        TaskPart taskPart1 = new TaskPart();
        taskPart1.setTask_id(tid);
        taskPart1.setTask_userid(username);
        taskPartMapper.insert(taskPart1);
        return 0;
    }
}
