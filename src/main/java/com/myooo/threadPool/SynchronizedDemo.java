package com.myooo.threadPool;

import java.util.concurrent.atomic.AtomicInteger;

public class SynchronizedDemo {

    public static void main(String[] args) {
        synchronized (SynchronizedDemo.class) {
        }
        method();
    }

    private static void method() {
        AtomicInteger c = new AtomicInteger(10);
        AtomicInteger d = new AtomicInteger(11);
        c.set(11);

        System.out.println(c.equals(d));
    }
}
