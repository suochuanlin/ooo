package com.myooo.lru;


public class Node<K, V> {
    Object key;
    Object value;

    Node pre;
    Node next;

    public Node(K k, V v) {
        this.key = k;
        this.value = v;
    }
}
