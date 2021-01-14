package com.example.themeleaf.control;


import com.example.themeleaf.entity.Userinfo;
import com.example.themeleaf.service.PersonInfo;
import org.apache.catalina.User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

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



}
