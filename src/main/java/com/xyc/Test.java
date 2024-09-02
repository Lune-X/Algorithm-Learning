package com.xyc;

public class Test {
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



    public static void main(String[] args) {
        System.out.println("3的2次方: " + power(3, 2));

        System.out.println("总共获得的金币数: " + calculateCoins(6));
    }
}
