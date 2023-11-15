package Thread;

/**
 * 线程的优先级
 * 线程有10个优先级分别对应整数1-1，其11是最低的，10是最高的，5是默认值。
 * 当一个线程调用start方法后，线程便纳入到了线程调度器中统一管理，线程只能被动的被分配
 * 时间片并发执行而不能主动获取时间片。调变器会尽可能均匀的分配时间片给每个线程。
 * 调整线程的优先级可以最大程度的改善一个程获取时间片的机率。线程优先级越高的线程获取时间片的次数越多
 */
public class PriorityDemo {
    public static void main(String[] args) {
        Thread min = new Thread(){
            @Override
            public void run() {
                for(int i = 0; i < 10000; i++)
                    System.out.println("min");
            }
        };

        Thread norm = new Thread(){
            @Override
            public void run() {
                for(int i = 0; i < 10000; i++)
                    System.out.println("norm");
            }
        };

        Thread max = new Thread(){
            @Override
            public void run() {
                for(int i = 0; i < 10000; i++)
                    System.out.println("max");
            }
        };

        min.setPriority(Thread.MIN_PRIORITY);
        max.setPriority(Thread.MAX_PRIORITY);

        min.start();
        norm.start();
        max.start();
    }
}
