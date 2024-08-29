package com.xyc.arrayAndLinkedList;

import java.util.*;

public class MyArrayList {
    public static void main(String[] args) {
        /* 初始化列表 */
        // 无初始值
        List<Integer> nums1 = new ArrayList<>();
        // 有初始值（注意数组的元素类型需为 int[] 的包装类 Integer[]）
        Integer[] numbers = new Integer[] { 1, 3, 2, 5, 4 };
        List<Integer> nums = new ArrayList<>(Arrays.asList(numbers));


        /* 访问元素 */
        int num = nums.get(1);  // 访问索引 1 处的元素
        System.out.println("访问索引 1 处的元素: " + num);

        /* 更新元素 */
        nums.set(1, 0);  // 将索引 1 处的元素更新为 0
        System.out.println("将索引 1 处的元素更新为 0: " + nums.get(1));

        /* 清空列表 */
        nums.clear();
        System.out.print("清空列表：");
        traverse(nums);

        /** 相较于数组，列表可以自由地添加与删除元素。在列表尾部添加元素的时间复杂度为 O(1) */
        /* 在尾部添加元素 */
        nums.add(1);
        nums.add(3);
        nums.add(2);
        nums.add(5);
        nums.add(4);
        System.out.print("重新添加元素：");
        traverse(nums);

        /** 插入和删除元素的效率仍与数组相同，时间复杂度为 O(n) */
        /* 在中间插入元素 */
        nums.add(3, 6);  // 在索引 3 处插入数字 6
        System.out.print("在索引 3 处插入数字 6：");
        traverse(nums);

        /* 删除元素 */
        nums.remove(3);  // 删除索引 3 处的元素
        System.out.print("删除索引 3 处的元素：");
        traverse(nums);

        /*拼接列表*/
        List<Integer> nums2 = new ArrayList<>(Arrays.asList(new Integer[] { 6, 8, 7, 10, 9 }));
        nums.addAll(nums2);  // 将列表 nums1 拼接到 nums 之后
        System.out.print("将列表 nums2 拼接到 nums 之后：");
        traverse(nums);

        /* 排序列表 */
        Collections.sort(nums);  // 排序后，列表元素从小到大排列
        System.out.print("排序后，列表元素从小到大排列：");
        traverse(nums);

    }

    /* 通过索引遍历列表 */
    public static void traverse(List nums) {
        // 通过索引遍历数组
        for (int i = 0; i < nums.size(); i++) {
            System.out.print(nums.get(i) + " ");
        }
        System.out.println();
    }
}
