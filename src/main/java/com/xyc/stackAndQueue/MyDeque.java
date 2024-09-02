package com.xyc.stackAndQueue;

import java.util.Deque;
import java.util.LinkedList;

/**
    方法名	        描述	            时间复杂度
    push_first()	将元素添加至队首	  O(1)
    push_last()	    将元素添加至队尾	  O(1)
    pop_first()	    删除队首元素	      O(1)
    pop_last()	    删除队尾元素	      O(1)
    peek_first()	访问队首元素	      O(1)
    peek_last()	    访问队尾元          O(1)     */

public class MyDeque {
    public static void main(String[] args) {
        /* 初始化双向队列 */
        Deque<Integer> deque = new LinkedList<>();

        /* 元素入队 */
        deque.offerLast(2);   // 添加至队尾
        deque.offerLast(5);
        deque.offerLast(4);
        deque.offerFirst(3);  // 添加至队首
        deque.offerFirst(1);

        System.out.println("元素入队: ");
        for (Integer num : deque) {
            System.out.println(num);
        }


        /* 访问元素 */
        int peekFirst = deque.peekFirst();  // 队首元素
        int peekLast = deque.peekLast();    // 队尾元素
        System.out.println("访问队首元素: " + peekFirst);
        System.out.println("访问队尾元素: " + peekLast);

        /* 元素出队 */
        int popFirst = deque.pollFirst();  // 队首元素出队
        int popLast = deque.pollLast();    // 队尾元素出队
        System.out.println("队首元素出队: " + popFirst);
        System.out.println("队尾元素出队: " + popLast);

        /* 获取双向队列的长度 */
        int size = deque.size();
        System.out.println("获取双向队列的长度: " + size);

        /* 判断双向队列是否为空 */
        boolean isEmpty = deque.isEmpty();
        System.out.println("判断双向队列是否为空: " + isEmpty);
    }
}

/**
 * 双向队列是一种具有更高自由度的队列，它允许在两端进行元素的添加和删除操作。
 */
