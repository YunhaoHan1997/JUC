package com.han.productorAndConsumer;

/**
 * @Author Han
 * @Date 2020/9/29
 */
/**
 * 线程之间的通信问题:生产者和消费者问题! 等待唤醒，通知唤醒
 * 线程交替执行 A B 操作同一个变量 num = 0
 * A num+1
 * B num-1
 */

public class A {
    public static void main(String[] args) {
        Data data = new Data();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try { data.increment();
                } catch (InterruptedException e) { e.printStackTrace();
                } }
        },"A").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try { data.decrement();
                } catch (InterruptedException e) { e.printStackTrace();
                } }
        },"B").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try { data.increment();
                } catch (InterruptedException e) { e.printStackTrace();
                } }
        },"C").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try { data.decrement();
                } catch (InterruptedException e) { e.printStackTrace();
                } }
        },"D").start();
    }
}
class Data{
    private int number = 0;
    //+1
    public synchronized void increment() throws InterruptedException {
        while (number!=0) {
            //等待操作
            wait();
        }
        number++;
        System.out.println(Thread.currentThread().getName()+"=>"+number);
        //通知其他线程，+1完毕
        notifyAll();
    }
    //-1
    public synchronized void decrement() throws InterruptedException {
        while (number == 0){
            //等待
            wait();
        }
        number--;
        System.out.println(Thread.currentThread().getName()+"=>"+number);
        //通知其他线程我-1完毕
        notifyAll();

    }
}