package file;
import java.io.File;

/*
java.io.file
File可以表示硬盘上的文件或目录（实际表示的是一个抽象的路径）
File可以:
    1.访问其表示的文件或者目录的属性信息
    2.可以创建或者删除文件和目录
    3.可以访问一个目录中的子项内容
File不能访问文件数据
 */
public class FileDemo {
    /*
    在开发中不会使用绝对路径，不利于跨平台。

    相对路径有更好的跨平台性，但是具体位置要根据程序运行环境而定。
    例如:
        "./": 表示当前目录，对于IDEA而言，当前目录表示的是程序所在项目的目录。
     */
    public static void main(String[] args){
        File file = new File("./demo.txt");

        //获取File表示的文件或者目录的名字
        String name = file.getName();
        System.out.println(name);

        //获取长度，返回的是long类型的，单位是字节
        long length = file.length();
        System.out.println("大小:" + length + "字节");

        // 判断可读或者可写，返回的是boolean类型
        boolean cw = file.canWrite();
        boolean cr = file.canRead();

        //判断是否为隐藏文件
        boolean ih = file.isHidden();
    }
}
