package com.ssh.Interview;

/**
 * @description
 * @author: ssh
 * @Date: 2020/9/16 13:54
 */
public class IntegerMaxValueDemo {
    public static void main(String[] args) {
        System.out.println(2^3);
    }
    /**
     * 加法
     */
    public static int addExact(int x, int y) {
        int r = x + y;
        // HD 2-12 Overflow iff both arguments have the opposite sign of the result
        if (((x ^ r) & (y ^ r)) < 0) {
            throw new ArithmeticException("integer overflow");
        }
        return r;
    }

    /**
     * 减法
     */
    public static int subtractExact(int x, int y) {
        int r = x - y;
        // HD 2-12 Overflow iff the arguments have different signs and
        // the sign of the result is different than the sign of x
        if (((x ^ y) & (x ^ r)) < 0) {
            throw new ArithmeticException("integer overflow");
        }
        return r;
    }

    /**
     * 乘法
     * @param x
     * @param y
     * @return
     */
    public static int multiplyExact(int x, int y) {
        long r = (long)x * (long)y;
        if ((int)r != r) {
            throw new ArithmeticException("integer overflow");
        }
        return (int)r;
    }
}
