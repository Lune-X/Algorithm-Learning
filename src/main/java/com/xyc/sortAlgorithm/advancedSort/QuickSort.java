package com.xyc.sortAlgorithm.advancedSort;

import java.util.Scanner;

/**
 * 原理：
 * 1.在数组中选一个基准数（通常为数组第一个）。
 * 2.将数组中小于基准数的数据移到基准数左边，大于基准数的移到右边
 * 3.对于基准数左、右两边的数组，不断重复以上两个过程，直到每个子集只有一个元素，即为全部有序。
 */

public class QuickSort {
    public static void quickSort(int[] nums, int left, int right) {
        // 子数组长度为 1 时终止递归
        if (left >= right)
            return;

        // 哨兵划分
        int pivot = partition(nums, left, right);

        // 递归左子数组、右子数组
        quickSort(nums, left, pivot - 1);
        quickSort(nums, pivot + 1, right);
    }

    public static int partition(int[] array, int left, int right) {
        int pivot = array[left]; // 选择最左边为基准数
        int l = left;
        int r = right;

        while(l < r){
            while(l < r && array[r] >= pivot) { //找到右子数组中比基准小的数
                r--;
            }
            while(l < r && array[l] <= pivot){ //找到左子数组中比基准小的数
                l++;
            }
            swap(array, l, r);
        }

        swap(array,left,l); // 将基准数交换至两子数组的分界线

        return l; // 返回基准数的索引
    }

    private static void swap(int[] arr1,int left,int right) {
        int temp = arr1[left];
        arr1[left] = arr1[right];
        arr1[right] = temp;
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

        //调用快速排序
        quickSort(arr, 0, arr.length-1);

        //排序后的数组
        System.out.println("排序后的数组：");
        for (int e : arr) {
            System.out.println(e);
        }
    }
}
