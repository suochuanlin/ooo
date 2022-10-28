package com.myooo.myooo.practice.linkedList;

import java.util.ArrayList;
import java.util.Stack;

/**
 * leetcode 查找单链表中的倒数第k个节点
 */
public class getKthFromEnd {

    public static void main(String[] args) {
        SingleLinkedList.add(1);
        SingleLinkedList.add(2);
        SingleLinkedList.add(3);
        SingleLinkedList.add(4);
        SingleLinkedList.printlist(SingleLinkedList.getHead());
//        ListNode head = SingleLinkedList.getHead();
        System.out.println("------分割线------");
//        SingleLinkedList.printlist(getKthFromEnd(head,3));
//        SingleLinkedList.printlist(reveListNodeMyself(SingleLinkedList.getHead()));
//        System.out.println(Arrays.toString(reversePrint(SingleLinkedList.getHead())));
        reversePrintRec(SingleLinkedList.getHead());
        System.out.println(list);

    }

    //双指针
    public static ListNode getKthFromEnd(ListNode head, int k) {
        ListNode former = head, latter = head;
        for (int i = 0; i < k; i++) {
            former = former.next;
        }
        while (former != null) {
            former = former.next;
            latter = latter.next;
        }
        return latter;
    }

    //单链表的反转 https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof/
//    https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof/solution/ru-guo-ni-kan-wan-ping-lun-he-ti-jie-huan-you-wen-/
    //递归
    public static ListNode reverseList(ListNode head) {
        /**
         * head = null 表示空链表
         * head.next == null 表示只有一个节点
         * 1-》2-》3-》4-》5
         */
        if (head == null || head.next == null ) {
            return head;
        }
        ListNode newhead = reverseList(head.next);

        head.next.next = head; //反转 指针指向 这儿就比较🐂🍺了
        // 第n层递归中 head.next = null 即 head = 5
        // 第n-1层递归中 head.next = 5，即 head = 4,那么 执行 head.next.next = head, 等价于 4.next.next = 4,等价于 5.next = 4, 完成了 反转。)
        head.next = null; //解决链表循环
        return newhead; //这儿返回newHead 是因为reverseList 方法的定义就是返回 反转后的头节点
    }
    //迭代
    public static ListNode reverseListNotRec(ListNode head) {
        ListNode newHead = null;
        while (head != null) {
            ListNode temp = head.next; //1、暂存下次循环head节点
            head.next = newHead;       //2、现有头节点指针指向 前一个节点
            newHead = head;            //3、新的头节点,每次将反转的节点作为新的节点，直到反转为最后一个节点，那么就是头节点了
            head = temp;               //4、循环调整下个节点
        }
        return newHead;
    }

    //迭代 这个更好理解
    public ListNode reverseListNotRec02(ListNode head) {
        //申请节点，pre和 cur，pre指向null
        ListNode pre = null;
        ListNode cur = head;
        ListNode tmp = null;
        while(cur!=null) {
            //记录当前节点的下一个节点
            tmp = cur.next;
            //然后将当前节点指向pre
            cur.next = pre;
            //pre和cur节点都前进一位
            pre = cur;
            cur = tmp;
        }
        return pre;
    }

    public static ListNode reveListNodeMyself(ListNode head) {

        ListNode temp = null;
        ListNode cur = head;
        ListNode pre = null; //pre 始终为最头上节点
        while (cur != null) {
            temp = cur.next;
            cur.next = pre;

            pre = cur;
            cur = temp;
        }
        return pre;

    }


    //反向打印链表 迭代
    public static int[] reversePrint(ListNode head) {
        Stack<Integer> s = new Stack<>();
        int c = 1;
        s.push(head.val);
        ListNode tem = head;
        while (tem.next != null) {
            s.push(tem.next.val);
            c++;
            tem = tem.next;
        }
        int[] result = new int[c];
        for (int i = 0; i < c; i++) {
            result[i] = s.pop();
        }
        return result;
    }

    //递归
    public static ArrayList<Integer> list = new ArrayList<>();
    public static void reversePrintRec(ListNode head) {
        if (head.next == null) {
            return;
        }
        reversePrintRec(head.next);
        list.add(head.val);
    }

}
