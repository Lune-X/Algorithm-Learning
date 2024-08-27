package com.xyc.sortAlgorithm.advancedSort;

import java.util.Scanner;

public class MergeSort {

    // 归并排序的主函数
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            // 找到中间点
            int mid = left + (right - left) / 2;

            // 递归对左半部分排序
            mergeSort(arr, left, mid);
            // 递归对右半部分排序
            mergeSort(arr, mid + 1, right);

            // 合并两个有序的子数组
            merge(arr, left, mid, right);
        }
    }

    // 合并两个有序子数组的函数
    public static void merge(int[] arr, int left, int mid, int right) {
        // 找到两个子数组的大小
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // 创建临时数组，分别存储左右子数组
        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        // 将数据复制到临时数组
        for (int i = 0; i < n1; i++) {
            leftArray[i] = arr[left + i];
        }
        for (int j = 0; j < n2; j++) {
            rightArray[j] = arr[mid + 1 + j];
        }

        // 归并两个有序的子数组
        int i = 0, j = 0;
        int k = left;

        // 将两个临时数组中的数据合并到原数组
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                arr[k] = leftArray[i];
                i++;
            } else {
                arr[k] = rightArray[j];
                j++;
            }
            k++;
        }

        // 如果左子数组还有剩余元素，将它们加到原数组中
        while (i < n1) {
            arr[k] = leftArray[i];
            i++;
            k++;
        }

        // 如果右子数组还有剩余元素，将它们加到原数组中
        while (j < n2) {
            arr[k] = rightArray[j];
            j++;
            k++;
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

        //调用归并排序
        mergeSort(arr, 0, arr.length - 1);

        //排序后的数组
        System.out.println("排序后的数组：");
        for (int e : arr) {
            System.out.println(e);
        }
    }
}

