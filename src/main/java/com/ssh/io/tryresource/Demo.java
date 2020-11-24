package com.ssh.io.tryresource;

import java.io.*;

/**
 * @description  try(resource)
 * @author: ssh
 * @Date: 2020/10/16 13:57
 */
public class Demo {
    public static void main(String[] args) throws IOException {
        try (InputStream in = new BufferedInputStream(new FileInputStream("src/readme.txt"))) {
            byte[] buffer = new byte[1024];
            while (in.read(buffer) != -1) {
                System.out.println(new String(buffer));
            }
        }
    }
}
