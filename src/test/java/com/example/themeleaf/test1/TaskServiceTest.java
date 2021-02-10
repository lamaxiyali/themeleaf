package com.example.themeleaf.test1;

import com.example.themeleaf.service.TaskService;
import com.example.themeleaf.service.impl.TaskServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author lamaxiya
 * @version 1.0
 * @date 2021/2/10 11:05
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskServiceTest {
    @Autowired
    TaskServiceImpl taskService;
    @Test
    public void test1(){
        System.out.println("okkk");
    }
    @Test
    public void testTime(){
        taskService.schedule();
    }

}
