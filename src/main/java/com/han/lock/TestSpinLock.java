package com.han.lock;

import java.util.concurrent.TimeUnit;

/**
 * @Author Han
 * @Date 2020/11/9
 */

public class TestSpinLock {
    public static void main(String[] args) throws InterruptedException {
       SpinLockDemo lock =  new SpinLockDemo();
       new Thread(()->{
           lock.myLock();
           try {
               TimeUnit.SECONDS.sleep(5);
           } catch (Exception e) {
               e.printStackTrace();
           } finally {
               lock.myunLock();
           }
       },"T1").start();
        TimeUnit.SECONDS.sleep(3);
        new Thread(()->{
            lock.myLock();
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.myunLock();
            }
        },"T2").start();
    }
}
