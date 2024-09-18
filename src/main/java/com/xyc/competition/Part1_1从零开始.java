package com.xyc.competition;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * 语言基础题
 */

public class Part1_1从零开始 {
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
        rs = sum / cost;
        return rs;
    }

    /**
     * [NOIP2016 普及组] 买铅笔
     * @return minCost 最少花费
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

    /**
     * [NOIP2004 提高组] 津津的储蓄计划
     * @return mom+hand 一年剩下的总钱数
     */
    public static int plan(){
        Scanner sc = new Scanner(System.in);
        int pay = 300;
        int hand = 0;
        int mom = 0;

        System.out.println("请输入每个月的预算: ");
        for (int i = 0; i < 12; i++) {
            int target = sc.nextInt();
            int rest = pay - target;
            if(rest + hand < 0 ){
                return -i-1; // 如果本月钱不够用，返回负的月份
            }
            // 计算每个月剩余的钱，并存整百的钱到 mom 中
            hand += rest; // 将剩余的钱加到手头
            if (hand > 100) {
                mom += (hand / 100) * 100; // 将手头整百的钱存到 mom 中
                hand %= 100; // 手头保留不足一百的部分
            }
        }

        // 计算年末的总金额，包含存款加上20%的利息
        mom = (int) (mom * 1.2);
        return mom + hand;
    }

    /**
     * [NOIP2004 普及组] 不高兴的津津
     * @return days
     */
    public static int unhappy(){
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入津津每天上学和上兴趣班的时间: ");
        int max = 0;
        int week = 0;
        for (int i = 0; i < 7; i++) {
            int h1 = sc.nextInt();
            int h2 = sc.nextInt();

            if (h1 + h2 > 8) {
                if (h1 + h2 > max) {
                    week = i + 1;
                    max = h1 + h2;
                }
            }

        }
        return week;
    }

    /**
     * [NOIP2002 普及组] 级数求和
     * @param k 一个正整数
     * @return n 一个正整数
     */
    public static int sum(int k){
        int n = 1;
        double sum = 0;

        while (sum < k) {
            sum = sum + 1.0/n;
            n++;
        }

        return n;
    }

    /**
     * [NOIP2013 普及组] 计数问题
     *
     * @param n 1~n的整数中
     * @param x 数字x出现了多少次
     */
    public static int count(int n,int x) {
        int count = 0;
        String target = String.valueOf(x);

        for (int i = 1; i <= n; i++) {
            String temp = String.valueOf(i);
            for (int j = 0; j < temp.length(); j++) {
                if (temp.charAt(j) == target.charAt(0)) {
                    count++;
                }
            }
        }

        return count;
    }

    /**
     * [NOIP1999 普及组] Cantor表
     * @param N 第N项
     * @return val 表中第N项的值
     */
    public static double cantor(int N) {
        double val=0.0;
        int diagonal = 1; // 对角线编号
        int sum = 0; // 累计对角线上的项数

        // 找到N所在的对角线
        while (sum + diagonal < N) {
            sum += diagonal;
            diagonal++;
        }

        int offset = N - sum; // 在对角线上的第几项

        if (diagonal % 2 == 0) {
            val = offset / (diagonal - (offset - 1.0));
        } else {
            val = (diagonal - (offset - 1.0)) / offset;
        }

        return val;
    }

    /**
     * [NOIP2011 普及组] 数字反转
     * @return newValue 一个整数，表示反转后的新数
     */
    public static int inverse() throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        // 将数据存入
        StringBuffer sb=new StringBuffer(br.readLine().trim());
        sb.reverse();   // 反转
        //负号跑到最后
        if(sb.charAt(sb.length()-1)=='-'){
            // 删除负号并且在头插入负号
            sb.delete(sb.length()-1, sb.length());
            sb.insert(0, '-');

        }

        return Integer.parseInt(sb.toString());
    }

    public static void main(String[] args) {
        //System.out.println("花10元3角买能买几支笔: " + pencil(10, 3));
        //System.out.println(buyPencil());
        //System.out.println(plan());
        //System.out.println(unhappy());
        //System.out.println(sum(1));
        //System.out.println(count(11, 1));
        //System.out.println(cantor(9));
        //System.out.println(inverse());
    }
}
