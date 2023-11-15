package exception;

import java.io.FileOutputStream;
import java.io.IOException;

/*
JDK7之后引入了自动关闭
 */
public class AutoClosableDemo {
    public static void main(String[] args) {
        try(FileOutputStream fos = new FileOutputStream("fos.bat");)
        {
            fos.write(1); // 不需要再写finally语句，会自动关闭fos
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
