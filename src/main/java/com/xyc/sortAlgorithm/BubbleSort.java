package com.xyc.sortAlgorithm;

import java.util.Scanner;

public class BubbleSort {

    public static void bubbleSort(int[] array){
        for(int i = 0; i < array.length - 1; i++){
            for(int j = 0; j < array.length - 1 - i; j++){
                if(array[j] > array[j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        //输入原数组
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入数组的大小: ");
        int n = sc.nextInt();
        int[] arr = new int[n];

        System.out.println("请输入随机顺序的数组: ");
        for(int i = 0; i< n; i++){
            arr[i] = sc.nextInt();
        }

        //冒泡排序
        bubbleSort(arr);

        //排序后的数组
        System.out.println("排序后的数组：");
        for (int e:arr) {
            System.out.println(e);
        }
    }
}
