package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyDemo {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("cat.jpg");
        FileOutputStream fos = new FileOutputStream("cat_copy.jpg");

        int d;
        while((d = fis.read()) != -1){ // 每次都是读取一个字节，故速度很慢
            fos.write(d);
        }
        System.out.println("复制完毕！");
        fis.close(); fos.close();
    }
}
