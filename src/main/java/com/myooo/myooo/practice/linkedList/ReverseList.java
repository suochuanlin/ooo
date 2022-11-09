package com.myooo.myooo.practice.linkedList;

/**
 * <a href="https://leetcode.cn/problems/reverse-linked-list/">...</a>
 */
public class ReverseList {

    public static void main(String[] args) {
        SingleLinkedList.add(1);
        SingleLinkedList.add(2);
        SingleLinkedList.add(3);
        SingleLinkedList.add(4);
        SingleLinkedList.add(5);
        reverseList(SingleLinkedList.getHead());
        SingleLinkedList.printlist(SingleLinkedList.getHead());
    }

    public static ListNode reverseList(ListNode head) {
        if (head.next == null) {
            return head;
        }

        ListNode newHead = reverseList(head.next);

        head.next.next = head;
        head.next = null;
        return newHead;
    }

}
