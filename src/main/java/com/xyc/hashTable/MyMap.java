package com.xyc.hashTable;

/**
 * 哈希表（hash table），又称散列表，它通过建立键 key 与值 value 之间的映射，实现高效的元素查询。具体而言，我们向哈希表中输入一个键 key ，则可以在 O(1) 时间内获取对应的值 value 。
 */

import java.util.HashMap;
import java.util.Map;

/**
 *              数组	        链表	        哈希表
 * 查找元素	     O(N)        O(N)          O(1)
 * 添加元素       O(1)        O(1)          O(1)
 * 删除元素       O(N)        O(N)          O(1)
 */

public class MyMap {
    public static void main(String[] args) {
        /* 初始化哈希表 */
        Map<Integer, String> map = new HashMap<>();

        /* 添加操作 */
        // 在哈希表中添加键值对 (key, value)
        map.put(12836, "小哈");
        map.put(15937, "小啰");
        map.put(16750, "小算");
        map.put(13276, "小法");
        map.put(10583, "小鸭");

        /* 查询操作 */
        // 向哈希表中输入键 key ，得到值 value
        String name = map.get(15937);

        /* 删除操作 */
        // 在哈希表中删除键值对 (key, value)
        map.remove(10583);

        /* 遍历哈希表 */
        // 遍历键值对 key->value
        for (Map.Entry <Integer, String> kv: map.entrySet()) {
            System.out.println(kv.getKey() + " -> " + kv.getValue());
        }
        // 单独遍历键 key
        for (int key: map.keySet()) {
            System.out.println(key);
        }
        // 单独遍历值 value
        for (String val: map.values()) {
            System.out.println(val);
        }
    }
}
