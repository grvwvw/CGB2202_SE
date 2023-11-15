package io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/*
Java IO Java的输入与输出
java使用输入和输出的两个方向来规定读和写操作
其中输入是从外界到我们的程序方向是获取过程，是[读取]操作
输出是指发送到外界的方向，是[写出]操作

java.io.InputStream和OutputStream是所有字节输入流和输出流的超类，它们是抽象类。
InputStream定义了读取字节的相关方法。OutputStream定义了写出字节的相关方法。
实习开发过程中我们可以创建不同种类的输入和输出流来连接对应的设备进行独写操作

文件流
java.io.FileInputStream和FileOutputStream。它们继承自InputStream和OutputStream
OutputStream是实际用于读写文件的流。
 */
public class FOSDemo {
    public static void main(String[] args) throws IOException {
        //向文件fos.dat中写一个字节
        /*
            文件流输出常用构造方法：
            FileOutputStream(String path)
            FileOutputStream(File file)
         */
        FileOutputStream fos = new FileOutputStream("./fos.dat");

        /*
        void write(int d)
        写出一个字节，写出的内容是给定的int值对应的2进制的"低八位"

        fos.write(1);
        int型整数1的2进制
                                   vvvvvvvv
        00000000 00000000 00000000 00000001

        fos.dat文件中的内容为00000001
         */

        fos.write(1);
        System.out.println("写出完毕！");
        fos.close(); // 必须关闭写出流
    }
}
