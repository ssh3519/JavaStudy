package com.ssh.threadlock;

import java.io.IOException;

public class JVMNote {
    public static void main(String[] args) throws IOException {
        long maxMemory = Runtime.getRuntime().maxMemory();   //Java虚拟机最大内存量
        long totalMemory = Runtime.getRuntime().totalMemory();  //Java虚拟机内存总量
        System.out.println("-Xmx:MAX_MEMORY = " + maxMemory +"(字节）、" + (maxMemory/(double)1024/1024) + "MB");
        System.out.println("-Xmx:TOTAL_MEMORY = " + totalMemory +"(字节）、" + (totalMemory/(double)1024/1024) + "MB");
        System.in.read();
    }
}
