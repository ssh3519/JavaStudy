package com.ssh.communication;

public class Demo1_WaitNotify {
    static int i=0;
    static Object obj = new Object();
    public static void main(String[] args) {
        new Thread(()->{
           synchronized (obj){
               while (i<10) {
                   System.out.println(Thread.currentThread().getName()+"t1:"+(++i));
                   obj.notify();
                   try {
                       obj.wait();
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
               }
               obj.notify();
           }
        },"A").start();

        new Thread(()->{
            synchronized (obj){
                while (i<10) {
                    System.out.println(Thread.currentThread().getName()+"t1:"+(++i));
                    obj.notify();
                    try {
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                obj.notify();
            }
        },"B").start();
    }
}
