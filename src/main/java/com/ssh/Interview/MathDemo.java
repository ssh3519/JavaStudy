package com.ssh.Interview;

import cn.hutool.core.util.NumberUtil;

import java.math.BigDecimal;
import java.math.RoundingMode;


/**
 * @description
 * @author: ssh
 * @Date: 2020/11/12 17:21
 */
public class MathDemo {

    public static void main(String[] args) {
        Double a = 3.9999;
        Integer b = 8;
        BigDecimal div = NumberUtil.div(a, b, 1, RoundingMode.DOWN);
        System.out.println(div);
    }

    /**
     * 按天加班
     *
     * @param args
     */
    public static void main2(String[] args) {
        int floor = (int) Math.floor(1.9);
        System.out.println(floor);
    }

    /**
     * 按半天加班
     *
     * @param args
     */
    public static void main3(String[] args) {
        BigDecimal round = NumberUtil.round(0.58, 1, RoundingMode.FLOOR);
        int a = round.multiply(new BigDecimal(10)).intValue();
        double b = (a - a % 5) / 10.0;
        System.out.println(b);
    }
}


