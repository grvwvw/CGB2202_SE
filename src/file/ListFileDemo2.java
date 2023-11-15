package file;

import java.io.File;
import java.io.FileFilter;

/*
有条件的获取一个目录中的子项
File有一个重载的listFile方法，允许我们传入一个文件过滤器，并在该过滤器上定义过滤条件，之后listFile
执行完毕会将目录中满足条件的子项返回
 */
public class ListFileDemo2 {
    public static void main(String[] args) {
        //获取当前目录中名字中含"o"的子项
        File dir = new File(".");
        if(dir.isDirectory()){
            //File listFiles(FileFilter filter)

            FileFilter filter = new FileFilter() { //匿名内部类的写法写过滤器
                @Override
                public boolean accept(File file) {
                    System.out.println("正在过滤：" + file.getName());
                    return file.getName().contains("o");
                }
            };
            File[] subs = dir.listFiles(filter);
            System.out.println("共：" + subs.length + "个子项");
            for(int i = 0; i < subs.length; i++){
                File sub = subs[i];
                System.out.println(sub.getName());
            }
        }

    }
}

//由于该重载类只会被调用一次，一般不会这样写，一般都是使用匿名内部类的写法实现
class MyFilter implements FileFilter{

    @Override
    public boolean accept(File file) {
        //过滤条件是含有字母"o"的
        String name = file.getName();

        //1. 使用正则表达式匹配
        String regex = ".*o.*"; //.表示任意字符  *表示任意多个
        boolean match = name.matches(regex);

        //2. indexOf()索引查找
        // name.indexOf("0") > 0

        //3. 使用String.contains() 方法
        // name.contains("o");

        return name.contains("o");
    }
}
