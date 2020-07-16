package com.myooo.linkedList;

public class SingleLinkedList {

    private static ListNode head = new ListNode(0);

    //增加节点
    public static void add(int value) {
        ListNode newListNode = new ListNode(value);

        ListNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newListNode;
    }
    //显示链表
    public static void printlist(ListNode head) {
        if (head == null) {
            System.out.println("空链表");
        }
        ListNode temp = head;
        while (temp.next != null) {
            System.out.println("节点数值" + temp.value);
            temp = temp.next;
        }
    }

    public static ListNode getHead() {
        return head;
    }
}
