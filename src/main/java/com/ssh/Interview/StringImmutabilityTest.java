package com.ssh.Interview;

/**
 * @description 如何证明字符串是不可变的？
 * @author: ssh
 * @Date: 2020/9/10 9:14
 */
public class StringImmutabilityTest {
    public static void main(String[] args) {
        String s1 = "沉默王二";
        String s2 = s1;
        System.out.println(s1 == s2);

        s1 = "沉默王三";
        System.out.println(s1 == s2);

        System.out.println(s2);
    }
}
