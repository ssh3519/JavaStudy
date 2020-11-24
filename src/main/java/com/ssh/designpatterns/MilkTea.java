package com.ssh.designpatterns;

import lombok.NonNull;

/**
 * @description 原型模式
 * @author: ssh
 * @Date: 2020/10/16 10:41
 */
public class MilkTea implements Cloneable{
    public String type;
    public boolean ice;

    @NonNull
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
