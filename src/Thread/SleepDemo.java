package Thread;

import java.util.Scanner;

/**
 * sleep阻塞
 * 线程提供了一个静态方法sleep，可以使运行该方法的线程阻塞指定毫秒。超时后线程会自动回到Runnable状态继续并发执行
 */
public class SleepDemo {
    public static void main(String[] args) {
        System.out.println("程序开始了...");
        Scanner scanner = new Scanner(System.in);

        int x = scanner.nextInt();
        for(int i = x; i > 0; i--)
        {
            System.out.println(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        /**
         *         try {
         *             Thread.sleep(5000);
         *         } catch (InterruptedException e) {
         *             throw new RuntimeException(e);
         *         }
         */

        System.out.println("程序结束啦...");
    }
}
