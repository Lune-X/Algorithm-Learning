package com.xyc.sortAlgorithm.advancedSort;

import java.util.Scanner;

/**
 * 原理：通过将数组递归地分成两半，分别进行排序，然后再将排序好的部分合并成一个有序的数组。
 */

public class MergeSort {

    // 递归将原数组分成大小为1的小数组，然后进行排序
    public static void mergeSort(int[] arr) {
        int mid = arr.length / 2;
        if (arr.length < 2) {
            return;
        }

        int[] leftArray = new int[mid];
        int[] rightArray = new int[arr.length-mid];

        int i = 0; //left array
        int j = 0; //right array
        for(; i < arr.length; i++) {
            if(i < mid) {
                leftArray[i] = arr[i];
            }
            else {
                rightArray[j] = arr[i];
                j++;
            }
        }

        mergeSort(leftArray);
        mergeSort(rightArray);

        merge(leftArray,rightArray,arr);
    }

    // 合并两个子数组的函数
    public static void merge(int[] leftArray,int[] rightArray,int[] arr) {
        int i = 0;
        int l = 0;
        int r = 0;
        while (l < leftArray.length && r < rightArray.length) {
            if (leftArray[l] > rightArray[r]) {
                arr[i] = rightArray[r];
                i++;
                r++;
            } else {
                arr[i] = leftArray[l];
                i++;
                l++;
            }
        }

        while (l < leftArray.length){
            arr[i] = leftArray[l];
            i++;
            l++;
        }

        while (r < rightArray.length){
            arr[i] = rightArray[r];
            i++;
            r++;
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
        mergeSort(arr);

        //排序后的数组
        System.out.println("排序后的数组：");
        for (int e : arr) {
            System.out.println(e);
        }
    }
}

