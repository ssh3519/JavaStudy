package com.ssh.guava;

import com.google.common.base.Preconditions;
import com.google.common.collect.*;

import java.util.*;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author ssh
 * @description
 * @date 2020/11/19 16:39
 */
public class Demo {
    public static void main7(String[] args) {
        Set<String> newHashSet1 = Sets.newHashSet("a", "a", "b", "c");
        Set<String> newHashSet2 = Sets.newHashSet("b", "b", "c", "d");

        // 交集
        Sets.SetView<String> intersectionSet = Sets.intersection(newHashSet1, newHashSet2);
        System.out.println(intersectionSet); // [b, c]

        // 并集
        Sets.SetView<String> unionSet = Sets.union(newHashSet1, newHashSet2);
        System.out.println(unionSet); // [a, b, c, d]

        // newHashSet1 中存在，newHashSet2 中不存在
        Sets.SetView<String> setView = Sets.difference(newHashSet1, newHashSet2);
        System.out.println(setView); // [a]
    }

    public static void main6(String[] args) {
        // 创建一个 ArrayList 集合
        List<String> list1 = Lists.newArrayList();
        // 创建一个 ArrayList 集合，同时塞入3个数据
        List<String> list2 = Lists.newArrayList("a", "b", "c");
        // 创建一个 ArrayList 集合，容量初始化为10
        List<String> list3 = Lists.newArrayListWithCapacity(10);

        LinkedList<String> linkedList1 = Lists.newLinkedList();
        CopyOnWriteArrayList<String> cowArrayList = Lists.newCopyOnWriteArrayList();

        HashMap<Object, Object> hashMap = Maps.newHashMap();
        ConcurrentMap<Object, Object> concurrentMap = Maps.newConcurrentMap();
        TreeMap<Comparable, Object> treeMap = Maps.newTreeMap();

        HashSet<Object> hashSet = Sets.newHashSet();
        HashSet<String> newHashSet = Sets.newHashSet("a", "a", "b", "c");
    }

    public static void main(String[] args) {
        List<String> arrayList = new ArrayList<>();
        arrayList.add("a");
        arrayList.add("b");
        List<String> jdkList = Collections.unmodifiableList(arrayList);
        ImmutableList<String> immutableList = ImmutableList.copyOf(arrayList);
        arrayList.add("ccc");
        jdkList.forEach(System.out::println);// result: a b ccc
        System.out.println("-------");
        immutableList.forEach(System.out::println);// result: a b
    }

    public static void main8(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        List<String> unmodifiableList = Collections.unmodifiableList(list);
        list.add("C");
        System.out.println(unmodifiableList.get(2));
        //unmodifiableList.add("C");
    }

    /**
     * 不可变的集合
     *
     * @param args
     */
    public static void main4(String[] args) {
        // 创建方式1：of
        ImmutableSet<String> immutableSet = ImmutableSet.of("a", "b", "c");
        immutableSet.forEach(System.out::println);

        // 创建方式2：builder
        ImmutableSet<String> immutableSet2 = ImmutableSet.<String>builder()
                .add("hello")
                .add(new String("未读代码"))
                .build();
        immutableSet2.forEach(System.out::println);

        // 创建方式3：从其他集合中拷贝创建
        ArrayList<String> arrayList = new ArrayList();
        arrayList.add("www.wdbyte.com");
        arrayList.add("https");
        ImmutableSet<String> immutableSet3 = ImmutableSet.copyOf(arrayList);
        immutableSet3.forEach(System.out::println);
    }

    /**
     * 非空判断
     *
     * @param args
     */
    public static void main1(String[] args) {
        String param = "未读代码";
        String name = Preconditions.checkNotNull(param);
        System.out.println(name); // 未读代码
        String param2 = null;
        String name2 = Preconditions.checkNotNull(param2, "param2 is null"); // NullPointerException
        System.out.println(name2);
    }

    /**
     * 预期值判断
     *
     * @param args
     */
    public static void main2(String[] args) {
        String param = "www.wdbyte.com2";
        String wdbyte = "www.wdbyte.com";
        Preconditions.checkArgument(wdbyte.equals(param), "[%s] 404 NOT FOUND", param);
    }

    /**
     * 是否越界
     *
     * @param args
     */
    public static void main3(String[] args) {
        List<String> list = Lists.newArrayList("a", "b", "c", "d");
        // 开始校验
        int index = Preconditions.checkElementIndex(5, list.size());
    }
}
