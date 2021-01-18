package com.example.themeleaf.service.impl;

import com.example.themeleaf.dao.PersonMessageMapper;
import com.example.themeleaf.dao.UserinfoMapper;
import com.example.themeleaf.entity.PersonMessage;
import com.example.themeleaf.entity.Userinfo;
import com.example.themeleaf.service.PersonInfo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class PersonInfoImpl implements PersonInfo {

    @Resource
    UserinfoMapper userinfoMapper;
    @Resource
    PersonMessageMapper personMessageMapper;

    @Override
    public Userinfo getPersonInfo(String username) {
        System.out.println(userinfoMapper.selectByPrimaryKey(username).toString());
        return userinfoMapper.selectByPrimaryKey(username);
    }

    @Override
    public void insertSystemMessage(PersonMessage personMessage) {
        personMessage.setUname("system");
        personMessage.setMessagetype("系统消息");
        personMessageMapper.insert(personMessage);
    }

    @Override
    public void insertPersonMessage(PersonMessage personMessage) {
        personMessageMapper.insert(personMessage);
    }

    @Override
    public List<PersonMessage> getAllSystemMessage(String sys) {
        List<PersonMessage> personMessages = personMessageMapper.selectAll();
        personMessages = personMessages.stream().filter(personMessage -> personMessage.getUname().equals(sys)
        ).collect(Collectors.toList());
        return personMessages;
    }

    @Override
    public List<PersonMessage> getAllMessage() {
        Subject subject = SecurityUtils.getSubject();
        List<PersonMessage> personMessages = personMessageMapper.selectAll();
        personMessages = personMessages.stream().filter(personMessage -> personMessage.getUname().equals("system") || personMessage.getUname().equals(subject.getPrincipal().toString())).collect(Collectors.toList());
        return personMessages;
    }

}
