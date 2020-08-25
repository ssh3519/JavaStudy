package com.ssh.Interview;

/**
 * @description
 * @author: ssh
 * @Date: 2020/8/20 11:00
 */
public class StaticDemo {
    private static int aaa = 100;

    public static void main(String[] args) {
        StaticDemo s1 = new StaticDemo();
        s1.aaa++;
        StaticDemo s2 = new StaticDemo();
        s2.aaa++;
        StaticDemo.aaa--;
        System.out.println(aaa);
    }
}
