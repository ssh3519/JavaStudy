package com.ssh.threadlock;

import java.util.concurrent.TimeUnit;

class Phone
{
    public static synchronized void sendEmail()
    {
        //睡4秒
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("-------sendEmail");
    }

    public synchronized void sendSMS()
    {
        System.out.println("-------sendSMS");
    }

    public void hello()
    {
        System.out.println("-------hello");
    }
}

/**
 * 1.某一时刻，只能有一个线程访问资源类中的一个synchronized方法；锁的是当前对象this，被锁后，其他线程都不能进入到当前对象的其他synchronized方法
 * 2.加个普通方法后和同步锁无关；换成两个对象,不是同一把锁
 * 3.静态同步方法锁的的Class，就是一个模板
 */
public class Lock8 {
    public static void main(String[] args) throws InterruptedException {
        Phone phone = new Phone();
        Phone phone2 = new Phone();

        new Thread(() -> {
            phone.sendEmail();
        },"A").start();

        Thread.sleep(100);

        new Thread(() -> {
            phone.sendSMS();
//            phone2.sendSMS();
//            phone.hello();
        },"B").start();
    }
}
