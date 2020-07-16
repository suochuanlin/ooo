package com.myooo.linkedList;

public class SingleLinkedList {

    private static Node head = new Node(0);

    //增加节点
    public static void add(int value) {
        Node newNode = new Node(value);

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }
    //显示链表
    public static void printlist(Node head) {
        if (head == null) {
            System.out.println("空链表");
        }
        Node temp = head;
        while (temp.next != null) {
            System.out.println("节点数值" + temp.value);
            temp = temp.next;
        }
    }

    public static Node getHead() {
        return head;
    }
}
