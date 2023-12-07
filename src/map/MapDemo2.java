package map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Map的遍历：
 * 1. 遍历所有的Key
 * 2. 遍历所有的Value（不常使用）
 * 3. 遍历每一组键值对
 */
public class MapDemo2 {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("语文", 88);
        map.put("数学", 77);
        map.put("英语", 66);
        map.put("物理", 87);
        System.out.println(map);

        /**
         * Set keySet()
         * 将当前Map中所有的key以一个Set集合形式返回，遍历集合等同于遍历所有的key
         */
        Set<String> keySet = map.keySet();
        for(String key: keySet){
            System.out.println("Key: " + key);
        }

        /**
         * Set entrySet()
         * 将当前Map中的每一组键值对以一个Entry实例形式表示，并存入Set集合返回
         * java.util.Map.Entry的每一个实例用于表示Map中的一组键值对，其中的方法有：
         *
         * Key getKey(): 获取当前的key
         *Value getValue(): 获取对应的value
         */
        Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
        for(Map.Entry<String, Integer> e: entrySet){
            String key = e.getKey();
            Integer value = e.getValue();
            System.out.println(key + ": " + value);
        }

        Collection<Integer> values = map.values();
        for(Integer value: values){
            System.out.println("value: " + value);
        }
    }
}
