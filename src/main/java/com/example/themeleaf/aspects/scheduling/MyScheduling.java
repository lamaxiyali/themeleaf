package com.example.themeleaf.aspects.scheduling;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class MyScheduling {
//    @Scheduled(fixedDelay = 1000)
    public void fixDelay(){
        System.out.println("fixDelay:" + new Date());
    }

}
