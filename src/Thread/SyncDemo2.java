package Thread;

/**
 * 同步执行: 多个线程执行有先后顺序
 */
public class SyncDemo2 {
    public static void main(String[] args) {
        Shop shop = new Shop();

        Thread t1 = new Thread(){
            @Override
            public void run() {
                shop.buy();
            }
        };

        Thread t2 = new Thread(){
            @Override
            public void run() {
                shop.buy();
            }
        };

        t1.start();
        t2.start();
    }
}

class Shop{
    /**
     * public synchronized void buy()
     * 在方法上使用synchronized时，同步监视器对象就是当前方法的所属对象，即: this
     */
    public void buy(){
        try {
            Thread t = Thread.currentThread(); //获取运行的buy线程
            System.out.println(t.getName() + ":正在挑选衣服...");
            Thread.sleep(5000);

            /**
             * 同步块使用时需要指定一个同步监视器对象，即:上锁的对象该对象从语法的角度来讲可以是任意引用类型的实例。
             * 但是必须同时满足多个需要同步(排队)执行该代码片段的线程看到的是同一个对象才可以!
             *
             * 把下面的this换成new Object()是不行的
             */

            synchronized (this){ //同步块，只让某一部分在并发时排队执行
                System.out.println(t.getName() + ":正在试衣服..."); //让线程顺序执行试衣服的动作
                Thread.sleep(5000);
            }

            System.out.println(t.getName() + ":结账离开...");
        } catch (InterruptedException e) {
        }
    }
}