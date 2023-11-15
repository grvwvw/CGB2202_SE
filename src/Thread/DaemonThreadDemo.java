package Thread;

/**
 * 守护线程
 * 守护线程是通过普通线程调用方法setDaemon(true)设置而来的。
 * 守护线程和普通线程的区别体现在一个结束时机上的不同:当进程结束时，进程会强制杀死所有正在运行的守护线程并最终停止
 *
 * 进程的结束:
 * 当java进程中所有的普通线程都结束时，进程就会结束
 */
public class DaemonThreadDemo {
    public static void main(String[] args) {
        Thread rose = new Thread(){
            @Override
            public void run() {
                for(int i = 0; i < 5; i++){
                    System.out.println("rose: let me go!");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                    }
                }

                System.out.println("rose: AAAAAAAAaaaaa...");
                System.out.println("噗通！");
            }
        };

        Thread jack = new Thread(){
            @Override
            public void run() {
                while(true){
                    System.out.println("jack: you jump, I jump!");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                    }
                }
            }
        };

        rose.start();

        jack.setDaemon(true); //设置为Daemon线程，必须在线程start()之前设置
        jack.start();

        /**
         *  设置一条while(true);语句卡死主线程
         *  main()作为一条普通线程不执行结束，那么守护线程也不会结束执行
         *  证明:
         *  1. Daemon线程并不是为了守护某一个单独的线程而设定的，而是需要等到所有的普通线程执行结束才会被kill
         *  2. java程序结束的标志: 程序中的普通线程全都执行完成，程序就会结束
         */
        // while(true);
        System.out.println("主线程执行完毕！"); //主线程是最先执行结束的！
    }
}
