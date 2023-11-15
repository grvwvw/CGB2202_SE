package io;

import java.io.*;

/*
    java将流分为两类:节点流与处理流
    节点流:又称为低级流，是实际连接我们的程序与另一端的"管道”，负责实际读写数据的流
        记住:读写一定是建立在低级济的基础上进行的!
    处理流:又称为高级流，过滤流。不能独立存在，必须连接在其他流上，目的是当数据流经
        它时对数据进行某种加工处理，简化我们的相应操作。

     实际开发中，我们总是串联一组高级流到低级流上，完成一个复杂的数据读写操作，这个过程也称为流的连接，这是I0的精髓

     缓冲流: java.io.BufferedInputStream和BufferedOutputStream

 */
public class CopyDemo3 {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("cat.jpg");
        BufferedInputStream bis = new BufferedInputStream(fis);

        FileOutputStream fos = new FileOutputStream("cat_copy.jpg");
        BufferedOutputStream bos = new BufferedOutputStream(fos);

        long start = System.currentTimeMillis();
        int d;
        while((d = bis.read()) != -1){ // 每次都是读取一个字节，故速度很慢
            bos.write(d);
        }

        long end = System.currentTimeMillis();
        System.out.println("复制完毕！耗时" + (end - start) + "ms");
        bis.close();
        bos.close();
    }
}
