package Thread;

/*
    多线程
    线程是一个程序的单一顺序执行流程。多个单一流程一起运行就是多线程
    多线程是并发执行的.

    创建线程有两种方式，第一种:继承Thread并重写run方法
 */
public class ThreadDemo1 {
    public static void main(String[] args) {
        //1. 创建线程的实例
        Thread t1 = new MyThread1();
        Thread t2 = new MyThread2();

        //2. 调用线程的start()方法
        t1.start();
        t2.start();
    }
}

/*
    第一种创建方式的优点，利于匿名内部类创建

    缺点：
    1. 由于java是单继承的，这导致如果继承Thread就无法再继承其他类啦
    2. 在定义线程时，定义了线程任务，导致线程和任务存在了必然的耦合关系，不利于线程的重用
 */

class MyThread1 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++){
            System.out.println("你是谁？");
        }
    }
}

class MyThread2 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++){
            System.out.println("我是恁爹！");
        }
    }
}


