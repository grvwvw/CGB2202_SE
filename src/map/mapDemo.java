package map;

import java.util.HashMap;
import java.util.Map;

/**
 * java.util.Map接口
 * Map称为查找表，体现的结构是一个多行两列的表格，其中左列成为key，右列称为value
 * Map总是根据key来获取对应的value
 *
 * 常用实现类：
 * java.util.HashMap: 成为散列表，哈希表。是使用散列算法实现的Map，当今查询速度最快的数据结构，不受空间复杂度的影响
 *
 * java.util.TreeMap: 使用二叉树算法实现的Map
 */
public class mapDemo {
    public static void main(String[] args) {
        /*
            Map的Key和Value可以分别指定不同的类型
            Map要求key不重复
            如果put方法存入的键值对中，key不存在时，则直接将key-value存入，返回值为null
            如果key存在，则是替换value，此时返回值为被替换的value
         */

        Map<String, Integer> map = new HashMap<>();

        Integer value = map.put("语文", 98);
        System.out.println(value); //没有被替换的value，返回的是null
        map.put("数学", 98);
        map.put("英语", 98);
        map.put("物理", 98);
        System.out.println(map);

        value = map.put("物理", 60); //此时的map中有原本的key，因此会返回开始时的value返回
        System.out.println(map);
        System.out.println(value);

        /*
            get(Object Key)
            根据对应的Key获取对应的value，如果key不存在，返回为null
         */
        value = map.get("化学");
        System.out.println(value);
        value = map.get("物理");
        System.out.println(value);

        /*
            size() 返回当前map中的元素个数
         */
        int size = map.size();
        System.out.println(size);

        /*
            可以判断Map是否包含给定的Key和value
         */
        boolean ck = map.containsKey("语文");
        System.out.println(ck);
        boolean cv = map.containsValue("66");
        System.out.println(cv);
    }
}
