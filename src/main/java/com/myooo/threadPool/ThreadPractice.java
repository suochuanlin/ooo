package com.myooo.threadPool;

public class ThreadPractice {

    public static void main(String[] args) {
        circlePrintf();
    }

    public static void circlePrintf() {
        //thread1
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程1 打印11111111");
            }
        });
        thread1.setName("线程1");

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程2 打印2222222");
            }
        });
        thread2.setName("线程2");

        while (true) {
            thread1.start();
            thread2.start();
        }
    }

}
