package com.xyc.competition;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * compareTo()函数
 * compareTo()函数会比较当前对象和另一个对象
 * 如果当前对象 > 另一个对象 return 1
 * 如果当前对象 < 另一个对象 return -1
 * 如果当前对象 = 另一个对象 return 0
 *
 * Array.sort()函数当使用lamda表达式时，lamda表达式返回为正时进行交换（默认升序）
 */

/**
 * 字符串是特殊的数组，但它也有很多自身的特点。
 */

public class Part1_3字符串基础 {
    public static void test(){
        Integer[] num = {3, 1, 2, 4};
        Arrays.sort(num,(a,b)->b-a); //降序排序
        for (int e : num) {
            System.out.print(e);
        }
        System.out.println();

        String x = "a";
        String y = "b";
        String z = "b";
        System.out.println(x.compareTo(y));
        System.out.println(y.compareTo(x));
        System.out.println(y.compareTo(z));
    }

    /**
     * P5015 [NOIP2018 普及组] 标题统计
     * 凯凯刚写了一篇美妙的作文，请问这篇作文的标题中有多少个字符？ 注意：标题中可能包含大、小写英文字母、数字字符、空格和换行符。统计标题字符数时，空格和换行符不计算在内。
     */
    public static int calculateTitle(){
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要统计的标题: ");

        // 读取输入的标题
        String title = sc.nextLine();

        // 统计有效字符数量
        int count = 0;
        for (int i = 0; i < title.length(); i++) {
            char ch = title.charAt(i);
            // 判断是否为字母或数字，忽略空格和换行符
            if ((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9')) {
                count++;
            }
        }

        // 输出字符数
        return count;
    }

    /**
     * P1055 [NOIP2008 普及组] ISBN 号码
     *
     */
    public static void isbnNumber(){
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入识别的ISBN号码: ");

        //输入识别的ISBN号码
        String isbn = sc.nextLine();

        // 解析前9位数字（跳过-号）
        int sum = 0, index = 0;
        for (int i = 0; i < isbn.length(); i++) {
            char ch = isbn.charAt(i);
            if (ch != '-') {
                int num = ch - '0';  // 转换字符为数字
                sum += num * (++index);  // 累加加权值
            }
            if (index == 9) {
                break;  // 前9位数字处理完毕
            }
        }

        // 计算识别码
        int mod = sum % 11;
        String correctCheckCode = (mod == 10) ? "X" : String.valueOf(mod);

        // 获取输入中的识别码
        String inputCheckCode = isbn.substring(isbn.length() - 1);

        // 判断识别码是否正确
        if (inputCheckCode.equals(correctCheckCode)) {
            System.out.println("Right");
        } else {
            // 构造正确的ISBN号码
            System.out.println(isbn.substring(0, isbn.length() - 1) + correctCheckCode);
        }
    }

    /**
     * P1308 [NOIP2011 普及组] 统计单词数
     *
     */
    public static String wordsCount(){
        Scanner sc = new Scanner(System.in);

        System.out.println("请输入要检测的单词: ");
        String words = sc.nextLine(); // 先获取单词
        System.out.println("请输入要检测的句子: ");
        String sentence = sc.nextLine(); // 再获取句子

        // 将单词和句子都转为小写，确保不区分大小写
        words = words.toLowerCase();
        sentence = sentence.toLowerCase();

        // 将句子按照空格分割成单词数组
        String[] wordArray = sentence.split(" ");
        int count = 0;
        int min = Integer.MAX_VALUE;

        // 遍历单词数组，查找匹配的单词
        for (int i = 0; i < wordArray.length; i++) {
            if (wordArray[i].equals(words)) {  // 用 equals 比较字符串内容
                count++;
                if (i < min) {
                    min = i;  // 记录最早出现的位置
                }
            }
        }

        // 如果没有找到匹配的单词，返回 -1
        if (count == 0) {
            return "-1";
        }

        // 返回匹配的单词数量和最早出现的位置
        return count + " " + min;
    }

    /**
     * P2010 [NOIP2016 普及组] 回文日期
     */
    public static void date(){
        Scanner sc = new Scanner(System.in);
        String startDateStr = sc.nextLine();
        String endDateStr = sc.nextLine();

        int[] startDate = parseDate(startDateStr);
        int[] endDate = parseDate(endDateStr);

        int palindromeCount = 0;

        // 遍历日期范围
        while (!isAfter(startDate, endDate)) {
            if (isPalindromeDate(startDate[0], startDate[1], startDate[2])) {
                palindromeCount++;
            }
            nextDay(startDate);
        }

        // 检查最后一天
        if (isPalindromeDate(endDate[0], endDate[1], endDate[2])) {
            palindromeCount++;
        }

        // 输出结果
        System.out.println(palindromeCount);
    }

    // 判断一个年份是否是闰年
    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    // 给定年月，返回这个月的天数
    public static int getDaysInMonth(int year, int month) {
        int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (month == 2 && isLeapYear(year)) {
            return 29;
        }
        return days[month - 1];
    }

    // 检查一个日期是否是回文日期
    public static boolean isPalindromeDate(int year, int month, int day) {
        String dateStr = String.format("%04d%02d%02d", year, month, day);
        int len = dateStr.length();
        for (int i = 0; i < len / 2; i++) {
            if (dateStr.charAt(i) != dateStr.charAt(len - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    // 将8位日期字符串转为年、月、日数组
    public static int[] parseDate(String date) {
        int year = Integer.parseInt(date.substring(0, 4));
        int month = Integer.parseInt(date.substring(4, 6));
        int day = Integer.parseInt(date.substring(6, 8));
        return new int[]{year, month, day};
    }

    // 日期递增一天
    public static void nextDay(int[] date) {
        int year = date[0];
        int month = date[1];
        int day = date[2];

        if (day < getDaysInMonth(year, month)) {
            date[2] += 1;
        } else {
            date[2] = 1;
            if (month < 12) {
                date[1] += 1;
            } else {
                date[1] = 1;
                date[0] += 1;
            }
        }
    }

    // 比较两个日期数组
    public static boolean isAfter(int[] date1, int[] date2) {
        if (date1[0] > date2[0]) return true;
        if (date1[0] == date2[0] && date1[1] > date2[1]) return true;
        if (date1[0] == date2[0] && date1[1] == date2[1] && date1[2] > date2[2]) return true;
        return false;
    }

    /**
     * P1012 [NOIP1998 提高组] 拼数
     */
    public static void number(){
        Scanner sc = new Scanner(System.in);

        // 输入数字的个数
        int n = sc.nextInt();
        // 读取所有数字并转换为字符串
        String[] numbers = new String[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = sc.next();
        }

        // 使用lambda表达式排序
        Arrays.sort(numbers, (a, b) -> (b + a).compareTo(a + b));

        // 特殊情况：如果最大的数字是 0，直接输出 0
        if (numbers[0].equals("0")) {
            System.out.println("0");
            return;
        }

        // 拼接排序后的数字
        StringBuilder largestNumber = new StringBuilder();
        for (String num : numbers) {
            largestNumber.append(num);
        }

        // 输出最终结果
        System.out.println(largestNumber);
    }

    /**
     * P5587 打字练习
     */
    public static int practice(){
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入范文: ");
        ArrayList<String> modelText = new ArrayList<>();
        ArrayList<String> userInput = new ArrayList<>();

        //读取范文
        while (true) {
            String s = sc.nextLine();
            if (s.equals("EOF")) {
                break;
            }
            modelText.add(s);
        }

        //读取输入
        System.out.println("请输入R君的输入: ");
        while (true) {
            String o = sc.nextLine();
            if (o.equals("EOF")) {
                break;
            }
            userInput.add(processInput(o)); // 处理退格键的输入
        }

        //读取花费的时间
        int time = sc.nextInt();

        //比较行数取最小值
        int count = 0;
        int line = Math.min(modelText.size(), userInput.size());

        for (int i = 0; i < line; i++) {
            String model = modelText.get(i);
            String input = userInput.get(i);
            count += countCorrectChars(model, input);
        }

        // 计算KPM
        int kpm = (int) Math.round((count * 60.0) / time);

        return kpm;
    }

    //逐位比较，统计正确的字符
    public static int countCorrectChars(String model, String input) {
        int countCorrectChars = 0;

        int len = Math.min(model.length(), input.length());
        for (int i = 0; i < len; i++) {
            if (model.charAt(i) == input.charAt(i)) {
                countCorrectChars++;
            }
        }

        return countCorrectChars;
    }

    // 处理退格键，模拟删除字符的操作
    private static String processInput(String input) {
        StringBuilder processed = new StringBuilder();
        for (char ch : input.toCharArray()) {
            if (ch == '<') {
                if (processed.length() > 0) {
                    processed.deleteCharAt(processed.length() - 1); // 模拟退格
                }
            } else {
                processed.append(ch); // 正常字符添加
            }
        }
        return processed.toString();
    }


    public static void main(String[] args) {
        //System.out.println(calculateTitle());

        //isbnNumber();

        //System.out.println(wordsCount());

        //date();

        //number();

        //test();

        System.out.println(practice());
    }

}
