package io;

/*
    缓冲输出流写出数据的缓冲区问题
 */

import java.io.*;
import java.nio.charset.StandardCharsets;

public class BOS_FlushDemo {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("bos.txt");
        BufferedOutputStream bos = new BufferedOutputStream(fos);

        String line = "This is a line";
        byte[] data = line.getBytes(StandardCharsets.UTF_8);
        bos.write(data);

        System.out.println("写出完毕！");

        /*
            缓冲流的flush方法用于强制将缓冲区中已经缓存的数据一次性写出
            注：该方法实际上是在直接输出流的超类OutputStream上定义的，并非只有缓冲输出流这个方法。
            但是实际上只有缓冲输出流的该方法具有实际意义，其他的流实现该方法的目的仅仅是为了在连接流的过程中传递flush动作给缓冲输出流
         */

        // bos.flush(); //冲

        bos.close();//close()方法中包含的又flush()
    }
}
