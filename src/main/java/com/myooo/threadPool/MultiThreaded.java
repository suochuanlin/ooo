package com.myooo.threadPool;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class MultiThreaded {

    public static ThreadPoolExecutor workPool = new ThreadPoolExecutor(10, 15, 30, TimeUnit.SECONDS, new ArrayBlockingQueue<>(15), new ThreadPoolExecutor.DiscardPolicy());


    private static void calculateCount(int start) throws ExecutionException, InterruptedException {

        for (int i = 0; i < 10; i++) {
            Future future = workPool.submit(new CalCulateCla(start));
            int result = (int) future.get();
            System.out.println(result);
        }
    }


    public static class CalCulateCla implements Callable {

        private AtomicInteger a;

        public CalCulateCla(int defalut) {
            this.a = new AtomicInteger(defalut);
        }

        @Override
        public Object call() throws Exception {
            if (a.get() == 1000) {
                return a.get();
            } else {
                a = new AtomicInteger(a.get() + 1);
            }
            return a.get();
        }
    }




    public static void main(String[] args) throws ExecutionException, InterruptedException {
        calculateCount(1);
    }
}
