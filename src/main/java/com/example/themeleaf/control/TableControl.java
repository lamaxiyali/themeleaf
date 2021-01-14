package com.example.themeleaf.control;


import com.alibaba.fastjson.JSONObject;
import com.example.themeleaf.dao.UserinfoMapper;
import com.example.themeleaf.entity.Userinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class TableControl {
    @Autowired
    UserinfoMapper userinfoMapper;
    @RequestMapping("/table")
    public String login(){
        return "tabletest";
    }
    @RequestMapping("/data")
    public @ResponseBody  String data(Integer page, Integer limit){
        System.out.println(page);
        System.out.println(limit);
        int before=limit * (page - 1);
        int after = limit;
        List<Userinfo> adminList = userinfoMapper.getInfoList(before,after);
        System.out.println(adminList);
        int count = userinfoMapper.count();
        String js = JSONObject.toJSONString(adminList);
        String jso = "{\"code\":0,\"msg\":\"\",\"count\":"+count+",\"data\":"+js+"}";
        return jso;
    }
}
