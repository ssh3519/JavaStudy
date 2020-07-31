package com.ssh.communication;

import java.util.concurrent.locks.LockSupport;

public class Demo2_LockSupport {
    static volatile int i = 0;
    static Thread t1,t2,t3;
    public static void main(String[] args) {
        t1 = new Thread(() -> {
            while (i<10) {
                System.out.println(Thread.currentThread().getName()+":"+(++i));
                LockSupport.unpark(t2);
                LockSupport.park();
            }
        }, "A");

        t2 = new Thread(() -> {
            while (i<10) {
                LockSupport.park();
                System.out.println(Thread.currentThread().getName()+":"+(++i));
                LockSupport.unpark(t3);
            }
        }, "B");

        t3 = new Thread(() -> {
            while (i<10) {
                LockSupport.park();
                System.out.println(Thread.currentThread().getName()+":"+(++i));
                LockSupport.unpark(t1);
            }
        }, "C");
        t1.start();
        t2.start();
        t3.start();
    }
}
