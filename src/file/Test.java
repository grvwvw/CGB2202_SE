package file;

import java.io.File;
import java.io.FileFilter;

/*
    获取./src/file目录下所有名字以"D"开头的子项
 */
public class Test {
    public static void main(String[] args) {
        File dir = new File("./src/file");
        FileFilter filter = new FileFilter() {
            @Override
            public boolean accept(File file) { //定义过滤规则
//                String regex = "D.*";
//                return file.getName().matches(regex);

                return file.getName().startsWith("D");
            }
        };

        File[] subs = dir.listFiles(filter);
        System.out.println("共" + subs.length + "个以D开头的子项");
        for(File sub: subs){
            System.out.println(sub.getName());
        }
    }
}
