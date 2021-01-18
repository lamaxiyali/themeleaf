package com.example.themeleaf.service;

import com.example.themeleaf.entity.PersonMessage;
import com.example.themeleaf.entity.Userinfo;

import java.util.List;

public interface PersonInfo {
    Userinfo getPersonInfo(String username);

    void insertSystemMessage(PersonMessage personMessage);

    void insertPersonMessage(PersonMessage personMessage);

    List<PersonMessage> getAllSystemMessage(String sys);

    List<PersonMessage> getAllMessage();

}
