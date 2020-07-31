package com.ssh.threadlock;

import java.util.concurrent.*;

public class MyThreadPoolDemo {
    public static void main(String[] args) {
//        initPool();
        ExecutorService threadPool = new ThreadPoolExecutor(
                2,
                5,
                2L,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());
        //最大线程数满以及阻塞队列已满的拒绝策略
        //new ThreadPoolExecutor.AbortPolicy()          超过直接抛异常（默认）
        //new ThreadPoolExecutor.CallerRunsPolicy()     超过不会抛弃任务，也不会抛弃异常，而是将某些任务回退给调用者，从而降低新任务的流量
        //new ThreadPoolExecutor.DiscardPolicy()        直接抛弃无法处理的任务，不予任何处理也不抛异常
        //new ThreadPoolExecutor.DiscardOldestPolicy()  抛弃队列中等待最久的任务

        try {
            //模拟有6个顾客过来办理业务，目前池子里有5个工作人员提供服务
            for (int i = 0; i < 9; i++) {
                final int tempInt = i;
                threadPool.execute(() -> {
                    System.out.println(Thread.currentThread().getName()+"\t 办理业务"+tempInt);
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }
    }

    private static void initPool() {
//        ExecutorService threadPool = Executors.newFixedThreadPool(5);//一池5个线程
//        ExecutorService threadPool = Executors.newSingleThreadExecutor();//一池1个线程
        ExecutorService threadPool = Executors.newCachedThreadPool();//一池N个线程，可扩容线程池
        try {
            //模拟有10个顾客过来办理业务，目前池子里有5个工作人员提供服务
            for (int i = 0; i < 10; i++) {
                final int tempInt = i;
                threadPool.execute(() -> {
                    System.out.println(Thread.currentThread().getName()+"\t 办理业务"+tempInt);
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }
    }
}
