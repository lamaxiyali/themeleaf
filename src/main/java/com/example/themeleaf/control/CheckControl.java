package com.example.themeleaf.control;

import com.example.themeleaf.entity.Repass;
import com.example.themeleaf.entity.Userinfo;
import com.example.themeleaf.result.Code;
import com.example.themeleaf.result.Result;
import com.example.themeleaf.service.LoginService;
import com.example.themeleaf.service.MailService;
import com.google.logging.type.HttpRequest;
import io.netty.handler.codec.spdy.SpdyHttpHeaders;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/")
public class CheckControl {
    @Resource
    LoginService loginService;
    @Resource
    MailService mailService;
    @CrossOrigin
    @RequestMapping("/api/checkemail")
    @ResponseBody
    Result check(@RequestBody Userinfo userinfo){
        String email = userinfo.getEmail();
        int result = loginService.checkEmail(email);
        String re = result +"";
        if (result == 0){
            System.out.println("存在该用户");
            return new Result(200);
        }else{
            System.out.println("不存在该用户");
            return new Result(400);
        }
    }
    @CrossOrigin
    @RequestMapping("/api/getcode")
    @ResponseBody
    Result getCode(@RequestBody Userinfo userinfo){
        String rand = (int)((Math.random()*9+1)*100000)+ "";
        System.out.println(rand);
        String email = userinfo.getEmail();
        System.out.println(email);
        String content = "修改验证码:"+ rand;
        int tag = mailService.sendSimpleMail("lamaxiyafc@qq.com",email,"lamaxiyafc@qq.com","修改密码验证码",content);
        if (tag == 1){
            System.out.println(2);
            return new Result(400);
        }
        int re = loginService.insertCode(email,rand);
        if(re == 0){
            System.out.println("insert code success");
            return new Result(200);
        }
        System.out.println(email);
        return new Result(400);
    }
    @ResponseBody
    @CrossOrigin
    @RequestMapping("/api/checkcode")
    Result checkCode(@RequestBody Code code){
        String code1 = code.getCode();
        Repass repass = loginService.selectByCode(code1);
        if (repass == null){
            System.out.println("code check failed");
            return new Result(400);
        }else {
            System.out.println("code check success");
            return new Result(200);
        }
    }
    @CrossOrigin
    @RequestMapping("/api/updatepass")
    @ResponseBody
    Result updatePass(@RequestBody Userinfo userinfo){
        String password = userinfo.getPassword();
        System.out.println(password);
        String email = userinfo.getEmail();
        System.out.println(email);
        String salt = new SecureRandomNumberGenerator().nextBytes().toString();
        int times = 2;
        String encodedPassword = new SimpleHash("md5",password, salt, times).toString();
        int a = loginService.updateByEmail(email, encodedPassword, salt);
        if (a == 0){
            System.out.println("update success");
            return new Result(200);
        }
        return new Result(400);
    }





}
