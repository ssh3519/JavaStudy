package com.ssh.threadlock;

import java.util.concurrent.CountDownLatch;

/**
 * CountDownLatch是一个同步的辅助类，允许一个或多个线程，等待其他一组线程完成操作，再继续执行。
 */
public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
//        closeDoor();
        CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i = 0; i < 6; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName()+"\t离开教室");
                countDownLatch.countDown();
            },String.valueOf(i)).start();
        }
        countDownLatch.await();
        System.out.println(Thread.currentThread().getName()+"\t班长关门走人");
    }

    private static void closeDoor() {
        for (int i = 0; i < 6; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName()+"\t离开教室");
            },String.valueOf(i)).start();
        }
        System.out.println(Thread.currentThread().getName()+"\t班长关门走人");
    }
}
