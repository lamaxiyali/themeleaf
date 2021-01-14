package com.example.themeleaf.service.impl;

import java.util.Arrays;
import java.util.concurrent.ThreadPoolExecutor;

public class JsonTest {
    private int m;
    public int inc(Integer d){
        synchronized (d) {
            return m + 1;
        }
    }
    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = new String("abc");
        if(s1==s2) System.out.println(true);
        if(s1.equals(s2)) System.out.println("2");
        Class ss = s1.getClass();
    }
}
