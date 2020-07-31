package com.ssh.proxy;

/**
 * 静态代理
 * 特点：代理类和被代理类在编译期间就确定下来了
 */

interface ClothFactory{
    void produceCloth();
}

// 代理类
class ProxyClothFactory implements ClothFactory{
    private ClothFactory factory;

    public ProxyClothFactory(ClothFactory factory) {
        this.factory = factory;
    }

    @Override
    public void produceCloth() {
        System.out.println("代理工厂开始。。。。。");
        factory.produceCloth();
        System.out.println("代理工厂结束。。。。。");
    }
}

//被代理类
class NikeClothFactory implements ClothFactory{
    @Override
    public void produceCloth() {
        System.out.println("Nike工厂。。。。。");
    }
}
public class StaticProxyTest {
    public static void main(String[] args) {
        ProxyClothFactory proxyClothFactory = new ProxyClothFactory(new NikeClothFactory());
        proxyClothFactory.produceCloth();
    }
}
