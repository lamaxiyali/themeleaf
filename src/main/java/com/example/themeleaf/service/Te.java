package com.example.themeleaf.service;

import com.example.themeleaf.entity.Car;
import org.hyperledger.fabric.gateway.Network;

import java.util.List;

public class Te {
    private static Network name;
    static {
        System.out.println(Te.name);
    }
    public static void main(String[] args) {
        List<Car> carList = new Mybatis_test().getresult();
        for (Car car:carList
             ) {
            System.out.println(car.getKey());
        }

    }
}
