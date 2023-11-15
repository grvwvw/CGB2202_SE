package file;
import java.io.File;

/*
    directory: 目录
    使用File创建一个目录
 */
public class MkDirDemo {
    public static void main(String[] args) {
        //在当前目录下创建一个目录：Demo
        //File dir = new File("Demo");
        File dir = new File("a/Demo");


        if(dir.exists()){
            System.out.println("该目录已存在！");
        }else{
            //dir.mkdir(); // 创建目录时所要求的上级目录必须存在，否则创建失败
            dir.mkdirs(); //可以创建多重目录，开发中一般都会采用mkdirs()方法
            System.out.println("该目录已创建！");
        }
    }
}
