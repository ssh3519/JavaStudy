package com.ssh.communication;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class ShareResource {
    private int number = 1;
    private Lock lock = new ReentrantLock();
    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private Condition condition3 = lock.newCondition();

    public void print1(){
        lock.lock();
        try {
            while (number%3!=1){
                condition1.await();
            }
            System.out.println(Thread.currentThread().getName()+":"+number);
            number++;
            condition2.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void print2(){
        lock.lock();
        try {
            while (number%3!=2){
                condition2.await();
            }
            System.out.println(Thread.currentThread().getName()+":"+number);
            number++;
            condition3.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void print3(){
        lock.lock();
        try {
            while (number%3!=0){
                condition3.await();
            }
            System.out.println(Thread.currentThread().getName()+":"+number);
            number++;
            condition1.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
public class Demo1_Lock {
    public static void main(String[] args) {
        ShareResource shareResource = new ShareResource();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                shareResource.print1();
            }
        },"A").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                shareResource.print2();
            }
        },"B").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                shareResource.print3();
            }
        },"C").start();
    }
}
