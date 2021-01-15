package com.example.themeleaf.control;


import com.example.themeleaf.entity.PersonMessage;
import com.example.themeleaf.entity.Userinfo;
import com.example.themeleaf.service.PersonInfo;
import com.example.themeleaf.service.WebSocket;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.IOException;

@RestController
public class UserInfoControl {

    @Resource
    PersonInfo personInfo;

    @RequestMapping("/api/user/getpersoninfo")
    public Userinfo getPersonInfo(@RequestBody Userinfo userinfo){
        return personInfo.getPersonInfo(userinfo.getUsername());
    }

    @RequestMapping("/api/user/updatepersoninfo")
    public Userinfo updatePersonInfo(@RequestBody Userinfo userinfo){
        return personInfo.getPersonInfo(userinfo.getUsername());
    }

//    @ApiOperation(value="获取用户信息",notes="username是唯一属性，单个用户可直接通过username获取") //标注在方法：用以备注接口描述
    @RequestMapping(value="/api/user/query")
    public String getUserInfo(){
        WebSocket ws = new WebSocket();
        Subject subject = SecurityUtils.getSubject();
        String username = subject.getPrincipal().toString();
        PersonMessage personMessage = new PersonMessage();
        personMessage.setMessageType("公共消息");
        personMessage.setContent("系统更新");
        personMessage.setDescContent("鉴于用户反馈，对系统延迟较大进行了更新");
        String mess = personMessage.getMessageType() + " " + personMessage.getContent() + " " + personMessage.getDescContent();

        try {
            ws.sendMessageTo(mess, username);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("end time");

        return username;
    }



}
