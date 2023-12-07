package map;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * JDK8以后，集合和Map都提供了支持使用lambda表达式的遍历方式
 */
public class foreachDemo {
    public static void main(String[] args) {
        Collection<String> c = new ArrayList<>();
        c.add("one");
        c.add("two");
        c.add("three");
        c.add("four");
        System.out.println(c);
        for(String s: c){
            System.out.println(s);
        }

        // c.forEach(s-> System.out.println(s));
        c.forEach(System.out::println); //方法引用，lambda表达式中要传入的参数和要调用函数的参数一致时，可以使用这种方法引用

        Map<String, Integer> map = new HashMap<>();
        map.put("语文", 88);
        map.put("数学", 77);
        map.put("英语", 66);
        map.put("物理", 87);
        map.forEach((k, v)-> System.out.println(k + ": " + v)); //lambda表达式

    }
}
