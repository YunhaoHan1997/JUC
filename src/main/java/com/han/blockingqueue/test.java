package com.han.blockingqueue;

import java.security.PublicKey;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @Author Han
 * @Date 2020/11/8
 */

public class test {
    public static void main(String[] args) throws InterruptedException {
        test4();

    }

    /**
     * 抛出异常，add move
     */
    public static void test1(){
        BlockingQueue blockingQueue = new ArrayBlockingQueue(3);
        blockingQueue.add("a");
        blockingQueue.add("b");
        blockingQueue.add("c");
        System.out.println(blockingQueue.remove());
    }
    /**
     *不抛出异常 offer poll
     */
    public static void test2(){
        BlockingQueue blockingQueue = new ArrayBlockingQueue(3);
        blockingQueue.offer("a");
        blockingQueue.offer("b");
        blockingQueue.offer("c");
        System.out.println(blockingQueue.offer("d"));
    }

    /**
     * 满了之后等待，阻塞
     */
    public static void test3() throws InterruptedException {
        BlockingQueue blockingQueue = new ArrayBlockingQueue(3);
        blockingQueue.put("a");
        blockingQueue.put("b");
        blockingQueue.put("c");
        //blockingQueue.put("d");
        blockingQueue.take();
        blockingQueue.take();
        blockingQueue.take();
        //blockingQueue.take();
    }
    /**
     * 满了之后等待，超时等待
     */
    public static void test4() throws InterruptedException {
        BlockingQueue blockingQueue = new ArrayBlockingQueue(3);
        blockingQueue.put("a");
        blockingQueue.put("b");
        blockingQueue.put("c");
        blockingQueue.offer("d", 2,TimeUnit.SECONDS);
        blockingQueue.take();
        blockingQueue.take();
        blockingQueue.take();
        //blockingQueue.take();
    }
}
