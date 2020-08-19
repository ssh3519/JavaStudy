package com.ssh.factory;

import java.math.BigDecimal;

/**
 * @description 静态工厂
 * @author: ssh
 * @Date: 2020/8/18 10:07
 */
public class StaticFactory {
    //StaticFactory.getBook
    public static Book getBook(String name){
        Book book = new Book();
        book.setName(name);
        book.setPrice(new BigDecimal("10"));
        return book;
    }
}
