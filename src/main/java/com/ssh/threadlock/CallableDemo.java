package com.ssh.threadlock;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

class MyThread2 implements Runnable
{
    @Override
    public void run() {

    }
}

class MyThread implements Callable<Integer>
{
    @Override
    public Integer call() throws Exception {
        System.out.println("_____come in here");
        TimeUnit.SECONDS.sleep(4);
        return 1024;
    }
}

/**
 *     多线程，第三种方法
 *     1.get方法一把放在最后一行
 */
public class CallableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask futureTask = new FutureTask(new MyThread());
        new Thread(futureTask,"A").start();
        new Thread(futureTask,"B").start();
        System.out.println(futureTask.get());
    }
}
