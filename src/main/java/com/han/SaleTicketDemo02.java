package com.han;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author Han
 * @Date 2020/9/29
 */

public class SaleTicketDemo02 {
    public static void main(String[] args) {
// 并发:多线程操作同一个资源类, 把资源类丢入线程
        Ticket2 ticket = new Ticket2();
// @FunctionalInterface 函数式接口，jdk1.8 lambda表达式 (参数)->{ 代码 }
        new Thread(() -> {
            for (int i = 1; i < 40; i++) ticket.sale();
        }, "A").start();
        new Thread(() -> {
            for (int i = 1; i < 40; i++) ticket.sale();
        }, "B").start();
        new Thread(() -> {
            for (int i = 1; i < 40; i++) ticket.sale();
        }, "C").start();

    }
}
class Ticket2{
    private int number = 50;
    Lock lock = new ReentrantLock();

    //买票的方式
    public void sale(){
        lock.lock();

        try {
            if(number>0){

                System.out.println(Thread.currentThread().getName() + "卖出了第" + (number--) + "张票"+ "剩余:"+number);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    }
