package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/*
使用文件输入读取文件数据
 */
public class FISDemo {
    public static void main(String[] args) throws IOException {
        //将fos.dat文件中的数据读取回来
        FileInputStream fis = new FileInputStream("./fos.dat");
        /*
        int read()
        读取一个字节，并以int类型返回，返回的int值对应的是2进制的低八位为读取到的字节数据。
        如果返回值为int的-1，则表示读取到流的末端

        int d = fis.read();
        当读取到文件末尾时，返回值为int类型的-1，d的2进制样子:
        11111111 11111111 11111111 11111111
        特殊值表示文件末尾！

        int d = fis.read();
        d的2进制样子：
        00000000 00000000 00000000 00000001
        |--------补24个0---------|  读取到的字节
         */
        int d = fis.read();
        System.out.println(d);

        d = fis.read();
        System.out.println(d); //输出-1
    }
}
