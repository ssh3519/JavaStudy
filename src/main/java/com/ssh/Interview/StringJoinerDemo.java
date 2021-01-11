package com.ssh.Interview;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.NumberUtil;
import com.google.common.base.Preconditions;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.StringJoiner;

/**
 * @author ssh
 * @description
 * @date 2020/11/27 16:06
 */
public class StringJoinerDemo {
    public static void main(String[] args) {
        //StringJoiner stringJoiner = new StringJoiner(",", "[", "]");
        //stringJoiner.add("a").add("b").add("c");
        //System.out.println(stringJoiner.toString());
        //List<String> list = new ArrayList<>();
        //long count = list.stream().filter(item -> item.equals("aaa")).count();
        //System.out.println(count);
        //int day = DateUtil.dayOfMonth(DateUtil.parse("2020-11"));
        //System.out.println(day);
        //List<String> list = null;
        //Preconditions.checkArgument(list != null,"暂无考勤组");
        //String format = String.format("%02d", 1);
        //System.out.println(format);
        //String tempStr = "01";
        //String result = String.valueOf(Integer.parseInt(tempStr));
        //System.out.println(result);

        //int week = DateUtil.dayOfWeek(new Date());
        //System.out.println(week);
        //String s = NumberUtil.add("1", "1.5").toString();
        //System.out.println(s);
        List<Integer> aList = new ArrayList();
        List<String> bList = new ArrayList();

        System.out.println(aList.getClass() == bList.getClass());
        Integer integer = 66; // 自动拆箱

        int i1 = integer;   // 自动装箱

    }
}
