package com.xyc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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

        //System.out.println("花10元3角买能买几支笔: " + pencil(10, 3));

        //System.out.println(buyPencil());

        //System.out.println(plan());

        //System.out.println(unhappy());

        //System.out.println(sum(1));

        //System.out.println(count(11, 1));

        //System.out.println(cantor(9));

        //System.out.println(inverse());

        ant();
    }
}
