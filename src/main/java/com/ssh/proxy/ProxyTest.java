package com.ssh.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理
 */

interface Human{
    String getBelef();
    void eat(String food);
}

//被代理类
class SuperMan implements Human{
    @Override
    public String getBelef() {
        return "I believe I can fly";
    }

    @Override
    public void eat(String food) {
        System.out.println("我喜欢吃"+ food);
    }
}

class ProxyFactory{
    // 调用此方法，返回一个代理类的对象
    public static Object getProxyInstance(Object obj){      //    obj:被代理的对象
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("动态代理前。。。。。。。。。。");
                Object returnValue = method.invoke(obj, args);
                System.out.println("动态代理后。。。。。。。。。。");
                return returnValue;
            }
        });
    }
}
public class ProxyTest {

    public static void main(String[] args) {
        Human proxyInstance = (Human) ProxyFactory.getProxyInstance(new SuperMan());
        System.out.println(proxyInstance.getBelef());
        proxyInstance.eat("xx");
        System.out.println("-------------------------------------------");
        ClothFactory clothFactory = (ClothFactory) ProxyFactory.getProxyInstance(new NikeClothFactory());
        clothFactory.produceCloth();
    }
}
