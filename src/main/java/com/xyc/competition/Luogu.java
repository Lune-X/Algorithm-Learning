package com.xyc.competition;

import java.io.IOException;
import java.util.Scanner;

public class Luogu {
    /**
     * 递归应用 —— 求次方
     * @param a 底数
     * @param b 指数
     * @return a的b次方计算结果
     */
    public static int power(int a, int b) {
        if(b==0) return 1;
        return a * power(a,b-1);
    }

    /**
     * [NOIP 2015 普及组] 金币
     *
     * @param days 要计算的总天数
     * @return sum 金币的总数
     */
    public static int calculateCoins(int days){
        int sum  = 0;
        int coinLevel = 1;

        for(int i = 1;i <= days;){
            for (int j = 1; j <= coinLevel; j++) {
                sum = sum + coinLevel;
                i++;
            }

            coinLevel++;
        }

        return sum;
    }

    /**
     * 有一群蚂蚁在一根长度为 l 厘米的水平杆上行走，每只蚂蚁的速度都是 1 厘米/秒。当一只蚂蚁走到杆的一端时，它会立刻掉落。如果两只蚂蚁相遇，它们会掉头并开始朝相反的方向行走。我们知道这些蚂蚁的初始位置，但不知道它们行走的方向。你的任务是计算所有蚂蚁掉落杆子的最早和最晚的时间。
     * 输入格式：
     * 输入的第一行是一个整数，表示接下来有多少组测试数据（最多 100 组）。
     * 每组测试数据开始包含两个整数 l 和 n，分别表示杆子的长度（单位：厘米）和蚂蚁的数量。接下来的一行包含 n 个整数，表示每只蚂蚁到杆左端的距离。
     * 所有输入整数在 0 到 1,000,000 之间。
     * 输出格式：
     * 对于每一组测试数据，输出两个数字，分别表示所有蚂蚁掉落杆子的最早时间和最晚时间，两个数字用一个空格隔开。
     * @param
     * @throws IOException
     */
    public static void ant(){
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt(); // 读取测试用例的数量

        for (int i = 0; i < cases; i++) {
            int l = sc.nextInt(); // 杆子的长度
            int n = sc.nextInt(); // 蚂蚁的数量
            int[] ants = new int[n]; // 存储每只蚂蚁的位置
            for (int j = 0; j < n; j++) {
                ants[j] = sc.nextInt(); // 读取每只蚂蚁的位置
            }

            int earliest = 0; // 最早掉落时间
            int latest = 0;   // 最晚掉落时间

            for (int ant : ants) {
                // 计算每只蚂蚁距离左右两端的距离
                int toLeft = ant; // 距离左端的距离
                int toRight = l - ant; // 距离右端的距离

                // 所有蚂蚁中最早掉落的时间
                earliest = Math.max(earliest, Math.min(toLeft, toRight));

                // 所有蚂蚁中最晚掉落的时间
                latest = Math.max(latest, Math.max(toLeft, toRight));
            }

            // 输出最早和最晚的掉落时间
            System.out.println(earliest + " " + latest);
        }
        sc.close();
    }



    public static void main(String[] args) throws IOException {
        //System.out.println("3的2次方: " + power(3, 2));

        //System.out.println("总共获得的金币数: " + calculateCoins(6));

        //ant();
    }
}


