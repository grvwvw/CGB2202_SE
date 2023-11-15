package lambda;
import java.io.File;
import java.io.FileFilter;

/*
JDK8以后Java推出了一个特性: lambda表达式
lambda可以是程序员面向函数式编程

可以用更精简的语法创建匿名函数类
但是lambda创建匿名内部类是要求所实现的接口中只能有一种抽象方法

语法：
    (参数列表)->{
        方法体
    }
 */

public class LambdaDemo {
    public static void main(String[] args) {
        //1. lambda表达式的写法，就是省去了接口名和方法名
        FileFilter filter = (File file) ->{
          return file.getName().contains("o");
        };

        //2. 参数类型可以忽略不写，若参数列表中只有一个，那参数列表的"()"也可以不写
        FileFilter filter1 = file ->{
            return file.getName().contains("o");
        };

        //3.当方法体中只有一行语句时，方法体中的"{}"可以忽略，并且"return"也要忽略
        FileFilter filter3 = file -> file.getName().contains("o");
    }
}
