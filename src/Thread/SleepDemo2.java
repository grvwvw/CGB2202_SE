package Thread;

/**
 * 当一个线程调用sleep方法处于睡眠阻塞过程中，器interrupt()方法被调用，那么这时会中断该睡眠阻塞，并且sleep方法会抛出异常
 */
public class SleepDemo2 {
    public static void main(String[] args) {
        Thread lin = new Thread(){
            @Override
            public void run() {
                System.out.println("林: 刚美完容，睡一会吧~");
                try {
                    Thread.sleep(5000000);
                } catch (InterruptedException e) {
                    System.out.println("林：干嘛呢？干嘛呢？干么呢？");
                }

                System.out.println("林: 醒了！");
            }
        };

        Thread huang = new Thread(){
            @Override
            public void run() {
                System.out.println("黄: 大锤80，小锤40，开始砸墙！");
                for(int i = 0; i < 5; i++){
                    System.out.println("黄: 80!");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                    }
                }

                System.out.println("咣当！");
                System.out.println("黄: 搞定！");
                lin.interrupt(); //中断lin线程
            }
        };

        lin.start();
        huang.start();
    }
}
