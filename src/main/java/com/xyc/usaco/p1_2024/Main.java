package com.xyc.usaco.p1_2024;

import java.util.Scanner;
//USACO 2024 February Contest, Bronze
//Problem 1. Palindrome Game

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();  // 读取测试用例的数量
        scanner.nextLine();  // 跳过行末

        for (int i = 0; i < T; i++) {
            String S = scanner.nextLine();  // 读取当前的 S（石子数量）

            // 检查 S 的最后一位字符是否是 '0'
            if (S.charAt(S.length() - 1) == '0') {
                System.out.println("E");  // Elsie 胜利
            } else {
                System.out.println("B");  // Bessie 胜利
            }
        }

        scanner.close();  // 关闭输入流
    }
}
