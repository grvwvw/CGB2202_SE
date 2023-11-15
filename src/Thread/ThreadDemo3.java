package Thread;

/*
    使用匿名内部类的方式实现两种形式线程的创建
 */
public class ThreadDemo3 {
    public static void main(String[] args) {
        //1. 第一种: 继承Thread重写run()方法
        Thread t1 = new Thread(){
            @Override
            public void run() {
                for(int i = 0; i < 1000; i++){
                    System.out.println("你是谁？");
                }
            }
        };

        //2. 第二种: 实现Runnable接口单独定义线程任务的形式
        Thread t2 = new Thread(){
            @Override
            public void run() {
                for(int i = 0; i < 1000; i++){
                    System.out.println("我是恁爹！");
                }
            }
        };

        /*
            调用线程
            启动线程使用的是start()方法，不能直接调用run()方法
            start()方法调用后线程会被纳入到线程调度器中统一管理，当它第一次获取调度器分配的CPU时间片后就会开始执行run()方法。
         */
        t1.start();
        t2.start();
    }
}
