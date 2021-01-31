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
        return 0;
    }

    @Override
    public int addUser(Userinfo userinfo) {
        return 0;
    }

    @Override
    public int insertCode(String email, String code) {
        return 0;
    }

    @Override
    public Repass selectByCode(String code) {
        return null;
    }

    @Override
    public int updateByEmail(String email, String password, String salt) {
        return 0;
    }

    @Override
    public int updateByUsername(String email, String password, String salt) {
        return 0;
    }

    @Override
    public Userinfo getByUsername(String username) {
        return null;
    }
}
