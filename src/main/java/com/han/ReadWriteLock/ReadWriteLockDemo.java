package com.han.ReadWriteLock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Author Han
 * @Date 2020/11/8
 */

public class ReadWriteLockDemo {
    public static void main(String[] args) {
        MyCache myCache = new MyCache();

        for (int i = 0; i < 5; i++) {
            final  int temp = i;
            new Thread(() -> {
                myCache.put(temp + "", temp + "");
            },String.valueOf(i)).start();
        }
        for (int i = 0; i < 5; i++) {
            final  int temp = i;
            new Thread(() -> {
                myCache.get(temp + "");
            },String.valueOf(i)).start();
        }

    }
}
//加入读写锁
class MyCache{
    private volatile Map<String,Object> map = new HashMap<>();
    //读写锁：粒度更小
    private ReadWriteLock lock= new ReentrantReadWriteLock();
    //存，写的时候，只希望同时只有一个线程写，加一把写锁

    public void put(String key,Object value){
        lock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "写入" + key);
            map.put(key,value);
            System.out.println(Thread.currentThread().getName() + "写入完毕");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.writeLock().unlock();
        }

    }

    //读取，希望多线程同时操作
    public void get(String key){
        lock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "读取" + key);
            Object o = map.get(key);
            System.out.println(Thread.currentThread().getName() + "读取完毕" + key);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.readLock().unlock();
        }

    }
}