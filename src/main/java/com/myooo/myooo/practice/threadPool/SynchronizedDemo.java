package com.myooo.myooo.practice.threadPool;

import java.lang.ref.WeakReference;

public class SynchronizedDemo {

    private static Entry[] table;

    static class Entry extends WeakReference<Integer> {
        /** The value associated with this ThreadLocal. */
        Object value;

        Entry(Integer k, Object v) {
            super(k);
            value = v;
        }
    }

    public static void main(String[] args) {
        synchronized (SynchronizedDemo.class) {
            method();
        }
        a();
    }

    private static void method() {
        int c= 10;
        int d=10;
//        AtomicInteger c = new AtomicInteger(10);
//        AtomicInteger d = new AtomicInteger(11);
//        c.set(11);

        System.out.println(c==d);
    }


    private static void a() {
        table = new Entry[4];
        Entry[] tab = table;
        tab[0] = new Entry(0,0);
        tab[1] = new Entry(1,1);
        int i = 0;
        for (i = nextIndex(i,4);
             tab[i] != null;
             i = nextIndex(i,4)) {
            Entry a = tab[i];
            System.out.println(a.get() + " + " + a.value);
        }
    }

    private static int nextIndex(int i, int len) {
        return ((i + 1 < len) ? i + 1 : 0);
    }
}
