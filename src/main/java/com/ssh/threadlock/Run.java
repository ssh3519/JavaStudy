package com.ssh.threadlock;

class Thread1 extends Thread
{
    public void run(){
        try {
            for(int i=0; i<500000; i++){
                if(this.isInterrupted()) {
                    System.out.println("线程已经终止， for循环不再执行");
                    throw new InterruptedException();
                }
                System.out.println("i="+(i+1));
            }

            System.out.println("这是for循环外面的语句，也会被执行");
        } catch (InterruptedException e) {
            System.out.println("进入MyThread.java类中的catch了。。。");
            e.printStackTrace();
        }
    }
}

class Run {
    public static void main(String args[]){
        Thread thread = new Thread1();
        thread.start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();

    }
}
