package com.han.productorAndConsumer;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author Han
 * @Date 2020/9/29
 */

public class C {
    public static void main(String[] args) {
    Data3 data = new Data3(); new Thread(()->{
        for (int i = 0; i <10 ; i++) { data.printA();
        } },"A").start();
    new Thread(()->{
        for (int i = 0; i <10 ; i++) {
            data.printB(); }
    },"B").start();
    new Thread(()->{
        for (int i = 0; i <10 ; i++) {
            data.printC(); }
    },"C").start(); }
}
class Data3{
    private Lock lock = new ReentrantLock();
    public void printA(){
        lock.lock();
        try {
            //业务，判断->执行->通知

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
    }
    public void printB(){

    }
    public void printC(){

    }
}