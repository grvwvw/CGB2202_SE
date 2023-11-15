package io;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

/*
    缓冲字符流
    java.io.BufferedWriter和BufferedReader
    缓冲字符流是一对高级的字符流，作用是块写文本数据加速的

    java.io.Printer具有直动行刷新的缓冲字符输出流，内部连接的是BufferedWriter
    更常用
 */
public class PWDemo1 {
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        //向pw.txt文件中写入文本数据
        /*
            对文件进行构造的构造器
            Printer pw = new PrinterWriter(String path)
            Printer pw = new PrinterWriter(File file)

         */
        PrintWriter pw = new PrintWriter("pw.txt", "utf-8");
        pw.println("你好啊");
        pw.println("大傻吊");
        System.out.println("写出完毕！");
        pw.close();
    }
}
