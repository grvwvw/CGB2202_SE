package io;

import java.io.FileOutputStream;
import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("test.txt");
        fos.write(97 - '0');
//        for(int i = 'a'; i <= 'z'; i++)
//            fos.write(i);

        System.out.println("输出完毕！");
        fos.close();
    }
}
