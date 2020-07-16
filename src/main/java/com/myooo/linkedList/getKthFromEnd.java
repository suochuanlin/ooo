package com.myooo.linkedList;

import com.alibaba.fastjson.JSONObject;

public class getKthFromEnd {

    public static void main(String[] args) {
        SingleLinkedList.add(5);
        SingleLinkedList.add(4);
        SingleLinkedList.add(3);
        SingleLinkedList.add(2);
        SingleLinkedList.printlist(SingleLinkedList.getHead());
        Node head = SingleLinkedList.getHead();
        System.out.println("------分割线------");
        SingleLinkedList.printlist(getKthFromEnd(head,3));
    }

    //双指针
    public static Node getKthFromEnd(Node head, int k) {
        Node former = head, latter = head;
        for (int i = 0; i < k; i++) {
            former = former.next;
        }
        while (former != null) {
            former = former.next;
            latter = latter.next;
        }
        return latter;
    }

}
