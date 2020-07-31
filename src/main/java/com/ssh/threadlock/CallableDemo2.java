package com.ssh.threadlock;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

class MyCallable implements Callable<String>
{
    private String name;

    public MyCallable(String name) {
        this.name = name;
    }

    @Override
    public String call() throws Exception {
        return name;
    }
}
public class CallableDemo2 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService threadPool = Executors.newFixedThreadPool(5);
        List<Future> list = new ArrayList<>();
        try {
            for (int i = 0; i < 5; i++) {
                MyCallable c = new MyCallable(i + "");
                Future<String> future = threadPool.submit(c);
                System.out.println(i);
                list.add(future);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }
        for (Future future : list) {
            System.out.println(future.get().toString());
        }
    }
}
