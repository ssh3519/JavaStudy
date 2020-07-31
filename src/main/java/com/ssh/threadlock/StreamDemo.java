package com.ssh.threadlock;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

@NoArgsConstructor
@AllArgsConstructor
@Data
class User {
    private Integer id;
    private String userName;
    private Integer age;
}

/**
 * 题目：偶数id 且年龄大于24 且用户名转为大写且用户名字母倒排序只输出一个用户名字
 */
public class StreamDemo {
    public static void main(String[] args) {
        User u1 = new User(11, "a", 23);
        User u2 = new User(12, "b", 24);
        User u3 = new User(13, "c", 22);
        User u4 = new User(14, "d", 28);
        User u5 = new User(16, "e", 26);

        List<User> list = Arrays.asList(u1, u2, u3, u4, u5);
        list.stream().filter(user -> {
            return user.getId() % 2 == 0;
        }).filter(user -> {
            return user.getAge() > 24;
        }).map(user -> {
            return user.getUserName().toUpperCase();
        }).sorted((o1, o2) -> {
            return o2.compareTo(o1);
        }).limit(1).forEach(System.out::println);

    }

    /**
     * java内置核心四大函数式接口
     */
    private static void demo() {
        //函数型接口
        Function<String, Integer> function = s -> {
            return s.length();
        };
        System.out.println(function.apply("abc"));
        //断定型接口
        Predicate<String> predicate = s -> {
            return s.isEmpty();
        };
        System.out.println(predicate.test("abc"));
        //消费型接口
        Consumer<String> consumer = s -> {
            System.out.println(s);
        };
        consumer.accept("abc");
        //供给型接口
        Supplier<String> supplier = () -> {
            return "abc";
        };
        System.out.println(supplier.get());
    }
}
