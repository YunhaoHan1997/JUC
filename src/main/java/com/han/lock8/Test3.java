package com.han.lock8;

import java.util.concurrent.TimeUnit;

/**
 * @Author Han
 * @Date 2020/11/6
 *问题5:用static修饰synchronized，会有什么变化？
 * static是静态方法，类的加载时就有了，锁的是phone3的class
 * 问题6：两个对象分别调用，会有什么变化？对比问题4
 * 还是先sms后call，因为两个对象的类模板一样
 */

public class Test3 {public static void main(String[] args) throws InterruptedException {
    //两个对象两把锁，
    Phone3 phone1 = new Phone3();
    Phone3 phone2 = new Phone3();
    new Thread(()->{
        try {
            phone1.sendSms();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    },"A").start();
    TimeUnit.SECONDS.sleep(3);
    new Thread(()->{phone2.call();},"B").start();
}

}

class  Phone3{
    public static synchronized void sendSms() throws InterruptedException {
        TimeUnit.SECONDS.sleep(4);

        System.out.println("sendSms");
    }
    public static synchronized void call(){
        System.out.println("call");
    }
    public void hello(){
        System.out.println("hello");
    }
}

