package com.example.themeleaf.service;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Testsha256 {
    public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        String str1 = "hello world";
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        messageDigest.update(str1.getBytes("UTF-8"));
        String encodestr = "";
        encodestr = byte2Hex(messageDigest.digest());
        System.out.println(encodestr);
    }

    private static String byte2Hex(byte[] bytes){
        StringBuffer stringBuffer = new StringBuffer();
        String temp = null;
        for (int i=0;i<bytes.length;i++){
            temp = Integer.toHexString(bytes[i] & 0xFF);
            if (temp.length()==1){
                //1得到一位的进行补0操作
                stringBuffer.append("0");
            }
            stringBuffer.append(temp);
        }
        return stringBuffer.toString();
    }
}
