package com.xyc.competition;

import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 数组可以用于存储大量的信息。
 */
public class Part1_2数组基础 {
    /**
     * [NOIP2005 普及组] 陶陶摘苹果
     * @return
     * @throws IOException
     */
    public static int apple(){
        int count = 0;
        Scanner sc = new Scanner(System.in);
        int[] dis = new int[10];
        System.out.println("请输入10个100~200之间数字（代表苹果到地面的距离）: ");

        for (int i = 0; i < 10; i++) {
            dis[i] = sc.nextInt();
        }

        System.out.println("请输入一个100~120之间的数字(代表手伸直的时候能够达到的最大高度): ");
        int hand = sc.nextInt();

        for (int i = 0; i < 10; i++) {
            if (hand + 30 - dis[i] >= 0) {
                count++;
            }
        }
        return count;
    }

    /**
     * [NOIP2005 普及组] 校门外的树
     * @return count 返回有几棵剩下的树
     * @throws IOException
     */
    public static int schoolTree(){
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        int m = sc.nextInt();
        int count = 0;

        boolean[] road = new boolean[length + 1];

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();

            for (int j = u; j <= v; j++) {
                road[j] = true;
            }
        }

        for (boolean b : road) {
            if (!b) {
                count++;
            }
        }

        return count;
    }

    /**
     * P1427 小鱼的数字游戏
     * @return
     * @throws IOException
     */
    public static void mathGame(){
        int i = 0;
        int[] mathArray = new int[100];  // 最多输入100个数字
        System.out.println("请输入一串数字：");
        Scanner sc = new Scanner(System.in);

        while (true) {
            int num = sc.nextInt();  // 读取一个整数
            if (num == 0) {  // 如果输入的是 0，停止
                break;
            }
            mathArray[i] = num;  // 存入数组
            i++;
        }

        // 从后往前输出数组中的数字
        for (int j = i - 1; j >= 0; j--) {
            System.out.print(mathArray[j] + " ");
        }
        System.out.println();  // 最后换行
    }

    /**
     * [NOIP2014 普及组] 珠心算测验
     *
     * @return
     * @throws IOException
     */
    public static void test() {
        int count = 0;
        Scanner sc = new Scanner(System.in);

        // 读取正整数的数量
        System.out.println("请输入正整数的数量: ");
        int num = sc.nextInt();
        int[] array = new int[num];

        // 读取所有的正整数
        System.out.println("请输入N个正整数，每个正整数之间用空格隔开: ");
        for (int i = 0; i < num; i++) {
            array[i] = sc.nextInt();
        }

        // 使用 Set 来存储和比较
        Set<Integer> resultSet = new HashSet<>();

        // 双重循环找出两个数的和，检查是否在集合中
        for (int i = 0; i < num; i++) {
            for (int j = i + 1; j < num; j++) {
                int sum = array[i] + array[j];

                // 检查和是否在数组中，并且是不同的数
                for (int k = 0; k < num; k++) {
                    if (array[k] == sum) {
                        resultSet.add(sum); // 添加到 Set 中避免重复
                        break;
                    }
                }
            }
        }

        // 输出结果
        System.out.println(resultSet.size());
    }

    /**
     * P5594 【XR-4】模拟赛
     * @throws IOException
     */
    public static void demoCompetition() {
        Scanner sc = new Scanner(System.in);

        // 读取 n, m, k
        int n = sc.nextInt(); // OIer 的人数
        int m = sc.nextInt(); // 每个人的模拟赛数量
        int k = sc.nextInt(); // 接下来的天数

        // 使用数组存储每一天的模拟赛题目情况
        HashSet[] dayContest = new HashSet[k + 1];

        // 初始化每一天的比赛记录
        for (int i = 1; i <= k; i++) {
            dayContest[i] = new HashSet<>();
        }

        // 遍历每个选手的空闲日程安排
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= m; j++) {
                int day = sc.nextInt(); // 读取第 j 套模拟赛的日期
                dayContest[day].add(j); // 第 day 天需要准备第 j 套题
            }
        }

        // 输出每一天需要准备的模拟赛场数
        for (int i = 1; i <= k; i++) {
            System.out.print(dayContest[i].size() + " ");
        }

        System.out.println();
    }

    public static void demoCompetition2() {
        Scanner sc = new Scanner(System.in);

        // 读取 n, m, k
        int n = sc.nextInt(); // 选手数量
        int m = sc.nextInt(); // 每个选手需要完成的比赛题数量
        int k = sc.nextInt(); // 总天数

        // 初始化二维数组 dayContest，行表示天数，列表示比赛题目
        int[][] dayContest = new int[k + 1][m + 1];

        // 遍历每个选手的比赛安排
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= m; j++) {
                int day = sc.nextInt(); // 获取选手的第 j 个有空的日期
                dayContest[day][j] = 1; // 标记这一天需要准备第 j 套题目
            }
        }

        // 统计并输出每一天需要准备的比赛场数
        for (int i = 1; i <= k; i++) {
            int count = 0;
            for (int j = 1; j <= m; j++) {
                if (dayContest[i][j] == 1) {
                    count++;  // 统计当天需要准备的比赛场数
                }
            }
            System.out.print(count + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        //System.out.println(apple());

        //System.out.println(schoolTree());

        //mathGame();

        //test();

        demoCompetition2();
    }
}
