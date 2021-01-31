package com.example.themeleaf.service;

import com.example.themeleaf.entity.Repass;
import com.example.themeleaf.entity.Userinfo;

public interface PubLoginService {
    int checkNameAndPassword(String name, String password);
    int checkEmail(String email);
    int addUser(Userinfo userinfo);
    int insertCode(String email, String code);
    Repass selectByCode(String code);
    int updateByEmail(String email, String password, String salt);
    int updateByUsername(String email, String password, String salt);
    Userinfo getByUsername(String username);
}
