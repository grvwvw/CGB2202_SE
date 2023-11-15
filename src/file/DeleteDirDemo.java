package file;

import java.io.File;

/*
    delete
    删除一个目录
 */
public class DeleteDirDemo {
    public static void main(String[] args) {
        //删除当前目录下的Demo目录
        File dir = new File("./a");

        if(dir.exists()){
            //dir.delete(); //delete()方法中只能删除空目录，目录中不能有内容

            System.out.println("该目录已删除！");
        }else{
            System.out.println("该目录不存在！");
        }
    }
}
