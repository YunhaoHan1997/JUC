package com.han.pool;

import java.util.concurrent.*;

/**
 * @Author Han
 * @Date 2020/11/8
 */

public class Demo1 {
    public static void main(String[] args) {
        //executor创建线程池的三种方式
//        ExecutorService threadPool = Executors.newSingleThreadExecutor();
//        ExecutorService threadPool2 = Executors.newFixedThreadPool(5);
//        ExecutorService threadPool3 = Executors.newCachedThreadPool();

        //ThreadPoolExecutor创建线程池,7大参数
        ExecutorService threadPool3 = new ThreadPoolExecutor(2,
                5,
                3,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy()//银行全满，还有人要进入

                );

        ExecutorService threadPool4 = new ThreadPoolExecutor(2,
                5,
                3,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.CallerRunsPolicy()//调用执行自己的线程来运行任务，此处调用了main线程

        );

        ExecutorService threadPool5 = new ThreadPoolExecutor(2,
                5,
                3,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardPolicy()//线程池满了，不会抛出异常，也不会处理新任务

        );
        ExecutorService threadPool6 = new ThreadPoolExecutor(2,
                5,
                3,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardOldestPolicy()//线程池满了，新线程会替换掉旧线程

        );
        System.out.println(Runtime.getRuntime().availableProcessors());
        try {
            for (int i = 0; i < 19; i++) {
                threadPool6.execute(()->{
                    System.out.println(Thread.currentThread().getName());
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool6.shutdown();
        }
    }
}
