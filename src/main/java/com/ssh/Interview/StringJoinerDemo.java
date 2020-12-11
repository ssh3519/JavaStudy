package com.ssh.Interview;

import cn.hutool.core.date.DateUtil;
import com.google.common.base.Preconditions;

import java.util.ArrayList;
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
        String tempStr = "01";
        String result = String.valueOf(Integer.parseInt(tempStr));
        System.out.println(result);
    }
}
