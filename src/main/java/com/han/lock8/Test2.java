package com.han.lock8;

/**
 * @Author Han
 * @Date 2020/11/5
 */



import java.util.concurrent.TimeUnit;

/**
 * @Author Han
 * @Date 2020/9/29
 * 问题3:线程B打印发短信还是hello？
 * 问题4：两个对象，先打电话还是先发短信
 */

public class Test2 {
    public static void main(String[] args) throws InterruptedException {
        //两个对象两把锁，
        Phone2 phone1 = new Phone2();
        Phone2 phone2 = new Phone2();
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

class  Phone2{
    //synchronized锁住的是方法调用者
    public synchronized void sendSms() throws InterruptedException {
        TimeUnit.SECONDS.sleep(4);

        System.out.println("sendSms");
    }
    public synchronized void call(){
        System.out.println("call");
    }
    public void hello(){
        System.out.println("hello");
    }
}