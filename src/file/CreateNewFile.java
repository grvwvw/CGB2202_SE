package file;

import java.io.File;
import java.io.IOException;

/*
 create: 创建
 使用File创建一个文件
 */
public class CreateNewFile {
    public static void main(String[] args) throws IOException {
        /*
        前提条件是，创建的那个目录必须存在，否则无法创建

        创建文件的前提是该文件所在的目录必须存在，如果目录不存在则创建时会抛出异常:
        java.io.IOException: 系统找不到指定的路径
         */
        File file = new File("./test.txt");

        //exist判断是否存在，返回boolean类型
        if(file.exists()){
            //存在
            System.out.println("该文件已存在！");
        }else{
            file.createNewFile();
        }
    }
}
