package com.example.themeleaf.control;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainControl {
    @RequestMapping("/mainuser")
    String register(){
        return "mainuser";
    }

    @RequestMapping("/modifyinfo")
    String modify(){
        return "modify_user_info";
    }
}
