package com.ssh.threadlock;

@FunctionalInterface
interface Foo
{
//    public void sayHello();
    public int add(int x,int y);
    default int div(int x,int y)
    {
        return x/y;
    }

    default int div2(int x,int y)
    {
        return x/y;
    }

    public static int mv(int x,int y)
    {
        return x*y;
    }
}

/**
 * lambda表达式接口中只能有一个方法
 * 拷贝小括号，写死右箭头，落地大括号
 * @FunctionalInterface
 *  default
 *  静态方法实现
 */
public class LambdaExpressDemo {
    public static void main(String[] args) {
        /*Foo foo = new Foo() {
            @Override
            public void sayHello() {
                System.out.println("hello");
            }
        };
        foo.sayHello();*/
        /*Foo foo = () -> {System.out.println("hello lambda express");};
        foo.sayHello();*/

        Foo foo = (x,y) -> {
            System.out.println("come in here");
            return x+y;
        };
        System.out.println(foo.add(1,2));
        System.out.println(foo.div(3,2));
        System.out.println(Foo.mv(2,4));
    }
}
