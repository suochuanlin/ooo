package com.myooo.myooo.practice.lru;

import com.myooo.myooo.practice.designPatterns.commandPattern.Light;

import java.util.*;

/**
 * <a href="https://leetcode.cn/problems/lru-cache/solution/lruhuan-cun-ji-zhi-by-leetcode-solution/">...</a>
 */
public class LRUCache_Second {

    static class DLinkedNode {
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;

        public DLinkedNode() {
        }

        public DLinkedNode(int _key, int _value) {
            key = _key;
            value = _value;
        }
    }

    private final Map<Integer, DLinkedNode> cache = new HashMap<>();
    private int currentSize;
    private final int capacity;
    private final DLinkedNode head;
    private final DLinkedNode tail;

    public LRUCache_Second(int capacity) {
        this.currentSize = 0;
        this.capacity = capacity;
        // 使用伪头部和伪尾部节点
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            DLinkedNode newNode = new DLinkedNode(key, value);
            cache.put(key, newNode);
            // 添加至双向链表的头部
            addToHead(newNode);
            ++currentSize;
            if (currentSize > capacity) {
                // 如果超出容量，删除双向链表的尾部节点
                DLinkedNode tail = removeTail();
                // 删除哈希表中对应的项
                cache.remove(tail.key);
                --currentSize;
            }
        } else {
            // 如果 key 存在，先通过哈希表定位，再修改 value，并移到头部
            node.value = value;
            moveToHead(node);
        }
    }

    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
        // 如果 key 存在，先通过哈希表定位，再移到头部
        moveToHead(node);
        return node.value;
    }

    private void moveToHead(DLinkedNode node) {
        removeNode(node);
        addToHead(node);
    }

    private DLinkedNode removeTail() {
        DLinkedNode res = tail.prev;
        removeNode(res);
        return res;
    }

    private void addToHead(DLinkedNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(DLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public static void main(String[] args) {
        LRUCache_Second lRUCache = new LRUCache_Second(2);
        lRUCache.put(1, 1); // 缓存是 {1=1}
        printLinkedNode(lRUCache.head);
        lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
        printLinkedNode(lRUCache.head);
        lRUCache.get(1);    // 返回 1
        printLinkedNode(lRUCache.head);
        lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        printLinkedNode(lRUCache.head);
        lRUCache.get(2);    // 返回 -1 (未找到)
        printLinkedNode(lRUCache.head);
        lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        printLinkedNode(lRUCache.head);
        lRUCache.get(1);    // 返回 -1 (未找到)
        printLinkedNode(lRUCache.head);
        lRUCache.get(4);    // 返回 4
        printLinkedNode(lRUCache.head);
        lRUCache.get(3);    // 返回 3
        printLinkedNode(lRUCache.head);
    }

    private static void printLinkedNode(DLinkedNode head) {
        List<Integer> list = new ArrayList<>();

        while (head.next != null) {
            list.add(head.value);
            head = head.next;
        }
        System.out.println(Arrays.toString(list.toArray()));
    }

}

