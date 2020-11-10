package com.han.add;

import java.util.concurrent.CountDownLatch;

/**
 * @Author Han
 * @Date 2020/11/7
 */

public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        //总数是6,倒计时
        CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i = 0; i < 6; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "get out");
                countDownLatch.countDown();//计数器-1
            },String.valueOf(i)).start();
        }
        countDownLatch.await();//等待计数器归零,然后再往下执行
        System.out.println("关门");
    }
}
