package com.example.themeleaf.control;


import com.alibaba.fastjson.JSONObject;
import com.example.themeleaf.dao.UserinfoMapper;
import com.example.themeleaf.entity.PersonMessage;
import com.example.themeleaf.entity.UserBaicInfoInBlockchain;
import com.example.themeleaf.entity.Userinfo;
import com.example.themeleaf.service.PersonInfo;
import com.example.themeleaf.service.WebSocket;
import com.example.themeleaf.service.impl.FabricGateway;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.hyperledger.fabric.gateway.Contract;
import org.hyperledger.fabric.gateway.ContractException;
import org.hyperledger.fabric.gateway.Network;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.json.JsonObject;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class UserInfoControl {

    @Resource
    PersonInfo personInfo;
    @Resource
    UserinfoMapper userinfoMapper;

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
        String mess = "公共消息" + "---" + "系统更新" + "---" + "鉴于用户反馈，对系统延迟较大进行了更新" + "---" + new Date().toLocaleString();
        try {
            ws.sendMessageTo(mess, username);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("end time");
        return username;
    }

    @RequestMapping(value = "/api/system/message")
    public void insertSysMessage(){
        WebSocket ws = new WebSocket();
        PersonMessage personMessage = new PersonMessage();
        String mess = "公共消息" + "---" + "系统更新" + "---" + "鉴于用户反馈，对系统延迟较大进行了更新" + "---" + new Date().toLocaleString();
        personMessage.setMessage(mess);
        personInfo.insertSystemMessage(personMessage);
    }

    @RequestMapping(value = "/api/user/systemmessage")
    public List<PersonMessage> getSystemMessage(){
        List<PersonMessage> personMessages = personInfo.getAllSystemMessage("system");
        return personMessages;
    }

    @RequestMapping(value = "/api/user/allmessage")
    public List<PersonMessage> getAllMessage(){
        return personInfo.getAllMessage();
    }

    @RequestMapping(value = "/api/user/credit")
    public UserBaicInfoInBlockchain getUserBasicInfoFromBlockchain(@RequestBody UserBaicInfoInBlockchain userBaicInfoInBlockchain) throws ContractException {
        Network network = FabricGateway.gateway.getNetwork("mychannel");
        Contract contract = network.getContract("userbasicinfo");
        byte[] result = contract.evaluateTransaction("ReadUserInfoByUserName", userBaicInfoInBlockchain.getKey());
        List<UserBaicInfoInBlockchain> list;
        System.out.println(new String(result));
        list = JSONObject.parseArray(new String(result), UserBaicInfoInBlockchain.class);
        if (list.size() == 0){
            System.out.println("链上不存在此用户");
            return null;
        }
        return list.get(0);

    }






}
