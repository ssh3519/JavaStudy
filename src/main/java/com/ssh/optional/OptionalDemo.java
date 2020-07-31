package com.ssh.optional;

import java.util.Optional;

/**
 * @description
 * @author: ssh
 * @email: 18367183519@163.com
 * @Date: 2020/7/29 10:31
 */
public class OptionalDemo {
    public static void main(String[] args) {
        String str = "null";
        //String s = Optional.ofNullable(str).orElse("aaa");
        String s = Optional.ofNullable(str).orElseGet(() -> "bbb");
        System.out.println(s);
    }
}
