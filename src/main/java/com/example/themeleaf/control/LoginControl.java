package com.example.themeleaf.control;

import com.example.themeleaf.entity.Userinfo;
import com.example.themeleaf.result.Result;
import com.example.themeleaf.service.LoginService;
import com.google.logging.type.HttpRequest;
import io.netty.handler.codec.spdy.SpdyHttpHeaders;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/")
public class LoginControl {
    @Resource
    LoginService loginService;
    @CrossOrigin
    @RequestMapping("/api/login")
    @ResponseBody
    Result check(@RequestBody Userinfo requestUser){
        String username = requestUser.getUsername();
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username, requestUser.getPassword());
        try {
            subject.login(usernamePasswordToken);
            System.out.println(subject.getPrincipal().toString());
            System.out.println(subject.getPrincipals().asList());
            return new Result(200);
        } catch (AuthenticationException e) {
            String message = "账号密码错误";
            return new Result(400);
        }
    }

    @CrossOrigin
    @RequestMapping("/api/register")
    @ResponseBody
    Result addUser(@RequestBody Userinfo userinfo){
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
            System.out.println( "注册成功");
            return new Result(200);
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
