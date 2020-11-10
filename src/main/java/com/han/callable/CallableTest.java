package com.han.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @Author Han
 * @Date 2020/11/7
 */

public class CallableTest {

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        FutureTask futureTask = new FutureTask(myThread);
        new Thread(futureTask).start();
    }
}

class MyThread implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        System.out.println("callable");
        return 102;
    }
}