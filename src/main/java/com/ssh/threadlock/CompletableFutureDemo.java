package com.ssh.threadlock;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompletableFutureDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService threadPool = Executors.newFixedThreadPool(10);
        CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(() -> {
            System.out.println(Thread.currentThread().getName() + "没有返回");
        }, threadPool);
        completableFuture.get();//阻塞

        //异步回调
        CompletableFuture<Integer> completableFuture2 = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + "有返回");
            int i = 10 / 0;
            return 1024;
        }, threadPool).whenComplete((t, u) -> {
            System.out.println("____t:" + t);
            System.out.println("____u:" + u);
        }).exceptionally(f -> {
            System.out.println("------exception:" + f.getMessage());
            return 4444;
        });

        CompletableFuture<Integer> future = completableFuture2.handle((res, t) -> {
            if (res != null) {
                return res * 2;
            }
            if (t != null) {
                return 0;
            }
            return 0;
        });

        //串行化
        CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + "有返回");
            int i = 10 / 0;
            return 1024;
        }, threadPool).thenApplyAsync(res -> {
            return res * 2;
        }, threadPool).thenAcceptAsync(res -> {
            System.out.println("完成" + res);
        }, threadPool).thenRunAsync(() -> {
            System.out.println("完成");
        }, threadPool);

        //两个都完成
        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + "有返回");
            int i = 10 / 4;
            return 1024;
        }, threadPool);

        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + "有返回");
            int i = 10 / 4;
            return 1024;
        }, threadPool);

        future1.runAfterBothAsync(future2, () -> System.out.println("a"), threadPool);
        future1.thenAcceptBoth(future2, (f1, f2) -> System.out.println(f1 + f2));
        future1.thenCombineAsync(future2, (f1, f2) -> {
            return f1 + f2;
        }, threadPool);

        //只要1个任务完成
        future1.runAfterEitherAsync(future2, () -> System.out.println("a"), threadPool);
        future1.acceptEither(future2, res -> {
            System.out.println("a");
        });
        future1.applyToEither(future2, res -> {
            return res * 2;
        });
        //多任务组合
        CompletableFuture<Void> allOf = CompletableFuture.allOf(future1, future2);
        allOf.get();
        CompletableFuture<Object> anyOf = CompletableFuture.anyOf(future1, future2);
        anyOf.get();
    }
}
