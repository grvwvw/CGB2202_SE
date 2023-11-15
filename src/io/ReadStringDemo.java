package io;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class ReadStringDemo {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("fos.txt");

        byte[] data = new byte[1024 * 10]; // 10KB
        int len = fis.read(data); //返回的是读取的字节数
        System.out.println("实际读取的字节数: " + len);

        String line = new String(data, 0, len, StandardCharsets.UTF_8);
        System.out.println(line.length()); // 转码之后的长度
        System.out.println(line);

        fis.close();
    }
}
