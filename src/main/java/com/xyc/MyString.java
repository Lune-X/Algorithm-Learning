package com.xyc;

public class MyString {
    public static void main(String[] args) {
        String s1 = "Hello";
        String s2 = "World";
        //连接字符串
        System.out.println(s1 + s2);

        //输出字符串的长度
        System.out.println(s1.length());

        //比较两个字符串
        System.out.println(s1.equals(s2));

        //输出字符串中的指定索引对应的字符
        System.out.println(s1.charAt(0));

        //截取子串
        System.out.println(s1.substring(2));


        //使用split方法结合索引获取子串（适用于根据特定分隔符截取部分内容）
        String str = "apple,banana,orange";
        String[] parts = str.split(","); // parts = ["apple", "banana", "orange"]
        if (parts.length > 1) {
            String subStr = parts[1];
            System.out.println(subStr); // 输出 "banana"
        }

        //使用charAt和循环手动构建子串（比较复杂的场景下）
        String str1 = "abcdefghij";
        StringBuilder subStrBuilder = new StringBuilder();
        for (int i = 0; i < str.length(); i += 2) {
            subStrBuilder.append(str.charAt(i));
        }
        String subStr = subStrBuilder.toString();
        System.out.println(subStr); // 输出 "acegi"

        //BF 算法
        System.out.println(bruteForceMatch("bcad", "a"));
    }

    /**
     * BF 算法：
     * 1.1 基础概念：
     * BF 算法是一种字符串匹配算法，也被称为朴素匹配算法。它从主串的每个位置开始，逐个比较主串和模式串的字符，找到匹配的位置。
     * 1.2 核心思想：
     * 遍历主串的每个位置，然后在该位置开始与模式串逐个字符比较。如果字符匹配成功，就继续比较下一个字符；如果字符不匹配，则从第一个匹配的 i + 1 开始，然后 j 从 1 开始重新比较。
     * 1.3 时间复杂度：
     * O(nm)，其中 n 是主串的长度， m 是模式串的长度。在最坏情况下，需要比较 n * m 次。
     * @param host 主字符串
     * @param child 子字符串(需要匹配的字符串)
     * @return 子字符串在主字符串中第一次出现的位置
     */
    public static int bruteForceMatch(String host, String child) {
        int n = host.length();
        int m = child.length();

        for (int i = 0; i <= n - m; i++) {
            int j;
            for (j = 0; j < m; j++) {
                if (host.charAt(i + j) != child.charAt(j)) {
                    break;
                }
            }
            if (j == m) {
                return i;
            }
        }
        return -1;
    }
}