package com.ssh.threadlocal;

/**
 * synchronized 同步机制采用“时间换空间”的方式，只提供一份变量，让不同的线程排队访问；多个线程之间访问资源的同步
 * ThreadLocal 采用“空间换时间”的方式，为每个线程都提供一份变量的副本，从而实现同时访问互不干扰；多线程中让每个线程之间的数据相互隔离
 */
public class ThreadLocal01 {

    ThreadLocal<String> threadLocal = new ThreadLocal<>();
    private String content;

    public String getContent() {
        String content = threadLocal.get();
        return content;
    }

    public void setContent(String content) {
//        this.content = content;
        threadLocal.set(content);
    }

    public static void main(String[] args) {
        ThreadLocal01 threadLocal01 = new ThreadLocal01();
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                threadLocal01.setContent(Thread.currentThread().getName()+"的数据");
                System.out.println("-----------------------------------------");
                System.out.println(Thread.currentThread().getName()+"--->"+threadLocal01.getContent());
            },String.valueOf(i)).start();
        }
    }
}
