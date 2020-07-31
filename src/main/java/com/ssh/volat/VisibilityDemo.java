package com.ssh.volat;

import java.util.concurrent.TimeUnit;

public class VisibilityDemo {
    private static volatile boolean is = true;
    static Thread t1;
    public static void main(String[] args) {
        t1 = new Thread(() -> {
            int i = 0;
            while (true) {
                if(t1.isInterrupted()){
                    break;
                }
                i++;
            }
            System.out.println(i);
        }, "A");
        t1.start();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t1.interrupt();

/*        new Thread(() -> {
            int i = 0;
            while(VisibilityDemo.is){
                i++;
            }
            System.out.println(i);
        },"A").start();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        VisibilityDemo.is = false;
        System.out.println("被设置为false");*/
    }
}
