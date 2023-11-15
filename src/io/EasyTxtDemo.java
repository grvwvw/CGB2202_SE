package io;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class EasyTxtDemo {
    public static void main(String[] args) throws FileNotFoundException {
        FileOutputStream fos = new FileOutputStream("demo.txt");
        OutputStreamWriter osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8);
        BufferedWriter bw = new BufferedWriter(osw);
        PrintWriter pw = new PrintWriter(bw, true); //第二个参数实现自动行刷新，每输入一行就刷新一次

        Scanner scanner = new Scanner(System.in);
        while(true){
            String line = scanner.nextLine();
            if("exit".equalsIgnoreCase(line)) break; //equalsIgnoreCase() 忽略大小写，但是密码比较不能使用该方法
            else{
                pw.println(line);
            }
        }
        pw.close();
    }
}
