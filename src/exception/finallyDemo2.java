package exception;

import java.io.FileOutputStream;
import java.io.IOException;

public class finallyDemo2 {
    public static void main(String[] args) {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("fos.bat");
            fos.write(1);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if(fos != null){ //防止打开的路径错误，null指针是无法调用close()方法的
                    fos.close();  // 保证最后fos可以关掉
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
