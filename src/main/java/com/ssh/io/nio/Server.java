package com.ssh.io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * @description
 * @author: ssh
 * @Date: 2020/7/31 11:47
 */
//等待连接时和等待数据时不阻塞）
//public class Server {
//    public static void main(String[] args) throws InterruptedException {
//        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
//        try {
//            //Java为非阻塞设置的类
//            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
//            serverSocketChannel.bind(new InetSocketAddress(8080));
//            //设置为非阻塞
//            serverSocketChannel.configureBlocking(false);
//            while (true){
//                SocketChannel socketChannel = serverSocketChannel.accept();
//                if(socketChannel==null) {
//                    //表示没人连接
//                    System.out.println("正在等待客户端请求连接...");
//                    Thread.sleep(5000);
//                }else {
//                    System.out.println("当前接收到客户端请求连接...");
//                }
//                if (socketChannel!=null){
//                    //设置为非阻塞
//                    socketChannel.configureBlocking(false);
//                    byteBuffer.flip();//切换模式 写-->读
//                    int effective = socketChannel.read(byteBuffer);
//                    if (effective!=0){
//                        String content = Charset.forName("utf-8").decode(byteBuffer).toString();
//                        System.out.println(content);
//                    }else {
//                        System.out.println("当前未收到客户端消息");
//                    }
//                }
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//}
//（缓存Socket，轮询数据是否准备好）
public class Server {
    public static void main(String[] args) throws InterruptedException {
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        List<SocketChannel> socketList = new ArrayList<SocketChannel>();

        try {
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.bind(new InetSocketAddress(8080));
            //设置为非阻塞
            serverSocketChannel.configureBlocking(false);
            while(true) {
                SocketChannel socketChannel = serverSocketChannel.accept();
                if (socketChannel == null) {
                    //表示没人连接
                    System.out.println("正在等待客户端请求连接...");
                    Thread.sleep(5000);
                } else {
                    System.out.println("当前接收到客户端请求连接...");
                    socketList.add(socketChannel);
                }
                for (SocketChannel socket : socketList) {
                    socket.configureBlocking(false);
                    int effective  = socket.read(byteBuffer);
                    if (effective!=0){
                        byteBuffer.flip();//切换模式  写-->读
                        String content = Charset.forName("UTF-8").decode(byteBuffer).toString();
                        System.out.println("接收到消息:"+content);
                        byteBuffer.clear();
                    }else {
                        System.out.println("当前未收到客户端消息");
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
