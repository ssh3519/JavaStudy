package com.ssh.designpatterns.chain;

/**
 * @author ssh
 * @description
 * 责任链模式的定义：使多个对象都有机会处理请求，从而避免请求的发送者和接受者之间的耦合关系，将这个对象连成一条链，
 * 并沿着这条链传递该请求，直到有一个对象处理他为止。
 *
 * 标准的责任链模式，个人总结下来有如下几个特点：
 *
 * 链上的每个对象都有机会处理请求
 * 链上的每个对象都持有下一个要处理对象的引用
 * 链上的某个对象无法处理当前请求，那么它会把相同的请求传给下一个对象
 * @date 2021/9/26 14:51
 */
public class ChainOfResponsibilityPattern {
    public static void main(String[] args) {
        //组装责任链
        Handler handler1 = new ConcreteHandler1();
        Handler handler2 = new ConcreteHandler2();
        handler1.setNext(handler2);
        //提交请求
        handler1.handleRequest("two");
    }
}
