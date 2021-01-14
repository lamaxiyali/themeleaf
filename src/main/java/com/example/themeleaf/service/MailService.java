package com.example.themeleaf.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class MailService {
    @Autowired
    JavaMailSender javaMailSender;
    public int sendSimpleMail(String from, String to, String cc,
                               String subject, String content){
        SimpleMailMessage simpMsg = new SimpleMailMessage();
        simpMsg.setFrom(from);
        simpMsg.setTo(to);
        simpMsg.setCc(cc);
        simpMsg.setSubject(subject);
        simpMsg.setText(content);
        try{
            javaMailSender.send(simpMsg);
            return 0;
        }catch (MailException e){
            System.out.println("email 发送失败");
            return 1;
        }
    }
}
