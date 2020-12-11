package com.ssh.util;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.util.NumberUtil;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;

/**
 * @description
 * @author: ssh
 * @Date: 2020/11/12 14:17
 */
public class DateUtil {
    public static void main(String[] args) {
        //String date1 = "2020-11-11 08:00";
        //String date2 = "2020-11-11 13:33";
        //double d = hourDifference2(date1, date2);
        //System.out.println(d);
        //System.out.println(d >= 5.5000000005);
        //System.out.println(date1.substring(0,10));

        //LocalTime localTime = LocalTime.parse("23:08", DateTimeFormatter.ofPattern("HH:mm"));
        //LocalTime now = localTime.plusHours(1);
        //System.out.println(now.toString());

        //String s = String.valueOf(cn.hutool.core.date.DateUtil.month(cn.hutool.core.date.DateUtil.parse("2020-02-22")));
        //System.out.println(s);

        //for (int i = 1, j = 1; i < 12; i++, j++) {
        //    String s = cn.hutool.core.date.DateUtil.formatDate((cn.hutool.core.date.DateUtil.offsetMonth(cn.hutool.core.date.DateUtil.parse("2020-01-01"), j)));
        //    System.out.println(s);
        //}
        //LocalDate parse = LocalDate.parse("2020-11-11");
        //boolean after = parse.isBefore(LocalDate.now());
        //System.out.println(after);

        //int hHmm = Integer.parseInt(cn.hutool.core.date.DateUtil.format(cn.hutool.core.date.DateUtil.parse("2020-11-11 14:30"), "HHmm"));
        //System.out.println(hHmm);

        //int day = cn.hutool.core.date.DateUtil.dayOfWeek(cn.hutool.core.date.DateUtil.parseDate("2020-12-1"));
        //String format = cn.hutool.core.date.DateUtil.format(new Date(), "yyyy-MM");
        //System.out.println(format);
        //String beforeDay = getBeforeDay();
        //String s = String.valueOf(cn.hutool.core.date.DateUtil.dayOfMonth(new Date()));
        //String dd = cn.hutool.core.date.DateUtil.format(cn.hutool.core.date.DateUtil.offsetDay(cn.hutool.core.date.DateUtil.date(), -1), "dd");
        //String year = String.valueOf(cn.hutool.core.date.DateUtil.year(cn.hutool.core.date.DateUtil.offsetDay(cn.hutool.core.date.DateUtil.date(), -1)));
        //String month = String.valueOf(cn.hutool.core.date.DateUtil.month(cn.hutool.core.date.DateUtil.offsetDay(cn.hutool.core.date.DateUtil.date(), -1))+1);
        //String day = String.valueOf(cn.hutool.core.date.DateUtil.dayOfMonth(cn.hutool.core.date.DateUtil.offsetDay(cn.hutool.core.date.DateUtil.date(), -1)));
        //System.out.println(day);
        long l = dayDifference("2020-11-12");
        System.out.println(l);
    }

    /**
     * 获取前一天的日期
     *
     * @return
     */
    public static String getBeforeDay() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime localDateTime = LocalDateTime.now().minusDays(1);
        return localDateTime.format(formatter);
    }

    /**
     * 计算当前日期与{@code endDate}的间隔天差
     *
     * @param endDate
     * @return
     */
    public static long until(LocalDate endDate) {
        return LocalDate.now().until(endDate, ChronoUnit.DAYS);
    }

    /**
     * 计算日期{@code startDate}与{@code endDate}的间隔天
     *
     * @param startDate
     * @param endDate
     * @return
     */
    public static long until(LocalDate startDate, LocalDate endDate) {
        return ChronoUnit.DAYS.between(startDate, endDate);
    }

    /**
     * 计算当前日期与传入日期的间隔天数
     *
     * @param date yyyy-MM-dd
     * @return
     */
    public static long dayDifference(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.parse(date, formatter);
        long until = LocalDate.now().until(localDate, ChronoUnit.DAYS);
        //return Math.abs(until);
        return until;
    }

    /**
     * 计算2个日期间的间隔天数
     *
     * @param date1
     * @param date2
     * @return
     */
    public static long dayDifference(String date1, String date2) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate1 = LocalDate.parse(date1, formatter);
        LocalDate localDate2 = LocalDate.parse(date2, formatter);
        return ChronoUnit.DAYS.between(localDate1, localDate2);
    }

    /**
     * 计算2个时间的间隔小时
     *
     * @param datetime1
     * @param datetime2
     * @return
     */
    public static long hourDifference(String datetime1, String datetime2) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime localDateTime1 = LocalDateTime.parse(datetime1, formatter);
        LocalDateTime localDateTime2 = LocalDateTime.parse(datetime2, formatter);
        return ChronoUnit.HOURS.between(localDateTime1, localDateTime2);
    }

    public static double hourDifference2(String datetime1, String datetime2) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime localDateTime1 = LocalDateTime.parse(datetime1, formatter);
        LocalDateTime localDateTime2 = LocalDateTime.parse(datetime2, formatter);
        long hour = ChronoUnit.HOURS.between(localDateTime1, localDateTime2);
        long minutes = ChronoUnit.MINUTES.between(localDateTime1, localDateTime2);
        double d = hour + (minutes - hour * 60) / 60.0;
        BigDecimal round = NumberUtil.round(d, 1, RoundingMode.FLOOR);
        return round.doubleValue();
    }
}
