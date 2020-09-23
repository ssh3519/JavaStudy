package com.ssh.Interview;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * @description 如何检查两个字符串中的字符是相同的？
 * @author: ssh
 * @Date: 2020/9/10 9:18
 */
public class CheckSameCharsInString {
    public static void main(String[] args) {
        sameCharsStrings("沉默王二", "沉王二默");
        sameCharsStrings("沉默王二", "沉默王三");
    }

    private static void sameCharsStrings(String s1, String s2) {
        Set<Character> set1 = s1.chars().mapToObj(c -> (char) c).collect(Collectors.toSet());
        System.out.println(set1);
        Set<Character> set2 = s2.chars().mapToObj(c -> (char) c).collect(Collectors.toSet());
        System.out.println(set2);
        System.out.println(set1.equals(set2));
    }
}
