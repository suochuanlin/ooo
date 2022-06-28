package com.myooo.myooo.practice.threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class DeadLock {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        // 任务A
        executorService.submit(() -> {
            System.out.println("线程id" + Thread.currentThread().getId() + ", 开始.....");
            // 任务B
            Future<String> submit = executorService.submit(() -> " one things");
            System.out.println(Thread.currentThread().getId() + ", 结束。。。" + submit.get());
            return submit.get();
        });
        // 如果是线程数量小 该线程会被饥饿
        executorService.execute(() -> {
            System.out.println("其他任务");
        });
    }

}
