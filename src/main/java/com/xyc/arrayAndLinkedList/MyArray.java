package com.xyc.arrayAndLinkedList;

/**
 * 数组（array）是一种线性数据结构，其将相同类型的元素存储在连续的内存空间中。我们将元素在数组中的位置称为该元素的索引（index）
 */

public class MyArray {
    public static void main(String[] args) {
        /* 初始化数组 */
        int[] arr = new int[5]; // { 0, 0, 0, 0, 0 }
        int[] nums = { 1, 3, 2, 5, 4 };

        /** 在数组中访问元素非常高效，我们可以在 O(1) 时间内随机访问数组中的任意一个元素. */
        System.out.print("数组的第一个元素: ");
        System.out.println(nums[0]);

        /*遍历数组*/
        traverse(nums);
        traverse(nums,"index");

        /*插入元素*/
        insert(nums,10,3);
        System.out.print("将新元素10插入3处后的数组: ");
        traverse(nums);

        /*删除元素*/
        remove(nums, 3);
        System.out.print("删除3处元素后的数组：");
        traverse(nums);

        /*查找元素*/
        int result = find(nums, 10);
        System.out.print("有没有找到10: ");
        System.out.println(result);

        /*数组扩容*/
        int[] newArray = extend(nums,7);
        System.out.print("新数组遍历: ");
        traverse(newArray);
    }

    /* 遍历数组 */
    public static void traverse(int[] nums,String index) {
        // 通过索引遍历数组
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }

    public static void traverse(int[] nums) {
        // 直接遍历数组元素
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    /** 如果想在数组中间插入一个元素，则需要将该元素之后的所有元素都向后移动一位，之后再把元素赋值给该索引。*/
    /* 在数组的索引 index 处插入元素 num */
    public static void insert(int[] nums, int num, int index) {
        // 把索引 index 以及之后的所有元素向后移动一位
        for (int i = nums.length - 1; i > index; i--) {
            nums[i] = nums[i - 1];
        }
        // 将 num 赋给 index 处的元素
        nums[index] = num;
    }

    /** 删除索引 i 处的元素，则需要把索引 i 之后的元素都向前移动一位 */
    /* 删除索引 index 处的元素 */
    public static void remove(int[] nums, int index) {
        // 把索引 index 之后的所有元素向前移动一位
        for (int i = index; i < nums.length - 1; i++) {
            nums[i] = nums[i + 1];
        }
    }

    /** 在数组中查找指定元素需要遍历数组，每轮判断元素值是否匹配，若匹配则输出对应索引。因为数组是线性数据结构，所以上述查找操作被称为“线性查找”。 */
    /* 在数组中查找指定元素 */
    public static int find(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target)
                return i;
        }
        return -1;
    }

    /** 在大多数编程语言中，数组的长度是不可变的。如果我们希望扩容数组，则需重新建立一个更大的数组，然后把原数组元素依次复制到新数组。
     * 这是一个 O(n) 的操作，在数组很大的情况下非常耗时。*/
    /* 扩展数组长度 */
    public static int[] extend(int[] nums, int enlarge) {
        // 初始化一个扩展长度后的数组
        int[] res = new int[nums.length + enlarge];
        // 将原数组中的所有元素复制到新数组
        for (int i = 0; i < nums.length; i++) {
            res[i] = nums[i];
        }
        // 返回扩展后的新数组
        return res;
    }
}
