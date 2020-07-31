package com.ssh.threadlock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public class ABADemo {
    static AtomicReference<Integer> atomicReference =new AtomicReference<>(100);
    public static void main(String[] args) {
        new Thread(() -> {
            atomicReference.compareAndSet(100,101);
            atomicReference.compareAndSet(101,100);
        },"t1").start();

        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(atomicReference.compareAndSet(100,2019)+"\t"+atomicReference.get());
        },"t2").start();
    }
}
