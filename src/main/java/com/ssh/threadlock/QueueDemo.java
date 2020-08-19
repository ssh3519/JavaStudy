package com.ssh.threadlock;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @description
 * @author: ssh
 * @Date: 2020/8/18 9:49
 */
public class QueueDemo {
    public static void main(String[] args) {
        BlockingQueue<String> queue = new LinkedBlockingQueue<>();
        queue.add("a");
        queue.add("b");
        queue.add("c");
        queue.stream().forEach(System.out::print);
    }
}
