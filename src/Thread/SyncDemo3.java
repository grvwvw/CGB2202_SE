package Thread;

/**
 * 静态方法上如果使用synchronized， 那么方法一定是同步的。
 */
public class SyncDemo3 {
    public static void main(String[] args) {
        Boo b1 = new Boo();
        Boo b2 = new Boo();

        Thread t1 = new Thread(){
            @Override
            public void run() {
                b1.dosome();
            }
        };

        Thread t2 = new Thread(){
            @Override
            public void run() {
                b2.dosome();
            }
        };

        t1.start();
        t2.start();
    }
}

class Boo{
    /**
     * 静态方法可以使用类的对象去调用，但是实际上和使用该类名去调用的意义是一样的
     */
    public synchronized static void dosome(){
        try {
            Thread t = Thread.currentThread();
            System.out.println(t.getName() + ":" + "正在执行dosome方法...");
            Thread.sleep(5000);

            System.out.println(t.getName() + ":" + "执行dosome方法完毕...");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
        }
    }
}
