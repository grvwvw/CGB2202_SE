package io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/*
    完成一个简易记事本工具
    要求: 程序启动后，将用户在控制台输入的每一行字符串都写入文件note.txt中
    当用户单独输入exit时程序退出
 */
public class NoteDemo {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        FileOutputStream fos = new FileOutputStream("note.txt");

        while(true){
            // 先获取控制台输入的一行字符串
            String line = scanner.nextLine();
            if ("exit".equals(line)) break; //如果用户输入的是exit，那么就退出

            fos.write(line.getBytes(StandardCharsets.UTF_8));
        }

        System.out.println("写入完毕！");
        fos.close();
   }
}
