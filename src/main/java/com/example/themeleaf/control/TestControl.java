package com.example.themeleaf.control;

import com.example.themeleaf.service.TaskService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author lamaxiya
 * @version 1.0
 * @date 2021/2/10 11:11
 */
@RestController
public class TestControl {
    @Resource
    TaskService taskService;
    @RequestMapping("/test11")
    public void runTime(){
        taskService.schedule();
    }
}
