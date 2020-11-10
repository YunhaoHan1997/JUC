package com.han.lock;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @Author Han
 * @Date 2020/11/9
 */

public class SpinLockDemo {
    AtomicReference<Thread>  atomicReference = new AtomicReference<>();
    //加锁
    public void myLock(){
        Thread thread = Thread.currentThread();
        System.out.println(Thread.currentThread().getName()+"mylock");
        while (!atomicReference.compareAndSet(null,thread)){}
    }
    //解锁
    public void myunLock(){
        Thread thread = Thread.currentThread();
        System.out.println(Thread.currentThread().getName()+"myunlock");
        atomicReference.compareAndSet(thread,null);
    }
}
