package com.ssh.threadlock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class AirCondition
{
    private int number = 0;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void increment() throws InterruptedException{
        lock.lock();
        try {
            //判断
            while (number != 0){
                condition.await();
            }
            //干活
            number++;
            System.out.println(Thread.currentThread().getName()+"\t"+number);
            //通知
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void decrement() throws InterruptedException{
        lock.lock();
        try {
            while (number == 0){
                condition.await();
            }
            number--;
            System.out.println(Thread.currentThread().getName()+"\t"+number);
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    /*public synchronized void increment() throws InterruptedException {
        //1.判断
        while (number != 0){
            this.wait();
        }
        //2.干活
        number++;
        System.out.println(Thread.currentThread().getName()+"\t"+number);
        //3.通知
        this.notifyAll();
    }

    public synchronized void decrement() throws InterruptedException {
        //1.判断
        while (number == 0){
            this.wait();
        }
        //2.干活
        number--;
        System.out.println(Thread.currentThread().getName()+"\t"+number);
        //3.通知
        this.notifyAll();
    }*/
}
/**
 * 一个变量初始值为0，一个线程加1，一个线程减1，实现交替10轮，变量仍为0
 *
 * 1.在高内聚低耦合的前提下，线程   操作（对外暴露的调用方法）   资源类
 * 2.判断/干活/通知
 * 3.多线程交互中，必须防止多线程的虚假唤醒，也即（判断只用while，不能用if）
 */
public class ThreadWaitNotifyDemo {
    public static void main(String[] args) {
        AirCondition airCondition = new AirCondition();

        new Thread(() -> {
            for (int i = 0; i < 10 ; i++) {
                try {
                    airCondition.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"A").start();

        new Thread(() -> {
            for (int i = 0; i < 10 ; i++) {
                try {
                    airCondition.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"B").start();

        new Thread(() -> {
            for (int i = 0; i < 10 ; i++) {
                try {
                    airCondition.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"C").start();

        new Thread(() -> {
            for (int i = 0; i < 10 ; i++) {
                try {
                    airCondition.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"D").start();
    }
}
