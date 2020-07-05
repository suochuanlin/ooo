package com.myooo.lru;

import java.util.HashMap;

public class LRUCache<K,V> {

    private int cacheCapcity;
    private int currentSize;
    private HashMap<K, Node<K, V>> cachesMap;
    private Node first;
    private Node last;

    public LRUCache(int size) {
        this.currentSize = 0;
        this.cacheCapcity = size;
        cachesMap = new HashMap<>(size);
    }

    public void put(K k, V v) {
        Node<K, V> node = cachesMap.get(k);
        if (node == null) {
            if (cachesMap.size() >= cacheCapcity) {
                cachesMap.remove(last.key);
            }
            //todo 如果map中无，则插入到链表头
            node = new Node<>(k, v);
        }
        cachesMap.put(k, node); //放入map

    }


}
