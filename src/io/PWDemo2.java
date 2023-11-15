package io;

import java.io.*;
import java.nio.charset.StandardCharsets;

/*
自行流连接创建PrinterWriter
 */
public class PWDemo2 {
    public static void main(String[] args) throws FileNotFoundException {
        /*
            使用默认构造方式时，不支持追加写入文件

            若想要追加写入文件，需要这种四层的创建模式，在fos文件中设置参数
         */
        FileOutputStream fos = new FileOutputStream("pw2.txt", true);
        OutputStreamWriter osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8); //字符转字节
        BufferedWriter bw = new BufferedWriter(osw); // 加速块读写
        PrintWriter pw = new PrintWriter(bw);

        pw.println("");
        pw.close();
    }
}
