package com.example.themeleaf.service;

import com.alibaba.fastjson.JSONObject;
import com.example.themeleaf.entity.Car;
import com.example.themeleaf.other.demo1;

import java.util.ArrayList;
import java.util.List;

public class Mybatis_test {
    public List<Car> getresult() {
        byte[] ss = new demo1().getresult();
        String sd = new String(ss);
        List<Car> carList = new ArrayList<>();
        carList = JSONObject.parseArray(sd, Car.class);
        for (Car car:carList
        ) {
            System.out.println(car.getKey()+":");
            Car.Record record = car.getRecord();
            System.out.println("make:"+record.make+",colour:"+record.colour+",model:"+record.model+",onwer:"+record.owner);
            System.out.println("*********************************************");
        }
        return carList;

    }
}
