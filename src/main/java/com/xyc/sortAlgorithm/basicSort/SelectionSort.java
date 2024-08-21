package com.xyc.sortAlgorithm.basicSort;

import java.util.Scanner;

/**
 * 原理:每次从未排序部分中选出最小（或最大）的元素，放到已排序部分的末尾，依次进行，直到整个数组有序。
 */

public class SelectionSort {
    public static void selectSort(int[] array){
        int len = array.length;
        // 遍历数组，n-1轮
        for(int i = 0;i < len - 1;i++){
            // 假设当前的元素是最小值
            int minIndex = i;
            // 从 i+1 位置开始，找到剩余未排序部分的最小值
            for(int j = i + 1;j < len ;j++){
                if(array[j] < array[minIndex]){
                    minIndex = j; // 记录最小值的索引
                }
            }
            sweap(array,minIndex,i);
        }
    }

    // 将最小值与当前的i位置交换
    public static void sweap(int[] array, int index1, int index2){
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
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

        //选择排序
        selectSort(arr);

        //排序后的数组
        System.out.println("排序后的数组：");
        for (int e : arr) {
            System.out.println(e);
        }
    }
}
