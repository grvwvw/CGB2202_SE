package Thread;

public class ThreadInfoDemo {
    public static void main(String[] args) {
        Thread main = Thread.currentThread(); //获取当前线程进行查看

        String name = main.getName();
        System.out.println(name);

        long id = main.getId();
        System.out.println(id);

        // priority: 优先级
        int priority = main.getPriority(); // 获取线程的优先级
        System.out.println(priority);
    }
}
