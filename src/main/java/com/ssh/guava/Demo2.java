package com.ssh.guava;

import com.google.common.base.CharMatcher;
import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.collect.*;
import com.google.common.primitives.Ints;

import java.util.*;

/**
 * @author ssh
 * @description
 * @date 2020/12/21 15:18
 */
public class Demo2 {
    public static void main1(String[] args) {
        Joiner joiner = Joiner.on(",").skipNulls();
        String join = joiner.join(Lists.newArrayList("a", null, "b"));
        System.out.println("join=" + join);
    }

    public static void main2(String[] args) {
        Splitter splitter = Splitter.on(",").trimResults().omitEmptyStrings();
        for (String s : splitter.split("a ,, ,b,,")) {
            System.out.println(s);
        }
    }

    public static void main3(String[] args) {
        CharMatcher any = CharMatcher.any();
        String s = any.retainFrom("abcdf");
        String abc = any.removeFrom("abc");
        System.out.println(abc);
    }

    public static void main4(String[] args) {
        List<Integer> list = Ints.asList(1, 2, 3, 4, 5);
        System.out.println(Ints.join(",",1,2,34));
        //数组合并
        int[] concat = Ints.concat(new int[]{1, 2}, new int[]{2, 3, 4});
        System.out.println(concat.length);
        //最大最小
        System.out.println("max="+Ints.max(concat)+","+"min="+Ints.min(concat));
        //是否包含
        System.out.println(Ints.contains(concat,5));
        int[] ints = Ints.toArray(list);
    }

    public static void main5(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        List<String> unmodifiableList = Collections.unmodifiableList(list);
        list.add("C");
        System.out.println(unmodifiableList.get(2));
        //unmodifiableList.add("C");
    }

    public static void main6(String[] args) {
        ArrayListMultimap<String, String> multimap = ArrayListMultimap.create();
        multimap.put("a","aaa");
        multimap.put("b","bbb");
        multimap.put("a","aaa");
        List<String> list = multimap.get("a");
        System.out.println(list.toString());
    }

    public static void main7(String[] args) {
        //key、value唯一
        HashBiMap<String, String> biMap = HashBiMap.create();
        biMap.put("a","b");
        biMap.put("c","b");
        //biMap.forcePut("c","b");
        String c = biMap.get("c");
        System.out.println(c);
    }

    public static void main(String[] args) {
        HashBasedTable<String, String, Integer> table = HashBasedTable.create();
        table.put("a","aaa",1);
        table.put("b","bbb",2);
        table.put("c","ccc",3);
        Set<Table.Cell<String, String, Integer>> set = table.cellSet();
        for (Table.Cell<String, String, Integer> cell : set) {
            String rowKey = cell.getRowKey();
            String columnKey = cell.getColumnKey();
            Integer value = cell.getValue();
        }

        Set<String> strings = table.rowKeySet();
        Set<String> strings1 = table.columnKeySet();
        Map<String, Integer> a = table.row("a");
        System.out.println(a);
        Map<String, Integer> aaa = table.column("aaa");
        System.out.println(aaa);
    }
}
