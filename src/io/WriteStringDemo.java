package io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class WriteStringDemo {
    public static void main(String[] args) throws IOException {
        /*
            文件输出流的两种创建方式
            FileOutputStream(String path)
            FileOutputStream(File file)
            以上两种为覆盖模式，创建文件流时如果指定的文件存在，该文件内容会被清除

            FileOutputStream(String path, boolean append)
            FileOutputStream(File file, boolean append)
            如果第二个参数为true则是追加模式，如果指定的文件存在，原来的内容都会保留，新写入的内容会顺序追加到文件中
         */

        //向文件中写入文本数据，默认情况下是覆盖模式，创建文件流时若原文件中有内容，就会把原文件中的内容抹掉
        // FileOutputStream fos = new FileOutputStream("fos.txt");
        FileOutputStream fos = new FileOutputStream("fos.txt", true); // 追加模式

        String line = "昆山玉碎凤凰叫 芙蓉泣露香兰笑";
        /*
            String提供了一个方法: getBytes() 可以将字符串按照指定的字符集转换为
            对应的一组字节。参数指定的就是字符集，用StandardCharsets.UTF_8
         */
        byte[] data = line.getBytes(StandardCharsets.UTF_8);

        fos.write(data);
        System.out.println("输出完毕！");
        fos.close();
    }
}
