package com.ssh.threadlock;

/**
 * @description 死锁
 * @author: ssh
 * @Date: 2020/8/14 14:19
 */
public class DeadLock {
    private static Object obj1 = new Object();
    private static Object obj2 = new Object();

    public static void main(String[] args) {
        new Thread(() -> {
            synchronized (obj1) {
                System.out.println(Thread.currentThread().getName() + "获得了obj1锁");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (obj2) {
                    System.out.println(Thread.currentThread().getName() + "获得了obj2锁");
                }
            }
        }, "A").start();

        new Thread(() -> {
            synchronized (obj2) {
                System.out.println(Thread.currentThread().getName() + "获得了obj2锁");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (obj1) {
                    System.out.println(Thread.currentThread().getName() + "获得了obj1锁");
                }
            }
        }, "B").start();
    }
}
