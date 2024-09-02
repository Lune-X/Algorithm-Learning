package com.xyc;

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
     * NOIP 2015 普及组 金币
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
     * 洛谷 P1421 小玉买文具
     *
     * @param yuan 用多少元买笔
     * @param jiao 用多少角买币
     * @return rs 能买几支笔
     */
    public static int pencil(int yuan, int jiao) {
        int rs = 0;
        final int cost = 19;
        int sum = 10 * yuan + jiao;
        rs = sum / 19;
        return rs;
    }

    /**
     * NOIP2016 普及组 买铅笔
     * @return
     */
    public static int buyPencil(){
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入需要铅笔的数量: ");
        int need = sc.nextInt();

        // 定义变量存储最小花费
        int minCost = Integer.MAX_VALUE;

        // 读取三种包装的数量和价格，并计算花费
        for (int i = 0; i < 3; i++) {
            int quantity = sc.nextInt(); // 包装内铅笔数量
            int price = sc.nextInt();    // 包装价格

            // 计算需要的包装数量
            int packagesNeeded = (need + quantity - 1) / quantity;   // 向上取整

            // 计算当前包装的总花费
            int cost = packagesNeeded * price;

            // 更新最小花费
            minCost = Math.min(minCost, cost);
        }

        return minCost;
    }

    public static void main(String[] args) {
        System.out.println("3的2次方: " + power(3, 2));

        System.out.println("总共获得的金币数: " + calculateCoins(6));
        System.out.println("花10元3角买能买几支笔: " + pencil(10, 3));
        // 输出最小花费
        System.out.println(buyPencil());
    }
}
