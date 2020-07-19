package com.myooo.linkedList;

import java.util.HashMap;
import java.util.Map;

/**
 * 小知识
 * 8种基本引用类型
 *
 * 　　四种整数类型(byte、short、int、long)
 *
 * 　　两种浮点数类型(float、double)
 *
 * 　　一种字符类型(char)
 *
 * 　　一种布尔类型(boolean)
 *
 * 　　以及如String， final类型的数据类型时。
 *
 * 在方法调用时，属于值传递，在方法中改变了值之后，原始值不会改变。
 *
 * 除了以上之外的数据类型，如自定义的对象，Map，List之类的引用，都是地址引用。
 */
public class MergeTwoLists {
    //    https://leetcode-cn.com/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof
//    输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
    public static void main(String[] args) {
        testSite();
        SingleLinkedList.add(1);
        SingleLinkedList.add(2);
        SingleLinkedList.add(3);
        SingleLinkedList.add(4);
        ListNode newListNode = new ListNode(8);
        newListNode.next = new ListNode(9);

        SingleLinkedList.printlist(mergeTwoLists(SingleLinkedList.getHead(), newListNode));
    }
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//        dum的作用就是指向结果链表的头指针，而且dum初始化是一个链表的节点。cur是用于遍历链表的指针
//        cur 和 dum 都是引用，ListNode(0) 是节点实例。即 dum 引用 先指向节点 ListNode(0) ， cur 引用再指向 dum ~, cur 和 dum 保存的都是此节点的地址，本质上相同。
        ListNode dum = new ListNode(0), cur = dum;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = l1 == null ? l2 : l1;
        return dum.next; //去掉增加的头节点

    }

    public static void testSite() {
        Map<String,Integer> testMap = new HashMap<>(), siteMap = testMap;
        siteMap.put("siteA",1);
        siteMap.put("siteB",2);
        // put完毕以后都会有这个 testMap and siteMap都会有值。
    }
}
