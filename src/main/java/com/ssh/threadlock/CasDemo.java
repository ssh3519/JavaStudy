package com.ssh.threadlock;

import java.util.concurrent.atomic.AtomicInteger;

public class CasDemo {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(50);
        atomicInteger.getAndIncrement();
    }
}
