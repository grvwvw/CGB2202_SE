package Thread;

/**
 * 当多个线程并发操作同一临界资源，由于线程切换时机不确定，导致操作顺序出现了混乱，产生不正常后果。
 *
 * 临界资源:操作该资源的完整过程同一时刻只能有单个线程进行的
 */
public class SyncDemo1 {
    public static void main(String[] args) {
        Table table = new Table();

        Thread t1 = new Thread(){
            @Override
            public void run() {
                while(true){
                    int bean = table.getBeans();
                    Thread.yield();
                    System.out.println(getName() + ":" + bean);
                }
            }
        };

        Thread t2 = new Thread(){
            @Override
            public void run() {
                while(true){
                    int bean = table.getBeans();
                    Thread.yield();
                    System.out.println(getName() + ":" + bean);
                }
            }
        };

        t1.start();
        t2.start();
    }
}

class Table{
    private int beans = 20; //设桌子上有20个豆子

    public synchronized int getBeans(){ //synchronized关键字可以限制使多个线程不能同时在一个方法内进行
        if(beans == 0)
            throw new RuntimeException("桌子上没有豆子啦！");
        Thread.yield(); //让线程主动放弃本次时间片，用来模拟执行到这里时CPU没有时间

        return beans--;
    }
}
