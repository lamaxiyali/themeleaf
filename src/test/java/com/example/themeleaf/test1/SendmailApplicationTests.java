package com.example.themeleaf.test1;


import com.example.themeleaf.other.Demo3;
import com.example.themeleaf.service.*;
import com.example.themeleaf.utils.RealAuthDO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SendmailApplicationTests {
    @Autowired
    MailService mailService;
    @Autowired
    Demo3 demo3;
    @Autowired
    LoginService loginService;
    @Autowired
    TaskService taskService;
    @Autowired
    RealAuthDO realAuthDO;
    @Resource
    MetricsService metricsService;
    @Resource
    PersonInfo personInfo;

    @Test
    public void testGetPersonInfo(){
        personInfo.getPersonInfo("lamaxiya");
    }
    @Test
    public void sendSimpleMail(){
        mailService.sendSimpleMail("lamaxiyafc@qq.com","baohuili@bupt.edu.cn","lamaxiyafc@qq.com","测试邮件主题","测试邮件内容");

    }
    @Test
    public void testDemo3(){
        demo3.testChain();
    }

    @Test
    public void  testLogin(){
//        loginService.updateByEmail("3293376887@qq.com", "222222");
    }
    @Test
    public void testTaskadd(){
        Date date = new Date();
        String date1 = realAuthDO.sdf.format(date);
        String time = realAuthDO.stf.format(date);
        System.out.println(date1);
//        SenseTaskInfo senseTaskInfo = new SenseTaskInfo(10001,"task1","gongsi1", 100, "温度感知", "海淀区", );
//        taskService.addTask(senseTaskInfo);
    }
    @Test
    public void testYarnService(){
        metricsService.getChaincodeMetrics();
    }
}
