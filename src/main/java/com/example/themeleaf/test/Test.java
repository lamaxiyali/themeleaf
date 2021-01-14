package com.example.themeleaf.test;

import java.lang.reflect.Method;
import java.util.*;

public class Test {
    static {
        setPro();
    }
    public static void setPro(){
        System.setProperty("name", "张三");
        System.setProperty("age", "28");
    }
    public static void main(String[] args) throws ClassNotFoundException {
        String a = "111";
        a = "222";
        System.out.println(a);
//        System.out.println("----------------------");
//        System.out.println(System.getProperty("name"));
//        System.out.println(System.getProperty("age"));
//        Class clazz = Class.forName("com.example.themeleaf.test.Test");
//        Method[] methods = clazz.getMethods();
//        for (Method m: methods
//             ) {
//            System.out.println(m.getModifiers()+"--"+m.getReturnType()+"——-"+m.getName()+"--"+m.getParameters().toString());
//        }
//        HashMap<String, Integer> hashMap = new HashMap<>(-1);
//        TreeSet<Student> ts = new TreeSet<>();
//        //创建元素对象
//        Student s1=new Student("zhangsan",20);
//        Student s2=new Student("lis",22);
//        Student s3=new Student("wangwu",24);
//        Student s4=new Student("chenliu",26);
//        Student s5=new Student("zhangsan",22);
//        Student s6=new Student("qianqi",24);
//
//        //将元素对象添加到集合对象中
//        ts.add(s1);
//        ts.add(s2);
//        ts.add(s3);
//        ts.add(s4);
//        ts.add(s5);
//        ts.add(s6);
//
//        //遍历
//        for(Student s:ts){
//            System.out.println(s.getName()+"-----------"+s.getAge());
//        }
//        Synchronized syn = new Synchronized();
//        for (int i = 0; i < 10; i++) {
//            new Thread(){
//                public void run(){
//                    syn.classMethod();
//                }
//            }.start();
//            new Thread(){
//                public void run(){
//                    Synchronized.staticMethod();
//                }
//            }.start();
//        }
//        int[] a = new int[10];
//        for (int i = 0; i < 10; i++) {
//            a[i] = i;
//        }
//        int [] b = Arrays.copyOfRange(a, 0, 2);
//        List<Integer> list = new ArrayList<>();
//        System.out.println(b.length);
//        System.out.println(1e9+7);
//        List<Integer> list1 = new LinkedList<>();
    }
}
class Student implements Comparable<Student>{

    String name;
    Integer age;
    public Student(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        Stack<Integer> stack = new Stack<>();
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public int compareTo(Student o) {
        int num1 = this.name.length() - o.name.length();
        int num2 = num1 == 0? this.name.compareTo(o.name): num1;
        int num3 = num2 == 0 ? this.age.compareTo(o.age): num2;
        return num3;
    }
}
class Synchronized {
    public synchronized void instanceMethod(){
        for(int i =0; i<5; i++){
            System.out.println("instanceMethod");
            try {
                Thread.sleep(100);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
    public synchronized static void staticMethod(){
        for(int i =0; i<5; i++){
            System.out.println("staticMethod");
            try {
                Thread.sleep(100);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
    public void thisMethod() {
        synchronized (this) {
            for (int i = 0; i < 5; i++) {
                System.out.println("thisMethod");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public void classMethod(){
        synchronized(Synchronized.class){
            for (int i = 0; i < 5; i++) {
                System.out.println("classMethod");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public void anyObject(){
        synchronized ("anything"){
            for (int i = 0; i < 5; i++) {
                System.out.println("anyObject");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
