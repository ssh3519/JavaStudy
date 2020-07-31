package com.ssh.threadlocal;

public class ThreadLocal02 {

    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public static void main(String[] args) {
        ThreadLocal02 threadLocal02 = new ThreadLocal02();
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                synchronized (ThreadLocal02.class){
                    threadLocal02.setContent(Thread.currentThread().getName()+"的数据");
                    System.out.println("-----------------------------------------");
                    System.out.println(Thread.currentThread().getName()+"--->"+threadLocal02.getContent());
                }
            },String.valueOf(i)).start();
        }
    }
}
