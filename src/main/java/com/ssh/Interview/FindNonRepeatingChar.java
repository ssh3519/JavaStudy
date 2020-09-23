package com.ssh.Interview;

import java.util.ArrayList;
import java.util.List;

/**
 * @description 如何从字符串中找出第一个不重复的字符？
 * 1）把字符串拆分成字符数组。
 *
 * 2）声明一个 List，把重复的字符放进去。
 *
 * 3）外层的 for 循环，从第一个字符开始，如果已经在 List 中，继续下一轮。
 *
 * 4）嵌套的 for 循环，从第一个字符的下一个字符（j = i + 1）开始遍历，如果找到和之前字符重复的，就加入到 List 中，跳出内层的循环；如果找到最后（j == chars.length - 1）也没有找到，就是第一个不重复的字符，
 *
 * @author: ssh
 * @Date: 2020/9/10 9:27
 */
public class FindNonRepeatingChar {
    public static void main(String[] args) {
        System.out.println(printFirstNonRepeatingChar("沉默王沉沉默二"));
        System.out.println(printFirstNonRepeatingChar("沉默王沉"));
        System.out.println(printFirstNonRepeatingChar("沉沉沉"));
    }

    private static Character printFirstNonRepeatingChar(String string) {
        char[] chars = string.toCharArray();

        List<Character> discardedChars = new ArrayList<>();

        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];

            if (discardedChars.contains(c))
                continue;

            for (int j = i + 1; j < chars.length; j++) {
                if (c == chars[j]) {
                    discardedChars.add(c);
                    break;
                } else if (j == chars.length - 1) {
                    return c;
                }
            }
        }
        return null;
    }
}
