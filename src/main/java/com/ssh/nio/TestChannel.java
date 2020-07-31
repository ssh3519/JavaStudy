package com.ssh.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class TestChannel {

    public static void main(String[] args) throws Exception{
        //1.利用通道完成文件的复制（非直接缓冲区）
//        fzjhcq();
        //2.利用内存映射文件（直接缓冲区）
//        zjhcq();
        //通道之间传输
//        zjhcq2();
        //分散读取，聚集写入

    }

    private static void zjhcq2() throws IOException {
        FileChannel inChannel = null;
        FileChannel outChannel = null;
        inChannel = FileChannel.open(Paths.get("C:\\Users\\Administrator\\Pictures\\1.jpg"), StandardOpenOption.READ);
        outChannel = FileChannel.open(Paths.get("C:\\Users\\Administrator\\Pictures\\3.jpg"), StandardOpenOption.WRITE,StandardOpenOption.READ,StandardOpenOption.CREATE_NEW);
//        inChannel.transferTo(0,inChannel.size(),outChannel);
        outChannel.transferFrom(inChannel,0,inChannel.size());
        inChannel.close();
        outChannel.close();
    }

    private static void zjhcq() {
        FileChannel inChannel = null;
        FileChannel outChannel = null;
        try {
            inChannel = FileChannel.open(Paths.get("C:\\Users\\Administrator\\Pictures\\1.jpg"), StandardOpenOption.READ);
            outChannel = FileChannel.open(Paths.get("C:\\Users\\Administrator\\Pictures\\3.jpg"), StandardOpenOption.WRITE,StandardOpenOption.READ,StandardOpenOption.CREATE_NEW);


            //内存映射文件
            MappedByteBuffer inMappedBuf = inChannel.map(FileChannel.MapMode.READ_ONLY, 0, inChannel.size());
            MappedByteBuffer outMappedBuf = outChannel.map(FileChannel.MapMode.READ_WRITE, 0, inChannel.size());

            byte[] dst = new byte[inMappedBuf.limit()];
            inMappedBuf.get(dst);
            outMappedBuf.put(dst);



        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inChannel!=null){
                try {
                    inChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (outChannel!=null){
                try {
                    outChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void fzjhcq() {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        FileChannel fisChannel = null;
        FileChannel fosChannel = null;
        try {
            fis = new FileInputStream("C:\\Users\\Administrator\\Pictures\\1.jpg");
            fos = new FileOutputStream("C:\\Users\\Administrator\\Pictures\\3.jpg");

            //获取通道
            fisChannel = fis.getChannel();
            fosChannel = fos.getChannel();

            //分配缓冲区
            ByteBuffer buffer = ByteBuffer.allocate(1024);

            //将通道数据存入缓冲区
            while (fisChannel.read(buffer)!=-1){
                buffer.flip();//切换读取数据模式
                fosChannel.write(buffer);//将缓冲区数据写入通道
                buffer.clear();//清空缓冲区
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fosChannel!=null){
                try {
                    fosChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fisChannel!=null){
                try {
                    fisChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fos!=null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fis!=null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
