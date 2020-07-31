package com.ssh.threadlock;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class BlockingQueueDemo {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);
        //超时
        System.out.println(blockingQueue.offer("a", 3L, TimeUnit.SECONDS));
        System.out.println(blockingQueue.offer("a", 3L, TimeUnit.SECONDS));
        System.out.println(blockingQueue.offer("a", 3L, TimeUnit.SECONDS));
        System.out.println(blockingQueue.offer("a", 3L, TimeUnit.SECONDS));

        //满了再插会阻塞
        /*blockingQueue.put("a");
        blockingQueue.put("a");
        blockingQueue.put("a");
//        blockingQueue.put("a");
        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());*/

        //满了再插会返回false
        /*System.out.println(blockingQueue.offer("a"));
        System.out.println(blockingQueue.offer("b"));
        System.out.println(blockingQueue.offer("c"));
//        System.out.println(blockingQueue.offer("x"));
//        System.out.println(blockingQueue.peek());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
//        System.out.println(blockingQueue.poll());*/


        //满了再插会抛异常
        /*System.out.println(blockingQueue.add("a"));
        System.out.println(blockingQueue.add("b"));
        System.out.println(blockingQueue.add("c"));
//        System.out.println(blockingQueue.add("x"));
        System.out.println(blockingQueue.element());//检查队列队首的元素

        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
//        System.out.println(blockingQueue.remove());*/
    }
}
