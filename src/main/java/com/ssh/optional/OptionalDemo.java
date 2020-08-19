package com.ssh.optional;

import javafx.util.Pair;

import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.LongAdder;
import java.util.stream.Collectors;

/**
 * @description
 * @author: ssh
 * @email: 18367183519@163.com
 * @Date: 2020/7/29 10:31
 */
public class OptionalDemo {
    public static void main(String[] args) {
/*        String str = "null";
        //String s = Optional.ofNullable(str).orElse("aaa");
        String s = Optional.ofNullable(str).orElseGet(() -> "bbb");
        System.out.println(s);

        //=========================Collectors.toMap=========================================================
        List<Pair<String, Double>> pairArrayList = new ArrayList<>(3);
        pairArrayList.add(new Pair<>("version", 12.10));
        pairArrayList.add(new Pair<>("version", 12.19));
        pairArrayList.add(new Pair<>("version", 6.28));
        Map<String, Double> map = pairArrayList.stream()
                .collect(Collectors.toMap(Pair::getKey,Pair::getValue,(v1, v2) -> v1));
        System.out.println(map);
        map.forEach((k,v) -> System.out.println(k+":"+v));
        //====================================================================================================
        LongAdder longAdder = new LongAdder();
        longAdder.increment();
        System.out.println(longAdder.toString());

        String date = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy年MM月dd日"));
        System.out.println(date);*/

        CompletableFuture<String> cf = CompletableFuture.completedFuture(null);
        String now = cf.getNow(null);
        System.out.println(now);

    }
}
