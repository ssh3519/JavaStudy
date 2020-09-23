package com.ssh.Interview;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @description 如何在字符串中获取不同的字符及其数量？
 * @author: ssh
 * @Date: 2020/9/10 9:30
 */
public class DistinctCharsCount {
    public static void main(String[] args) {
        printDistinctCharsWithCount("itwanger");
        printDistinctCharsWithCount("chenmowanger");
    }

    private static void printDistinctCharsWithCount(String input) {
        Map<Character, Integer> charsWithCountMap = new LinkedHashMap<>();

        for (char c : input.toCharArray()) {
            Integer oldValue = charsWithCountMap.get(c);

            int newValue = (oldValue == null) ? 1 :
                    Integer.sum(oldValue, 1);

            charsWithCountMap.put(c, newValue);
        }
        System.out.println(charsWithCountMap);
    }

    private static void printDistinctCharsWithCountMerge(String input) {
        Map<Character, Integer> charsWithCountMap = new LinkedHashMap<>();

        for (char c : input.toCharArray()) {
            //第一个参数为键，第二个参数为值，第三个参数是一个 BiFunction，意思是，如果键已经存在了，就重新根据 BiFunction 计算新的值。
            charsWithCountMap.merge(c, 1, Integer::sum);
        }
        System.out.println(charsWithCountMap);
    }
}
