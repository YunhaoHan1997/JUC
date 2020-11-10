package com.han.lock;


import java.util.concurrent.TimeUnit;

/**
 * @Author Han
 * @Date 2020/11/9
 */

public class DeadLockDemo {
    public static void main(String[] args) {
        String lockA = "lockA";
        String lockB = "lockB";
        new Thread(new MyThread(lockA,lockB),"t1").start();
        new Thread(new MyThread(lockB,lockA),"t2").start();

    }
}
class MyThread implements Runnable{
    private String lockA;
    private String lockB;

    public MyThread(String lockA, String lockB) {
        this.lockA = lockA;
        this.lockB = lockB;
    }
    //public  native void stat();

    @Override
    public void run() {
        synchronized (lockA){
            System.out.println(Thread.currentThread().getName() + lockA + "get" + lockB);
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (lockB){
                System.out.println(Thread.currentThread().getName() + lockB + "get" + lockA);

            }
        }

    }
}
