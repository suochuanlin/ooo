package com.myooo.myooo.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class SumNumbers {

    private static ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(4, 4, 10, TimeUnit.SECONDS, new LinkedBlockingQueue<>());


    public static void main(String[] args) throws ExecutionException, InterruptedException {


        List<Integer> nums = new ArrayList<>();
        for (int i = 0; i < 1000000; i++) {
            nums.add(i);
        }


        //计算方式1
        long start = System.currentTimeMillis();
        Integer r2 = nums.parallelStream().reduce(Integer::sum).get();
        long consumeTime1 = System.currentTimeMillis() - start;

        System.out.println("算法1 result = " + r2 + "，耗时 " + consumeTime1);

        //方式二
        long start2 = System.currentTimeMillis();

        Future<Integer> submit1 = threadPoolExecutor.submit(new Task(0, 250000));
        Future<Integer> submit2 = threadPoolExecutor.submit(new Task(250000, 500000));
        Future<Integer> submit3 = threadPoolExecutor.submit(new Task(500000, 750000));
        Future<Integer> submit4 = threadPoolExecutor.submit(new Task(750000, 1000001));
        int i = submit1.get() + submit2.get() + submit3.get() + submit4.get();
        long consumeTime2 = System.currentTimeMillis() - start2;
        System.out.println("算法2 result = " + i + "，耗时 " + consumeTime2);

    }



    static class Task implements Callable<Integer> {
        private int start;
        private int end;

        public Task(int start, int end) {
            this.start = start;
            this.end = end;
        }


        @Override
        public Integer call() throws Exception {
            int sum = 0;

            for (int i = start; i < end; i++) {
                sum += i;
            }
            return sum;
        }
    }
}
