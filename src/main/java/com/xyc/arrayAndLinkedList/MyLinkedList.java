package com.xyc.arrayAndLinkedList;

/**
 * 我们知道，存储数组的内存空间必须是连续的，而当数组非常大时，内存可能无法提供如此大的连续空间。此时链表的灵活性优势就体现出来了。
 *
 * 链表（linked list）是一种线性数据结构，其中的每个元素都是一个节点对象，各个节点通过“引用”相连接。引用记录了下一个节点的内存地址，通过它可以从当前节点访问到下一个节点。
 *
 * 链表的设计使得各个节点可以分散存储在内存各处，它们的内存地址无须连续。
 *
 * 链表节点 ListNode 除了包含值，还需额外保存一个引用（指针）。因此在相同数据量下，链表比数组占用更多的内存空间。
 */
public class MyLinkedList {
    /* 链表节点类 */
    static class ListNode {
        int val;        // 节点值
        ListNode next;  // 指向下一节点的引用
        ListNode(int x) { val = x; }  // 构造函数
    }

    public static void main(String[] args) {
        /*我们通常将头节点当作链表的代称，比如以下代码中的链表可记作链表 n0 */
        /* 初始化链表 1 -> 3 -> 2 -> 5 -> 4 */
        // 初始化各个节点
        ListNode n0 = new ListNode(1);
        ListNode n1 = new ListNode(3);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(5);
        ListNode n4 = new ListNode(4);
        // 构建节点之间的引用
        n0.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        System.out.print("链表初始化成功: ");
        display(n0);
        System.out.println();

        /*插入节点*/
        ListNode n5 = new ListNode(6);
        insert(n4,n5);
        System.out.print("在节点n4后插入新节点n5： ");
        display(n0);
        System.out.println();

        /*删除节点*/
        System.out.print("删除n5节点： ");
        remove(n4);
        display(n0);
        System.out.println();

        /*访问节点*/
        System.out.print("访问索引值为4的节点：");
        System.out.print(access(n0,4).val);
        System.out.println();
    }

    /*打印完整链表*/
    public static void display(ListNode n){
        while(n != null){
            System.out.print(n.val+" ");
            n = n.next;
        }
    }

    /** 在链表中插入节点非常容易。假设我们想在相邻的两个节点 n0 和 n1 之间插入一个新节点 P ，则只需改变两个节点引用（指针）即可，时间复杂度为 O(1) */
    /* 在链表的节点 n0 之后插入节点 P */
    public static void insert(ListNode n0, ListNode P) {
        //n0——>n1  n0——>p——>n1
        P.next = n0.next;
        n0.next = P;
    }

    /**在链表中删除节点也非常方便，只需改变一个节点的引用（指针）即可。
       虽然在删除操作完成后节点 P 仍然指向 n1 ，但实际上遍历此链表已经无法访问到 P ，这意味着 P 已经不再属于该链表了*/
    /* 删除链表的 n 节点 n 之后的首个节点 */
    public static void remove(ListNode n) {
        if (n.next == null)
            return;

        if(n.next.next == null){
            n.next = null;
            return;
        }
        //n0 -> P -> n1 becomes n0 -> n1
        n.next = n.next.next;
    }

    /** 在链表中访问节点的效率较低。我们可以在 O(1) 时间下访问数组中的任意元素。
    链表则不然，程序需要从头节点出发，逐个向后遍历，直至找到目标节点。
    也就是说，访问链表的第 i 个节点需要循环 i - 1 轮，时间复杂度为 O(n) */
    /* 访问链表中索引为 index 的节点 */
    public static ListNode access(ListNode head, int index) {
        for (int i = 0; i < index; i++) {
            if (head == null)
                return null;
            head = head.next;
        }
        return head;
    }
}
