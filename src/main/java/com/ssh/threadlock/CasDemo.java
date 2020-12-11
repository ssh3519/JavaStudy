package com.ssh.threadlock;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;

public class CasDemo {
    public static void main1(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(50);
        atomicInteger.getAndIncrement();
    }

    public static void main(String[] args) {
        AtomicStampedReference<Integer> atomicStampedReference = new AtomicStampedReference<>(100, 1);
        int stamp = atomicStampedReference.getStamp();
        atomicStampedReference.compareAndSet(100,101,stamp,stamp+1);
    }
}
