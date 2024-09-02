package com.xyc.stackAndQueue;

import java.util.Stack;

/**方法	    描述	                时间复杂度
    push()	元素入栈（添加至栈顶）     O(1)
    pop()	栈顶元素出栈             O(1)
    peek()	访问栈顶元素             O(1)  */

/**

    | 4 |
    | 5 |
    | 2 |
    | 3 |
    |_1_|

 */

public class MyStack {
    public static void main(String[] args) {
        /* 初始化栈 */
        Stack<Integer> stack = new Stack<>();

        /* 元素入栈 */
        stack.push(1);
        stack.push(3);
        stack.push(2);
        stack.push(5);
        stack.push(4);

        /* 访问栈顶元素 */
        int peek = stack.peek();
        System.out.println("访问栈顶元素: " + peek);

        /* 元素出栈 */
        int pop = stack.pop();
        System.out.println("元素出栈: " + pop);

        /* 获取栈的长度 */
        int size = stack.size();
        System.out.println("获取栈的长度: " + size);

        /* 判断是否为空 */
        boolean isEmpty = stack.isEmpty();
        System.out.println("判断是否为空: " + isEmpty);

    }
}
/**
 * 栈是一种遵循先入后出原则的数据结构，可通过数组或链表来实现。
 * 在时间效率方面，栈的数组实现具有较高的平均效率，但在扩容过程中，单次入栈操作的时间复杂度会劣化至 O(n) 。相比之下，栈的链表实现具有更为稳定的效率表现。
 * 在空间效率方面，栈的数组实现可能导致一定程度的空间浪费。但需要注意的是，链表节点所占用的内存空间比数组元素更大。
 */