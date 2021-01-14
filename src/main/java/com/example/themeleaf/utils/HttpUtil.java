package com.example.themeleaf.utils;


import java.io.BufferedReader;
import java.io.IOException;

import java.io.InputStreamReader;

import java.io.PrintWriter;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import sun.net.www.protocol.http.HttpURLConnection;

public class HttpUtil {
    public static Map<String, Double> httpsRequest(String requestUrl, String requestMethod, String param){
        PrintWriter out = null;
        BufferedReader in = null;
        Map<String, Double> map = new HashMap<>();
        try {
            URL realUrl = new URL(requestUrl);
            // 打开和URL之间的连接
            HttpURLConnection conn = (HttpURLConnection) realUrl.openConnection();
            // 设置通用的请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestMethod(requestMethod);
            if (requestMethod.equals("GET")){
                // Get请求不需要DoOutPut
                conn.setDoOutput(false);
                conn.setDoInput(true);
                // 连接服务器
                conn.connect();
            }
            if (requestMethod.equals("POST")){
                conn.setUseCaches(false);
                conn.setConnectTimeout(6 * 1000);
                conn.setReadTimeout(6 * 1000);
                conn.setRequestProperty("Charset", "utf-8");
                // 发送POST请求必须设置如下两行
                conn.setDoOutput(true);
                conn.setDoInput(true);
                // 获取URLConnection对象对应的输出流
                out = new PrintWriter(conn.getOutputStream());
                // 发送请求参数
                out.print(param);
                // flush输出流的缓冲
                out.flush();
            }
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
            String line;
            int index;
            while ((line = in.readLine()) != null) {
                if(line.charAt(0) != '#'){
                    String[] strs = line.split(" ");
                    map.put(strs[0], Double.parseDouble(strs[1]));
                }
            }
        } catch (Exception e) {
            System.out.println("发送 请求出现异常！" + e);
            e.printStackTrace();
        }
        // 使用finally块来关闭输出流、输入流
        finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return map;
    }
}
