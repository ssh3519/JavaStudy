package com.ssh.communication;

public class Demo3_CAS {
    static volatile int t = 1;
    static volatile int i = 0;

    public static void main(String[] args) {
        new Thread(() -> {
            while (i<10){
                while (t!=1){
                }
                System.out.println(Thread.currentThread().getName()+":"+(++i));
                t=2;
            }
        },"A").start();

        new Thread(() -> {
            while (i<10){
                while (t!=2){
                }
                System.out.println(Thread.currentThread().getName()+":"+(++i));
                t=1;
            }
        },"B").start();
    }
}
