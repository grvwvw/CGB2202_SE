package Thread;

/*
    java中所有的代码都是靠线程运行，main方法也不例外
    java程序跑起来之后，JVM创建一条线程来执行main方法，这个线程的名字也叫"main"，我们称呼为主线程
 */
public class CurrentThreadDemo {
    public static void main(String[] args) {
        Thread main = Thread.currentThread(); //返回当前正在执行的线程
        System.out.println("主线程" + main);

        dosome();
    }

    public static void dosome(){
        Thread t = Thread.currentThread();
        System.out.println("执行dosome方法的线程是: " + t);
    }
}
