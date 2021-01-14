package com.example.themeleaf.service;

import com.alibaba.fastjson.JSONObject;
import com.example.themeleaf.entity.Car;
import com.example.themeleaf.other.demo1;

import java.util.ArrayList;
import java.util.List;

public class Tee {
    public static void main(String args[]) {
        byte[] ss = new demo1().getresult();
        String sd = new String(ss);
//        JSONArray jsonArray = JSONArray.parseArray(sd);
//        System.out.println(jsonArray);
//        System.out.println("-----------------------");
////        String js = JSONObject.toJSONString(jsonArray, SerializerFeature.WriteClassName);
//        String js = JSONObject.toJSONString(jsonArray);
        List<Car> carList = new ArrayList<Car>();
        carList = JSONObject.parseArray(sd, Car.class);
        System.out.println("ceshsi");
        for (Car car:carList
        ) {
            System.out.println(car.getKey()+":");
            Car.Record record = car.getRecord();
            System.out.println("make:"+record.make+",colour:"+record.colour+",model:"+record.model+",onwer:"+record.owner);
            System.out.println("*********************************************");
        }

    }
}
