package com.myooo.myooo.service;

import lombok.SneakyThrows;

import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class ForkJoinPoolDemo {

    public static void main(String[] args) {
        ThreadPoolExecutor pool1 = new ThreadPoolExecutor(4,
                4,
                0,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(1000),
                new ThreadPoolExecutor.CallerRunsPolicy());

//        ThreadPoolExecutor pool1 = new ThreadPoolExecutor(4,
//                4,
//                0,
//                TimeUnit.SECONDS,
//                new ArrayBlockingQueue<>(1000),
//                new ThreadPoolExecutor.CallerRunsPolicy());
        //建立一个有4个并行线程的fork join pool
        ForkJoinPool pool2 = new ForkJoinPool(4);

        Task task1 = new Task("task1", 0, pool1);
        Task task2 = new Task("task2", 1, pool1);
        Task task3 = new Task("task3", 1, pool1);
        Task task4 = new Task("task4", 1, pool1);
        Task task5 = new Task("task5", 5, pool1);
        Task task6 = new Task("task6", 5, pool1);
        Task task7 = new Task("task7", 1, pool1);
        Task task8 = new Task("task8", 1, pool1);
        Task task9 = new Task("task9", 1, pool1);


        task1.dependentTasks.add(task2);
        task1.dependentTasks.add(task3);
        task1.dependentTasks.add(task4);
        task1.dependentTasks.add(task5);
        task1.dependentTasks.add(task6);
        task2.dependentTasks.add(task7);
        task3.dependentTasks.add(task8);
        task4.dependentTasks.add(task9);

        System.out.println("start time: " + new Date());
        pool1.submit(task1);
//        pool2.invoke(task1);

    }
}

//class Task extends RecursiveTask<String> {
//    String name;
//    ThreadPoolExecutor pool;
//    long execTime;
//    List<Task> dependentTasks = new ArrayList<>();
//
//
//    public Task(String name, long execTime, ThreadPoolExecutor pool) {
//        this.name = name;
//        this.execTime = execTime;
//        this.pool = pool;
//    }
//
//    //compute方法主要逻辑就是达到拆分条件就平均拆分任务，待切分任务小于阈值时，停止切分，去执行任务。对应例子中的consumer函数式接口。
//    //拆分后的任务会提交到队列中，由线程获取任务后继续调用 compute() 来判断拆分还是执行。
//    @SneakyThrows
//    @Override
//    protected String compute() {
//        for (Task dependentTask : dependentTasks) {
//            //将子任务提交到线程池ForkJoinPool
//            dependentTask.fork();
//        }
//        for (Task dependentTask : dependentTasks) {
//            //Join汇总 join方法用于阻塞获取结果
//            dependentTask.join();
//        }
//        Thread.sleep(execTime * 1000);
//        System.out.println("time: " + new Date() + ", taskName:" + name + ", thread:" + Thread.currentThread());
//        return "xxx";
//    }
//}

class Task implements Callable<String> {
    String name;
    ThreadPoolExecutor pool;
    long execTime;
    List<Task> dependentTasks = new ArrayList<>();


    public Task(String name, long execTime, ThreadPoolExecutor pool) {
        this.name = name;
        this.execTime = execTime;
        this.pool = pool;
    }

    @Override
    public String call() throws Exception {
        List<Future<String>> futures = dependentTasks.stream()
                .map(task -> pool.submit(task))
                .collect(Collectors.toList());

        for (Future<String> future : futures) {
            future.get();
        }
        Thread.sleep(execTime * 1000);
        System.out.println("time: " + new Date() + ", taskName:" + name + ", thread:" + Thread.currentThread());
        return "time" + new Date() + ", taskName:" + name;
    }
}

// [100w] 求和 4 0-1/4 1/4-1/2 ...
// 100w === 0-50w 50w-100w == 0-25w 25-50 50-75 75-100

