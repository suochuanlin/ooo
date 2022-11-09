package com.myooo.myooo.practice.lru;


public class Node {
    int key;
    int value;

    Node pre;
    Node next;


    public Node(int k, int v) {
        this.key = k;
        this.value = v;
    }

    public Node() {
    }
}
