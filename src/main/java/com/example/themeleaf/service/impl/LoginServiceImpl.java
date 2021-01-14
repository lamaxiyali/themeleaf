package com.example.themeleaf.service.impl;

import com.example.themeleaf.dao.RepassMapper;
import com.example.themeleaf.dao.UserinfoMapper;
import com.example.themeleaf.entity.Repass;
import com.example.themeleaf.entity.Userinfo;
import com.example.themeleaf.service.LoginService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    UserinfoMapper userinfoMapper;
    @Autowired
    RepassMapper repassMapper;
    @Override
    public int checkNameAndPassword(String name, String password) {
        Userinfo userinfo = userinfoMapper.selectByPrimaryKey(name);
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
        Userinfo userinfo = userinfoMapper.selectByEmail(email);
        if (userinfo != null){
            return 0;
        }else {
            return 1;
        }
    }

    @Override
    public int addUser(Userinfo userinfo) {
//        Userinfo userinfo = new Userinfo(username,password,null,null,null,null,null,null,null,null);
        Userinfo userinfo1 = userinfoMapper.selectByPrimaryKey(userinfo.getUsername());
        if (userinfo1 != null){
            return 1;
        }else if(userinfoMapper.selectByEmail(userinfo.getEmail()) != null){
            return 2;
        } else {
            userinfoMapper.insert(userinfo);
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
        userinfoMapper.updateByEmail(userinfo);
        return 0;
    }

    @Override
    public Userinfo getByUsername(String username) {
        Userinfo userinfo = userinfoMapper.selectByUsername(username);
        return userinfo;
    }
}
