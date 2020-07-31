package com.ssh.threadlock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class MyCache
{
    //volatile保证可见性、有序性，不保证原子性
    private volatile Map<String,Object> map = new HashMap<>();
    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    public void put(String key,Object value){
        readWriteLock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName()+"\t ---写入数据"+key);
            try { TimeUnit.MILLISECONDS.sleep(300); } catch (InterruptedException e) {e.printStackTrace(); }
            map.put(key,value);
            System.out.println(Thread.currentThread().getName()+"\t ---写入完成");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readWriteLock.writeLock().unlock();
        }
    }

    public void get(String key){
        readWriteLock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName()+"\t 读取数据");
            try { TimeUnit.MILLISECONDS.sleep(300); } catch (InterruptedException e) {e.printStackTrace(); }
            Object result = map.get(key);
            System.out.println(Thread.currentThread().getName()+"\t 读取完成"+result);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readWriteLock.readLock().unlock();
        }
    }
}
/**
 * 多个线程同时读一个资源类为了满足并发问题，读取共享资源可以同时进行
 * 但是，如果有一个线程想去写共享资源，就不应该再有其他线程可以对该资源进行读或写
 */
public class ReadWriteLockDemo {
    public static void main(String[] args) {
        MyCache myCache = new MyCache();
        for (int i = 0; i < 5; i++) {
            final int tempInt = i;
            new Thread(() -> {
                myCache.put(tempInt+"",tempInt+"");
            },String.valueOf(i)).start();
        }

        for (int i = 0; i < 5; i++) {
            final int tempInt = i;
            new Thread(() -> {
                myCache.get(tempInt+"");
            },String.valueOf(i)).start();
        }
    }
}
