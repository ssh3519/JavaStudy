package com.ssh.suanfa;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 统计一个字符串中每个字符出现的次数，并按数量从大到小顺序输出
 * @author: ssh
 * @email: 18367183519@163.com
 * @Date: 2020/6/1 0001 21:15
 */
public class TongJiZiFu {
    public static void main(String[] args) {
        String str="aabbbccdejtljlssd";
        Map<Character, Integer> map=countChar(str);

        Map<Character, Integer> result = new LinkedHashMap<>();

        show(map);
    }

    private static void show(Map<Character, Integer> map) {
        Set<Map.Entry<Character, Integer>> entries = map.entrySet();
        List<Map.Entry<Character, Integer>> list = new ArrayList<>();
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
//            System.out.println(entry.getKey()+":"+entry.getValue());
            list.add(entry);
        }
        Collections.sort(list, new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                //return o1.getValue() - o2.getValue(); // 升序
                return o2.getValue() - o1.getValue(); // 降序
            }
        });
        for (Map.Entry<Character, Integer> entry : list) {
            System.out.println(entry.getKey()+":"+entry.getValue());
        }
    }

    public static Map<Character, Integer> countChar(String str){
        char[] buf=str.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (char c : buf) {
            Integer count = map.getOrDefault(c,0);
            count++;
            map.put(c,count);
        }
        return map;
    }

}
