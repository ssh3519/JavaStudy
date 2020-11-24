package com.ssh.Interview;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.atomic.LongAdder;

/**
 * @description
 * @author: ssh
 * @Date: 2020/10/17 11:44
 */
public class Huo {
    public static void main(String[] args) {
        Boolean a = false;
        Boolean b = false;
        if (a || b){
            System.out.println("haha");
        }

        String format = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalDate parse = LocalDate.parse(format, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        System.out.println(parse);
        LongAdder longAdder = new LongAdder();
        longAdder.add(3L);
        System.out.println(longAdder.longValue());
    }
}
