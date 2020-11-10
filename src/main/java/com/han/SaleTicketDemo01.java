package com.han;

/**
 * @Author Han
 * @Date 2020/9/29
 */

public class SaleTicketDemo01 {
    public static void main(String[] args) {
        // 并发:多线程操作同一个资源类, 把资源类丢入线程
        Ticket ticket = new Ticket();
        new Thread(()->{
            for (int i = 1; i < 60; i++) {
                ticket.sale();
            }
            },"A").start();
        new Thread(()->{            for (int i = 1; i < 60; i++) {
            ticket.sale();
        }},"B").start();
        new Thread(()->{            for (int i = 1; i < 60; i++) {
            ticket.sale();
        }},"C").start();

    }

}

class Ticket{
    private static int number = 50;
    //买票的方式
    public synchronized void sale(){
        if(number>0){
            System.out.println(Thread.currentThread().getName() + "卖出了第" + (number--) + "张票"+ "剩余:"+number);
        }
    }
}