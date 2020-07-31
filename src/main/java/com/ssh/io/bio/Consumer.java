package com.ssh.io.bio;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 * @description 客户端
 * @author: ssh
 * @Date: 2020/7/31 11:15
 */
public class Consumer {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1",8080);
            String message = null;
            Scanner sc = new Scanner(System.in);
            message = sc.next();
            socket.getOutputStream().write(message.getBytes());
            socket.close();
            sc.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
