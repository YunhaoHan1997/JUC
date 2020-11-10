package com.han.lock8;

import java.util.concurrent.TimeUnit;

/**
 * @Author Han
 * @Date 2020/9/29
 * 问题1：延迟psvm中延迟1秒，先执行的是谁？
 * 问题2：在方法中延迟4秒，先执行的是谁？
 * 答案都是A，原因synchronized锁的是方法的调用者，即phone，两个方法用的是同一把锁，谁先拿到谁执行
 */

public class Test1 {
    public static void main(String[] args) throws InterruptedException {
        Phone phone = new Phone();
        new Thread(()->{
            try {
                phone.sendSms();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"A").start();
        TimeUnit.SECONDS.sleep(1);
        new Thread(()->{phone.call();},"A").start();
    }

}

class  Phone{
    public synchronized void sendSms() throws InterruptedException {
        TimeUnit.SECONDS.sleep(4);

        System.out.println("sendSms");
    }
    public synchronized void call(){
        System.out.println("call");
    }
}