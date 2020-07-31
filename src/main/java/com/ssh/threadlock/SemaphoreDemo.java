package com.ssh.threadlock;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * 信号量主要用于2个目的：1.用于多个共享资源的互斥使用  2.用于并发线程数的控制
 */
public class SemaphoreDemo {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);//模拟资源类，有3个空车位
        for (int i = 0; i < 6; i++) {
            new Thread(() -> {
                try {
                    semaphore.acquire();//当一个线程调用该方法时，它要么通过成功获取信号量（信号量-1），要么一直等下去，直到有线程释放信号量或超时。
                    System.out.println(Thread.currentThread().getName()+"\t抢到了车位");
                    TimeUnit.SECONDS.sleep(3);
                    System.out.println(Thread.currentThread().getName()+"\t离开了车位");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    semaphore.release();//释放，实际上会将信号量的值+1，然后唤醒等待的线程
                }
            },String.valueOf(i)).start();
        }
    }
}
