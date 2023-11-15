package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/*
通过提高每次读写的数据量，减少实际读写的次数，可以提高读写效率。

单字节的读写属于随机读写形式
一组字节的读写属于块读写形式
大多数的硬件块读写都比随机读写的性能好，尤其是机械硬盘上体现最明显

InputStream和OutputStream上定义了块读写数据的相关方法。
 */
public class CopyDemo2 {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("PPT.pptx");
        FileOutputStream fos = new FileOutputStream("PPT_cp.pptx");

        /*
            InputStream中提供了块读操作
            int read(byte[] data)
            一次性读取给定数组总长度的字节量，并存入到数组中，返回值为实际读取到的字节量。
            若返回值为-1则表示读取到了文件的末尾。

            假设：
            PPT.pptx中的内容:
            00001111 11110000 10101010 01010101 11001100 00110011

            byte[] data = new byte[4]; //创建一个长度为4的字节数组
            int len; // 记录每次读取到的字节数

            第一次调用:
            len = fis.read(data);
            从PPT.pptx文件中一次读取4个字节
            PPT.pptx中的内容:
            00001111 11110000 10101010 01010101 11001100 00110011
            ^^^^^^^^ ^^^^^^^^ ^^^^^^^^ ^^^^^^^^

            data:{00001111, 11110000, 10101010, 01010101} //数组存入的是本次读取的数据
            len: 表示本次实际读取了4个字节

            第二次调用:
            len = fis.read(data);
            从PPT.pptx文件中一次读取4个字节
            PPT.pptx中的内容:
            00001111 11110000 10101010 01010101 11001100 00110011 文件末尾
                                                ^^^^^^^^ ^^^^^^^^ ^^^^^^^^ ^^^^^^^^

            data:{11001100, 00110011, 10101010, 01010101} //数组的数据
                  |----本此读取的---|   |----上次读取的---|
            len: 2 表示本次实际读取了2个字节

             第三次调用:
            len = fis.read(data);
            从PPT.pptx文件中一次读取4个字节
            PPT.pptx中的内容:
            00001111 11110000 10101010 01010101 11001100 00110011 文件末尾
                                                                  ^^^^^^^^ ^^^^^^^^ ^^^^^^^^ ^^^^^^^^

            data:{11001100, 00110011, 10101010, 01010101} //数组没有变化
                  |----本此读取的---|   |----上次读取的---|
            len: -1 表示读取到了文件的末尾

         */
        byte[] data = new byte[1024 * 10]; // 10KB
        int len; // 每次读取到的字节数

        long start = System.currentTimeMillis(); // 返回现在时间的ms值

        while((len = fis.read(data)) != -1){
            /*
                OutputStream的块写法:
                void write(byte[] data) //将给定的字节数组中的内容全部写出

                void write(byte[] data, int off, int len); // 将给定字节数组从下标off处开始的连续len个字节一次性写出

             */
            // fos.write(data);
            fos.write(data, 0, len);
        }

        long end = System.currentTimeMillis();
        System.out.println("复制完毕！耗时: " + (end - start) + "ms");
        fis.close();
        fos.close();
    }
}
