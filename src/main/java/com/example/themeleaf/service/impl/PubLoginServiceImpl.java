package com.example.themeleaf.service.impl;

import com.example.themeleaf.entity.Repass;
import com.example.themeleaf.entity.Userinfo;
import com.example.themeleaf.dao.RepassMapper;
import com.example.themeleaf.dao.TaskPubInfoMapper;
import com.example.themeleaf.service.PubLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public class PubLoginServiceImpl implements PubLoginService {
    TaskPubInfoMapper taskpubinfoMapper;
    RepassMapper repassMapper;
    public int checkNameAndPassword(String name, String password) {
        Userinfo userinfo = taskpubinfoMapper.selectByPrimaryKey(name);
        if(userinfo != null){
            if(userinfo.getPassword().equals(password)){
                return 2;
            }else {
                return 1;
            }
        }else {
            return 0;
        }
    }

    @Override
    public int checkEmail(String email) {
        Userinfo userinfo = taskpubinfoMapper.selectByEmail(email);
        if (userinfo != null){
            return 0;
        }else {
            return 1;
        }
    }

    @Override
    public int addUser(Userinfo userinfo) {
        Userinfo userinfo1 = taskpubinfoMapper.selectByPrimaryKey(userinfo.getUsername());
        if (userinfo1 != null){
            return 1;
        }else if(taskpubinfoMapper.selectByEmail(userinfo.getEmail()) != null){
            return 2;
        } else {
            taskpubinfoMapper.insert(userinfo);
            return 0;
        }
    }

    @Override
    public int insertCode(String email, String code) {
        Repass repass = new Repass(email,code);
        Repass repass1 = repassMapper.selectByPrimaryKey(email);
        if(repass1 != null){
            repassMapper.updateByPrimaryKey(repass);
            return 0;
        }
        repassMapper.insert(repass);
        return 0;
    }

    @Override
    public Repass selectByCode(String code) {
        Repass repass = repassMapper.selectByCode(code);
        if(repass != null){
            return repass;
        }
        return null;
    }

    @Override
    public int updateByEmail(String email, String password, String salt) {
        Userinfo userinfo = new Userinfo(null,password, salt, email,null,null,null,null,null,null,null);
        taskpubinfoMapper.updateByEmail(userinfo);
        return 0;
    }

    @Override
    public int updateByUsername(String username, String password, String salt) {
        Userinfo userinfo = new Userinfo(username, password, salt,null,null,null,null,null,null,null,null);
        taskpubinfoMapper.updateByUsername(userinfo);
        return 0;
    }

    @Override
    public Userinfo getByUsername(String username) {
        Userinfo userinfo = taskpubinfoMapper.selectByUsername(username);
        return userinfo;
    }
}
