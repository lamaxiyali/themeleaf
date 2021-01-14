package com.example.themeleaf.service.impl;

import com.example.themeleaf.dao.UserinfoMapper;
import com.example.themeleaf.entity.Userinfo;
import com.example.themeleaf.service.PersonInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PersonInfoImpl implements PersonInfo {

    @Resource
    UserinfoMapper userinfoMapper;
    @Override
    public Userinfo getPersonInfo(String username) {
        System.out.println(userinfoMapper.selectByPrimaryKey(username).toString());
        return userinfoMapper.selectByPrimaryKey(username);
    }
}
