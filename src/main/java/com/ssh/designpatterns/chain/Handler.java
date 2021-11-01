package com.ssh.designpatterns.chain;

/**
 * @author ssh
 * @description 抽象处理者角色
 * @date 2021/9/26 14:49
 */
abstract class Handler {
    private Handler next;
    // 用来设置下一个处理者
    public void setNext(Handler next) {
        this.next=next;
    }
    public Handler getNext() {
        return next;
    }
    //处理请求的方法
    public abstract void handleRequest(String request);
}
