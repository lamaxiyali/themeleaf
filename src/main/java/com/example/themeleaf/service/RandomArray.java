package com.example.themeleaf.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class RandomArray {
    public int randArray(int min, int max){
        int num = min + (int)(Math.random() * (max-min+1));
        return num;
    }
    public List randNormal(){
        List<Integer> list1 = new ArrayList<>();
        int ep = new RandomArray().randArray(50, 100);
        int ad = new RandomArray().randArray(1, 10);
        int at = new RandomArray().randArray(10, 100);
        int pl = new RandomArray().randArray(1, 1000);
        int pa = new RandomArray().randArray(5, 50);
        list1.add(ep);
        list1.add(ad);
        list1.add(at);
        list1.add(pl);
        list1.add(pa);
        list1.add(0);
        return list1;
    }
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        RandomArray randomArray = new RandomArray();
        List<Integer> list = randomArray.randNormal();
        System.out.println(list);
        System.out.println(list.get(0));
        System.out.println(list.get(5));
        long end = System.currentTimeMillis();
        System.out.println("运行时间：" +(end - start)+ "ms");
    }
}
