package com.ssh.nio;

import java.nio.ByteBuffer;

/**
 *  0 <= mark <= position <= limit <= capacity
 *  非直接缓冲区：通过allocate方法分配，将缓冲区建立在jvm的内存中
 *  直接缓冲区：通过allocateDirect方法分配，将缓冲区建立在物理内存中，可以提高效率
 */
public class NioDemo {
    public static void main(String[] args) {
//        fzjhcq();
        //分配直接缓冲区
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(1024);
        System.out.println(byteBuffer.isDirect());
    }

    private static void fzjhcq() {
        //1.分配一个指定大小的缓冲区
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        System.out.println("===========allocate===============");
        //缓冲区中正在操作数据的位置
        System.out.println(byteBuffer.position());
        //缓冲区中可以操作的数据大小（limit后面的数据不能进行读写）
        System.out.println(byteBuffer.limit());
        //缓冲区容量，一旦声明，不能改变
        System.out.println(byteBuffer.capacity());
        System.out.println("===========put===============");
        //2.put存数据到缓冲区
        byteBuffer.put("abc".getBytes());
        System.out.println(byteBuffer.position());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.capacity());
        System.out.println("===========flip===============");
        //3.切换读取数据模式
        byteBuffer.flip();
        System.out.println(byteBuffer.position());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.capacity());
        System.out.println("===========get===============");
        //4.get读取缓冲区数据
        byte[] dst = new byte[byteBuffer.limit()];
        byteBuffer.get(dst);
        System.out.println(new String(dst));
        System.out.println(byteBuffer.position());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.capacity());
        System.out.println("===========rewind===============");
        //5.rewind可重复读
        byteBuffer.rewind();
        System.out.println(byteBuffer.position());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.capacity());
        System.out.println("===========clear===============");
        //6.clear清空缓冲区，但是缓冲区的数据依然存在，但是处于“被遗忘”状态
        byteBuffer.clear();
        System.out.println(byteBuffer.position());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.capacity());
        System.out.println((char) byteBuffer.get());

        //mark：标记。记录当前postiion的位置，可以通过reset恢复到mark位置
        byteBuffer.mark();
        byteBuffer.reset();

        //判断缓冲区中是否还有剩余数据
        if (byteBuffer.hasRemaining()) {
            //获取缓冲区中可以操作的数量
            System.out.println(byteBuffer.remaining());;
        }
    }
}
