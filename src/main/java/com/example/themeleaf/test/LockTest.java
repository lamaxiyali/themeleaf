package com.example.themeleaf.test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest {
    private Lock lock = new ReentrantLock();
    private void method(Thread thread){
        lock.lock();
        try {
            System.out.println("线程"+thread.getName()+"获得了锁");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            System.out.println("线程"+thread.getName()+"释放了锁");
            lock.unlock();
        }
    }
    private void method1(Thread thread){
        if(lock.tryLock()){
            try {
                System.out.println("线程"+thread.getName()+"获得了锁");
                Thread.sleep(1000);
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                System.out.println("线程"+thread.getName()+"释放了锁");
                lock.unlock();
            }
        }else {
            System.out.println("我是线程"+Thread.currentThread().getName()+"有人占着锁");
        }
    }

    public static void main(String[] args) {
        LockTest lockTest = new LockTest();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                lockTest.method1(Thread.currentThread());
            }
        }, "t1");

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                lockTest.method1(Thread.currentThread());
            }
        }, "t2");
        t1.start();
        t2.start();
    }

}
