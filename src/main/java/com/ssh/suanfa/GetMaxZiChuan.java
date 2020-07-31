package com.ssh.suanfa;

/**
 * @author: ssh
 * @email: 18367183519@163.com
 * @Date: 2020/6/1 0001 22:23
 */
public class GetMaxZiChuan {
    public static void main(String[] args) {
        String strOne = "abcdefg";
        String strTwo = "adefgwgeweg";
        String result = maxSubstring(strOne, strTwo);
        System.out.println(result);
    }

    // 求解两个字符号的最长公共子串
    public static String maxSubstring(String strOne, String strTwo) {
        // 参数检查
        if(strOne==null || strTwo == null){
            return null;
        }
        if(strOne.equals("") || strTwo.equals("")){
            return null;
        }
        String max = strOne.length()>strTwo.length()?strOne:strTwo;
        String min = max == strOne?strTwo:strOne;
        String current = "";
        // 遍历较短的字符串，并依次减少短字符串的字符数量，判断长字符是否包含该子串
        for (int i = 0; i < min.length(); i++) {
            for (int begin=0,end=min.length()-i;end<=min.length();begin++,end++){
                current = min.substring(begin,end);
                if (max.contains(current)){
                    return current;
                }
            }
        }
        return null;
    }
}
