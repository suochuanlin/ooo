package com.myooo.myooo.practice.thread.thread_stop;

public class MyRun {


    public static void main(String[] args) {

        try {
//            MyThread t = new MyThread();
//            t.start();
//            Thread.sleep(1000);
//            t.interrupt();
////            Thread.currentThread().interrupt();
//            System.out.println("mythread is interrupte " + t.isInterrupted());
//            System.out.println("debug");
            MyRun myRun = new MyRun();
            myRun.testName();
        } catch (InterruptedException e) {
            System.out.println("InterruptedException catch");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Exception catch");
            e.printStackTrace();
        }
    }


    public void testName() throws Exception {
        // 被中断的线程
//        final Thread t = new MyThread();
        final Thread t = new Thread(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println("InterruptedException eeeee");
                e.printStackTrace();
            }
        });
        // 去中断t的线程
        new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //当一个线程处于阻塞状态下（例如休眠）的情况下，调用了该线程的interrupt()方法，则会出现InterruptedException。
            t.interrupt();
        }).start();

        t.start();
        t.join();
    }
}
