package com.xyc.sortAlgorithm;

import java.util.Scanner;

public class InsertSort {

    public static void insertSort(int[] arr){
        // 从数组的第二个元素开始，逐个插入到已排序的部分
        for (int i = 1; i < arr.length; i++) {
            int current = arr[i];  // 当前要插入的元素
            int j = i - 1;  // 已排序部分的最后一个元素的索引

            // 将当前元素与已排序部分的元素逐个比较，如果当前元素较小，向右移动已排序的元素
            while (j >= 0 && current < arr[j]) {
                arr[j + 1] = arr[j];  // 向右移动
                j--;
            }
            // 找到插入位置，放置当前元素
            arr[j + 1] = current;
        }
    }

    public static void main(String[] args) {
        //输入原数组
        Scanner sc = new Scanner(System.in);

        System.out.println("请输入数组的大小：");
        int size = sc.nextInt();
        int[] arr = new int[size];

        System.out.println("请输入数组元素:");
        for(int i = 0;i<size;i++){
            arr[i] = sc.nextInt();
        }

        //插入排序
        insertSort(arr);

        //排序后的数组
        System.out.println("排序后的数组：");
        for (int e : arr) {
            System.out.println(e);
        }
    }
}
