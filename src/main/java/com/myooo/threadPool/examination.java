package com.myooo.threadPool;

import java.util.*;
import java.util.concurrent.*;

public class examination {
    public static void main(String[] args) {
        ThreadPoolExecutor pool = new ThreadPoolExecutor(10, 10, 300, TimeUnit.MILLISECONDS, new LinkedBlockingDeque<>());
        List<Integer> list = new CopyOnWriteArrayList<>();
        long count = 0;
        for (int i = 0; i < 10; i++) {
            try {
                pool.submit(new MyThread(1 + i * 1000, i * 1000 + 1000, list)).get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        for (int num : list) {
            count += num;
        }
        System.out.println(count);
        int nums = 0;
        for (int i = 0; i <= 10000; i++) {
            nums += i;
        }
        System.out.println(nums);
    }

    static class MyThread implements Runnable {
        int start = 0;
        int end = 0;
        List<Integer> list;

        MyThread(int start, int end, List<Integer> list) {
            this.start = start;
            this.end = end;
            this.list = list;
        }

        @Override
        public void run() {
            int val = 0;
            for (int i = start; i <= end; i++) {
                val += i;
            }
            list.add(val);
        }
    }

}
