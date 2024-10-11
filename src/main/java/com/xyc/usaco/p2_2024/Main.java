package com.xyc.usaco.p2_2024;

import java.util.Scanner;

/**
 * 代码解析：
 * 1.输入处理：
 * 我们从标准输入读取牛的数量 N 和传递次数 M，再读取牛的传递方向和每头牛的容量。
 * 2.缺口牛的标记：
 * 我们通过遍历所有牛，标记出“缺口牛”（即当某头牛向右传递牛奶给左边的牛时，或者当某头牛向左传递牛奶给右边的牛时）。
 * 3.计算牛奶损失：
 * 对于每个“缺口牛”，我们计算它在 M 分钟内可能造成的牛奶损失。损失总量不能超过 M，因为每分钟最多损失一单位牛奶。
 * 4.计算剩余牛奶：
 * 最后，初始总牛奶量减去所有牛奶的损失，即为最终剩余的牛奶总量。
 *
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 读取 N 和 M
        int N = scanner.nextInt();
        long M = scanner.nextLong();

        // 读取牛奶传递方向
        String directions = scanner.next();
        char[] S = directions.toCharArray();

        // 读取每头牛的桶容量
        long[] capacity = new long[N];
        for (int i = 0; i < N; i++) {
            capacity[i] = scanner.nextLong();
        }

        // 计算初始总牛奶量
        long totalMilk = 0;
        for (long cap : capacity) {
            totalMilk += cap;
        }

        // 标记左右出现的缺口牛
        boolean[] badL = new boolean[N];  // 如果某头牛往左传递给右边的牛
        boolean[] badR = new boolean[N];  // 如果某头牛往右传递给左边的牛
        for (int i = 0; i < N; i++) {
            if (S[i] == 'R' && S[(i + 1) % N] == 'L') {
                badL[i] = true;  // 右传后左接，出现缺口
                badR[(i + 1) % N] = true;
            }
        }

        // 计算牛奶损失
        long totalLoss = 0;
        for (int i = 0; i < N; i++) {
            long loss = 0;

            // 处理向左的缺口牛
            if (badL[i]) {
                int j = (i - 1 + N) % N;
                while (S[j] == 'R') {
                    loss += capacity[j];
                    j = (j - 1 + N) % N;
                }
                totalLoss += Math.min(loss, M);
            }

            // 处理向右的缺口牛
            loss = 0;
            if (badR[i]) {
                int j = (i + 1) % N;
                while (S[j] == 'L') {
                    loss += capacity[j];
                    j = (j + 1) % N;
                }
                totalLoss += Math.min(loss, M);
            }
        }

        // 计算剩余的牛奶总量
        long remainingMilk = totalMilk - totalLoss;
        System.out.println(remainingMilk);

        scanner.close();
    }
}

