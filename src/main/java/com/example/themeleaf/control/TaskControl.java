package com.example.themeleaf.control;

import com.example.themeleaf.entity.SenseTaskInfo;
import com.example.themeleaf.entity.TaskPart;
import com.example.themeleaf.result.Accept;
import com.example.themeleaf.result.PageGet;
import com.example.themeleaf.result.Result;
import com.example.themeleaf.service.LoginService;
import com.example.themeleaf.service.TaskService;
import com.example.themeleaf.utils.RealAuthDO;
import com.example.themeleaf.utils.StringUtils;
import com.google.common.collect.HashBasedTable;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
public class TaskControl {
    @Resource
    TaskService taskService;
    @Resource
    StringUtils stringUtils;
    @Resource
    RealAuthDO realAuthDO;
    @Resource
    LoginService loginService;
//    添加一个任务
//    @CrossOrigin
    @RequestMapping("/api/addtask")
    Result  addTask(@RequestBody SenseTaskInfo senseTaskInfo){
        String substring = senseTaskInfo.getTask_date().substring(0, 10);
        senseTaskInfo.setTask_date(substring);
        senseTaskInfo.setTask_nowpartin(0);
        String id = StringUtils.getRandomString(12);
        senseTaskInfo.setTid(id);
        taskService.addTask(senseTaskInfo);
        return new Result(200);
    }
//    查看所以任务
//    @CrossOrigin
    @RequestMapping("/api/alltask")
    List<SenseTaskInfo> allTask(){
        taskService.schedule();
        System.out.println(taskService.allTask());
        return taskService.allTask();
    }
//    @CrossOrigin
    @RequestMapping("/api/sectiontask")
    List<SenseTaskInfo> sectionTask(@RequestBody PageGet pageGet){
        int before = pageGet.getLimit() * (pageGet.getPage() - 1);
        int after = pageGet.getLimit();
        taskService.schedule();
        return taskService.getInfoList(before, after);
    }
//    获取目前数据库存储的任务个数
//    @CrossOrigin
    @RequestMapping("/api/counttask")
    Result counttask(){
        System.out.println(taskService.count());
        return new Result(taskService.count());
    }
//    获取任务总价值
//    @CrossOrigin
    @RequestMapping("/api/countvalue")
    int countvalue(){
        return taskService.getAllValue();
    }

    @RequestMapping("/api/countallpartin")
    int countNowPartIn(){
        return taskService.getAllNowPartIn();
    }

//    实现用户获取当前参与情况
//    @CrossOrigin
    @RequestMapping("/api/querytask")
    List<TaskPart> statustask(@RequestParam(value = "task_id") String task){
        List<TaskPart> taskParts = taskService.selectByTask(task);
        if(taskParts != null){
            return taskParts;
        }else {
            return null;
        }
    }
//    @CrossOrigin
    @RequestMapping("/api/querycompany")
    List<String> getcompany(){
        return taskService.getCompanys();
    }
//根据任务编号获取当前参与情况
    @RequestMapping("/api/querypart")
    List<TaskPart> querypart(@RequestParam(value = "user_id") String user_id){
        List<TaskPart> taskParts = taskService.selectByPart(user_id);
        if (taskParts != null){
            return taskParts;
        }else {
            return null;
        }
    }
//    参与任务
    @RequestMapping("/api/partin")
    Result partin(@RequestBody Accept accept){
        SecurityManager securityManager = new SecurityManager();
        Subject subject = SecurityUtils.getSubject();
        System.out.println(accept.getInfo());
        String username = subject.getPrincipal().toString();
        int re = taskService.partIn(accept.getInfo(), username);
        if (re == 0) {
            return new Result(200);
        }
        return new Result(400);
    }



}
