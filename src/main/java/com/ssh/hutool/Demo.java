package com.ssh.hutool;

import cn.hutool.core.util.NumberUtil;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.LongAdder;

/**
 * @description
 * @author: ssh
 * @Date: 2020/10/26 14:21
 */
public class Demo {
    public static void main(String[] args) {
        //List<String> list = Arrays.asList("0.5", "1.5", "3.5");
        //String reduce = list.stream().reduce(String.valueOf(0), (a, b) -> String.valueOf(NumberUtil.add(a, b)));
        //System.out.println(reduce);
        LongAdder askForLeave = new LongAdder();
        askForLeave.increment();
        askForLeave.increment();
        askForLeave.increment();
        double v = NumberUtil.div(askForLeave, 2, 1, RoundingMode.DOWN).doubleValue();
        System.out.println(v);
    }
    public static void main2(String[] args) {
        //double n1 = 1.2341;
        BigDecimal n1 = new BigDecimal("11.11111");
        BigDecimal n2 = new BigDecimal("11.11111");
        //double n2 = 1.234;
        //double result = NumberUtil.add(n1, n2);
        BigDecimal result = NumberUtil.add(n1, n2);
        System.out.println(result);

    }
}
