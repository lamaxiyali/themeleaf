package com.example.themeleaf.service.impl;

import com.example.themeleaf.dao.SenseTaskInfoMapper;
import com.example.themeleaf.dao.TaskPartMapper;
import com.example.themeleaf.entity.SenseTaskInfo;
import com.example.themeleaf.entity.TaskPart;
import com.example.themeleaf.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
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
    public int getAllNowPartIn() {
        List<SenseTaskInfo> senseTaskInfos = senseTaskInfoMapper.selectAll();
        int allpartperson =0;
        for(SenseTaskInfo s: senseTaskInfos){
            allpartperson += s.getTask_nowpartin();
        }
        return allpartperson;
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

    @Override
    public void schedule(){
        List<SenseTaskInfo> taskInfos = allTask();
        System.out.println("inside schedule");
        for(SenseTaskInfo s: taskInfos){
            LocalDate nowdate = LocalDate.now();
            LocalDate nowdb = LocalDate.parse(s.getTask_date());
            int i = nowdb.compareTo(nowdate);
            if(i>0){
                s.setTask_status("未开始");
                senseTaskInfoMapper.updateTaskStatus(s);
                continue;
            }
            if(i<0){
                s.setTask_status("已结束");
                senseTaskInfoMapper.updateTaskStatus(s);
                continue;
            }
            LocalTime now = LocalTime.now();
            String starttime = s.getTask_startTime();
            String endtime = s.getTask_endTime();
            LocalTime parsestart = LocalTime.parse(starttime);
            LocalTime parseend = LocalTime.parse(endtime);
            if(now.compareTo(parseend) < 0 && now.compareTo(parsestart) > 0){
                System.out.println(parsestart);
                System.out.println(s.getTask_name() + "任务开启");
                System.out.println(parseend);
                s.setTask_status("进行中");
                senseTaskInfoMapper.updateTaskStatus(s);
                continue;
            }
            if(now.compareTo(parseend)>=0){
                s.setTask_status("已结束");
                senseTaskInfoMapper.updateTaskStatus(s);
                continue;
            }
            if(now.compareTo(parsestart)<=0){
                s.setTask_status("未开始");
                senseTaskInfoMapper.updateTaskStatus(s);
            }
        }
    }
}
