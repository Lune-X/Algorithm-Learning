package com.xyc.stackAndQueue;

import java.util.LinkedList;
import java.util.Queue;

/**方法	    描述	                     时间复杂度
    push()	元素入队，即将元素添加至队尾     O(1)
    pop()	队首元素出队                  O(1)
    peek()	访问队首元素                  O(1)  */

/**

 | 4 |
 | 5 |
 | 2 |
 | 3 |
 | 1 |

 */

public class MyQueue {
    public static void main(String[] args) {
        /* 初始化队列 */
        Queue<Integer> queue = new LinkedList<>();

        /* 元素入队 */
        queue.offer(1);
        queue.offer(3);
        queue.offer(2);
        queue.offer(5);
        queue.offer(4);

        /* 访问队首元素 */
        int peek = queue.peek();
        System.out.println("访问队首元素: " + peek);

        /* 元素出队 */
        int pop = queue.poll();
        System.out.println("元素出队: " + pop);

        /* 获取队列的长度 */
        int size = queue.size();
        System.out.println("获取队列的长度: " + size);

        /* 判断队列是否为空 */
        boolean isEmpty = queue.isEmpty();
        System.out.println("判断队列是否为空: " + isEmpty);
    }
}

/**
 * 队列是一种遵循先入先出原则的数据结构，同样可以通过数组或链表来实现。在时间效率和空间效率的对比上，队列的结论与前述栈的结论相似。
 */
