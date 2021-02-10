package com.example.themeleaf.control;

import com.example.themeleaf.entity.PersonMessage;
import com.example.themeleaf.entity.Userinfo;
import com.example.themeleaf.result.Result;
import com.example.themeleaf.service.LoginService;
import com.example.themeleaf.service.PersonInfo;
import com.example.themeleaf.service.TaskService;
import com.example.themeleaf.service.WebSocket;
import com.example.themeleaf.service.impl.FabricGateway;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.hyperledger.fabric.gateway.Contract;
import org.hyperledger.fabric.gateway.ContractException;
import org.hyperledger.fabric.gateway.Network;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeoutException;

@Controller
@RequestMapping("/")
public class LoginControl {
    @Resource
    LoginService loginService;
    @Resource
    PersonInfo personInfo;
    @Resource
    TaskService taskService;
    @CrossOrigin
    @RequestMapping("/api/login")
    @ResponseBody
    Result check(@RequestBody Userinfo requestUser){
        String username = requestUser.getUsername();
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username, requestUser.getPassword());
        try {
            subject.login(usernamePasswordToken);
            taskService.schedule();
            return new Result(200);
        } catch (AuthenticationException e) {
            String message = "账号密码错误";
            return new Result(400);
        }
    }

    @CrossOrigin
    @RequestMapping("/api/register")
    @ResponseBody
    Result addUser(@RequestBody Userinfo userinfo) throws InterruptedException, TimeoutException, ContractException {
        String username1 = userinfo.getUsername();
        username1 = HtmlUtils.htmlEscape(username1);
        userinfo.setUsername(username1);
        System.out.println(username1);
        String password1 = userinfo.getPassword();
        String salt = new SecureRandomNumberGenerator().nextBytes().toString();
        int times = 2;
        String encodedPassword = new SimpleHash("md5",password1, salt, times).toString();
        userinfo.setPassword(encodedPassword);
        userinfo.setSalt(salt);
        int result = loginService.addUser(userinfo);
        String re = result +"";
        if(result == 0){
            Network network =FabricGateway.gateway.getNetwork("mychannel");
            Contract contract = network.getContract("userbasicinfo");
            byte[] resu = contract.submitTransaction("Set", userinfo.getUsername(), userinfo.getEmail(), "0.6", "0.0", userinfo.getUsername());
            System.out.println(new String(resu));
            if("0".equals(new String(resu))){
                System.out.println( "注册成功");
                WebSocket ws = new WebSocket();
                PersonMessage personMessage = new PersonMessage();
                personMessage.setUname(username1);
                personMessage.setMessagetype("个人消息");
                String mess = "个人消息" + "---" + "注册信息" + "---" + "您已经成功注册信息到区块链上" + "---" + new Date().toLocaleString();
                personMessage.setMessage(mess);
                try {
                    ws.sendMessageTo(mess, username1);
                    personInfo.insertPersonMessage(personMessage);
                } catch (IOException e) {
                    e.printStackTrace();
                    return new Result(402);
                }
                return new Result(200);
            }
            System.out.println("注册信息到区块链出错");
            return new Result(402);
        }else if(result ==1){
            System.out.println("注册用户已经存在");
            return new Result(400);
        }else if(result == 2){
            System.out.println("注册邮箱已经存在");
            return new Result(401);
        }
        return new Result(500);
    }

    @ResponseBody
    @CrossOrigin
    @GetMapping("/api/logout")
    public Result logout(){
        Subject subject = SecurityUtils.getSubject();
        System.out.println(subject.getPrincipal().toString());
        System.out.println(subject.getSession().toString());
        System.out.println(subject.getPrincipals().toString());
        subject.logout();
        return new Result(200);
    }

    @ResponseBody
    @GetMapping(value = "api/authentication")
    public String authentication(){
        return "身份认证成功";
    }
}
