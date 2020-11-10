package com.han.lock8;

import java.util.concurrent.TimeUnit;

/**
 * @Author Han
 * @Date 2020/11/7
 * 问题7，一个static synchronized，一个单纯synchronized，一个对象，先执行哪个？
 * 答案：先执行打电话
 * 问题8：一个static synchronized，一个单纯synchronized，两个对象，先执行哪个？
 * 答案：还是一样的
 */

public class test4 {public static void main(String[] args) throws InterruptedException {
    //两个对象两把锁，
    Phone4 phone = new Phone4();
    Phone4 phone2 = new Phone4();
    new Thread(()->{
        try {
            phone.sendSms();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    },"A").start();
    TimeUnit.SECONDS.sleep(3);
    new Thread(()->{phone2.call();},"B").start();
}

}

class  Phone4{
    //锁的是类模板
    public static synchronized void sendSms() throws InterruptedException {
        TimeUnit.SECONDS.sleep(4);

        System.out.println("sendSms");
    }
    //锁的是方法调用者
    public  synchronized void call(){
        System.out.println("call");
    }
    public void hello(){
        System.out.println("hello");
    }
}
