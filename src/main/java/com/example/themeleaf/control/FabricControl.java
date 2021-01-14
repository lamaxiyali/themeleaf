package com.example.themeleaf.control;

import com.example.themeleaf.dao.FabricMapper;
import com.example.themeleaf.entity.Car;
import com.example.themeleaf.service.FabricService;
import com.example.themeleaf.service.Mybatis_test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;
//------------测试获取fabric链码信息写入数据库-------------
@Controller
@RequestMapping("/")
public class FabricControl {
    @Resource
    FabricService fabricService;
    @RequestMapping("/fabricdata")
    public String getfabric(Model model){
        System.out.println("---------start--------");
        List<Car> carList = new Mybatis_test().getresult();
        System.out.println("--------getResult-------------");
        fabricService.insertall(carList);
        System.out.println("--------------insert database------------");
        model.addAttribute("fa",carList);
        System.out.println("----------end-----------------------------");
        return "fabric";
    }

}
