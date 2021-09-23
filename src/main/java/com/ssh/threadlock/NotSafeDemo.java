package com.ssh.threadlock;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * 举例说明集合类不安全
 * 1.故障现象java.util.ConcurrentModificationException
 * 2.导致原因  add方法没有锁
 * 3.解决方案
 *      3.1 使用 Vector
 *      3.2 使用 Collections.synchronizedList()
 *      3.3 使用 CopyOnWriteArrayList（写时复制）；CopyOnWriteArrayList、CopyOnWriteArraySet
 *   CopyOnWrite容器即写时复制的容器。往一个容器中添加元素的时候，不直接往当前容器Object[]添加，而是先将当前容器Object[]进行copy，复制出新的容器Object[] newElements，
 *   然后再在新的容器中添加元素，添加完之后，再将原容器的引用指向新的容器。好处：可以对CopyOnWrite容器进行并发的读，而不需要加锁，因为当前容器不会添加任何元素。
 *   所以CopyOnWrite容器也是一种读写分离的思想，读和写不同的容器。
 *      public boolean add(E e) {
 *         final ReentrantLock lock = this.lock;
 *         lock.lock();
 *         try {
 *             Object[] elements = getArray();
 *             int len = elements.length;
 *             Object[] newElements = Arrays.copyOf(elements, len + 1);
 *             newElements[len] = e;
 *             setArray(newElements);
 *             return true;
 *         } finally {
 *             lock.unlock();
 *         }
 *     }
 * 4.优化建议
 */
public class NotSafeDemo {
    public static void main(String[] args) {
//        listNotSafe();
//        setNotSafe();

        mapNotSafe();
    }
    /**
     * HashMap底层是数组和链表
     */
    private static void mapNotSafe() {
//        Map<String,String> map = Collections.synchronizedMap(new HashMap<>());
        Map<String,String> map = new ConcurrentHashMap<>();
        for (int i = 0; i < 30; i++) {
            new Thread(() -> {
                map.put(Thread.currentThread().getName(), UUID.randomUUID().toString().substring(0,8));
                System.out.println(map);
            },String.valueOf(i)).start();
        }
    }

    /**
     * HashSet底层是HashMap，add方法对应HashMap put方法的key，value为Object常量
     */
    private static void setNotSafe() {
//        Set<String> set = Collections.synchronizedSet(new HashSet<>());
        Set<String> set = new CopyOnWriteArraySet<>();
        for (int i = 0; i < 30; i++) {
            new Thread(() -> {
                set.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(set);
            },String.valueOf(i)).start();
        }
    }

    /**
     * ArrayList底层是数组
     */
    private static void listNotSafe() {
//        List<String> list = new ArrayList<>();
//        List<String> list = Collections.synchronizedList(new ArrayList<>());
        Vector<String> vector = new Vector<>();
        List<String> list = new CopyOnWriteArrayList<>();
        for (int i = 0; i < 30; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(list);
            },String.valueOf(i)).start();
        }
    }
}
