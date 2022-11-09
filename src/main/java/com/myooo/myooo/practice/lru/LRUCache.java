package com.myooo.myooo.practice.lru;

import java.util.*;

/**
 * 146. LRU 缓存
 * 请你设计并实现一个满足  LRU (最近最少使用) 缓存 约束的数据结构。
 * 实现 LRUCache 类：
 * LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；
 * 如果不存在，则向缓存中插入该组 key-value 。如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。
 * 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。
 *
 *
 *
 * 示例：
 *
 * 输入
 * ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
 * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
 * 输出
 * [null, null, null, 1, null, -1, null, -1, 3, 4]
 *
 * 解释
 * LRUCache lRUCache = new LRUCache(2);
 * lRUCache.put(1, 1); // 缓存是 {1=1}
 * lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
 * lRUCache.get(1);    // 返回 1
 * lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
 * lRUCache.get(2);    // 返回 -1 (未找到)
 * lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
 * lRUCache.get(1);    // 返回 -1 (未找到)
 * lRUCache.get(3);    // 返回 3
 * lRUCache.get(4);    // 返回 4
 *
 *
 * 提示：
 *
 * 1 <= capacity <= 3000
 * 0 <= key <= 10000
 * 0 <= value <= 105
 * 最多调用 2 * 105 次 get 和 put
 *
 *
 * class LRUCache {
 *
 *     public LRUCache(int capacity) {
 *
 *     }
 *
 *     public int get(int key) {
 *
 *     }
 *
 *     public void put(int key, int value) {
 *
 *     }
 * }
 *
 *
 *  * Your LRUCache object will be instantiated and called as such:
 *  * LRUCache obj = new LRUCache(capacity);
 *  * int param_1 = obj.get(key);
 *  * obj.put(key,value);
 *
 */

public class LRUCache {

    private final int cacheCapcity;
    private int currentSize;

    public HashMap<Integer, Node> getCachesMap() {
        return cachesMap;
    }

    private HashMap<Integer, Node> cachesMap;
    //伪节点作为头跟尾
    private Node head;
    private Node tail;


    public LRUCache(int size) {
        this.currentSize = 0;
        this.cacheCapcity = size;
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.pre = head;
        cachesMap = new HashMap<>(size);
    }

    public void put(int k, int v) {
        Node valueNode = cachesMap.get(k);
        if (valueNode == null) {
            Node node = new Node(k, v);
            addToHead(node);
            cachesMap.put(k, node);
            currentSize++;
            if (currentSize > cacheCapcity) {
                //删除尾节点
                Node tail = removeTail();
                cachesMap.remove(tail.key);
                currentSize--;
            }
        } else {
            moveToHead(valueNode);
        }

    }

    public int get(int k) {
        Node node = cachesMap.get(k);
        if (node == null) {
            return  -1;
        }
        moveToHead(node);
        return node.value;
    }

    public void addToHead(Node node) {
        node.next = head.next;
        node.pre = head;

        head.next.pre = node;
        head.next = node;

    }

    public void removeNode(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    public void moveToHead(Node node) {
        //移除当前节点
        removeNode(node);
        //把节点插入到head
        addToHead(node);
    }

    public Node removeTail() {
        Node last = tail.pre;
        removeNode(last);
        return last;
    }


    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // 缓存是 {1=1}
        printLinkedNode(lRUCache.head);
        printCacheMap(lRUCache.getCachesMap());
        lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
        printLinkedNode(lRUCache.head);
        printCacheMap(lRUCache.getCachesMap());
        lRUCache.get(1);    // 返回 1
        printLinkedNode(lRUCache.head);
        printCacheMap(lRUCache.getCachesMap());
        lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        printLinkedNode(lRUCache.head);
        printCacheMap(lRUCache.getCachesMap());
        lRUCache.get(2);    // 返回 -1 (未找到)
        printLinkedNode(lRUCache.head);
        printCacheMap(lRUCache.getCachesMap());
        lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        printLinkedNode(lRUCache.head);
        printCacheMap(lRUCache.getCachesMap());
        lRUCache.get(1);    // 返回 -1 (未找到)
        printLinkedNode(lRUCache.head);
        printCacheMap(lRUCache.getCachesMap());
        lRUCache.get(4);    // 返回 4
        printLinkedNode(lRUCache.head);
        printCacheMap(lRUCache.getCachesMap());
        lRUCache.get(3);    // 返回 3
        printLinkedNode(lRUCache.head);
        printCacheMap(lRUCache.getCachesMap());
    }

    private static void printLinkedNode(Node head) {
        List<Integer> list = new ArrayList<>();

        while (head.next != null) {
            list.add(head.value);
            head = head.next;
        }
        System.out.println(Arrays.toString(list.toArray()));
    }

    private static void printCacheMap(HashMap<Integer, Node> map) {

        for (Map.Entry<Integer, Node> entry : map.entrySet()) {
            Integer key = entry.getKey();
            int value = entry.getValue().value;
            System.out.println("Key: " + key + " value: " + value);
        }
    }



}
