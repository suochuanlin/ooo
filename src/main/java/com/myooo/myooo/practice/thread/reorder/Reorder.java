package com.myooo.myooo.practice.thread.reorder;

/**
 * https://blog.csdn.net/pzxwhc/article/details/48984209
 * 重排序简单讲解
 *
 */
public class Reorder {


    static int x = 0, y = 0;
    static int a = 0, b = 0;


    public static void main(String[] args) throws InterruptedException {
        Thread one = new Thread(() -> {
            a = 1;
            x = b;
        });

        Thread other = new Thread(() -> {
            b = 1;
            y = a;
        });

        one.start();
        other.start();
        one.join();
        other.join();
        System.out.println("(" + x + "," + y + ")");
    }
    /**
     * JMM是通过各种操作来定义的，包括对变量的读/写操作，监视器的加锁和释放操作，以及线程的启动和合并操作。
     * Happens-Before的规则: （JMM为程序中所有的操作定义了一个偏序关系）
     * 1、程序顺序原则。一个线程内要按照代码的顺序执行，保证语义的串行性
     * 2、锁规则，解锁操作必须发生在对同一个锁的加锁操作之前
     * 3、volatile规则。对volatile修饰的变量的写操作发生在volatile变量的读操作之前。访问volatile的变量时候强制从主内存中进行读取，volatile修饰的变量被修改之后会被强制的刷新到主内存中。所以说volatile修饰的变量保证了可见性
     * 4、线程启动规则。线程的start()方法最先执行，线程A在线程B执行start()方法之前对共享变量的修改对线程B可见
     * 5、线程终止规则。线程的所有操作优于线程的终结，Thread.join()方法的作用是等待当前线程终止，线程B在终止之前修改了共享变量，执行完成后，线程B对共享变量的修改将对线程A可见
     * 6、线程中断规则。对线程interrupt中断方法的调用发生在被中断的线程检测到中断事件的发生之前
     * 7、对象终结规则。对象的构造函数执行完成先于finalize()方法
     * 8、传递性。线程A生在线程B之前，线程B发生在线程C之前，则线程A发生在线程C之前
     *
     *
     * 解决问题：数据竞争问题。当一个变量被多个线程读取并且至少被一个线程写入时，如果读操作和写操作之间没有依照 Happens-Before 来排序，那么就会产生数据竞争问题。
     * 偏序关系：
     * 设R是集合A上的一个二元关系，若R满足：
     * Ⅰ 自反性：对任意x∈A，有xRx；
     * Ⅱ 反对称性（即反对称关系）：对任意x,y∈A，若xRy，且yRx，则x=y；
     * Ⅲ 传递性：对任意x, y,z∈A，若xRy，且yRz，则xRz。 [1]
     * 则称R为A上的偏序关系，通常记作≼。注意这里的≼不必是指一般意义上的“小于或等于”。
     * 若然有x≼y，我们也说x排在y前面（x precedes y）。
     */

    /**
     * 类库中 Happens-Before排序包括：
     * Happens-Before排序包括：
     *
     * 1、将一个元素放入一个线程安全容器的操作将在另一个线程从该容器中获得这个元素的操作之前执行
     * 2、在CountDownLatch上的倒数操作将在线程从闭锁上的await方法返回之前执行
     * 3、释放Semaphore许可的操作将在从该Semaphore上获得一个许可之前执行
     * 4、Future表示的任务的所有操作将在从Future.get中返回之前执行
     * 5、向Executor提交一个Runnable或Callable的操作将在任务开始执行之前执行
     * 6、一个线程到达CyclicBarrier或Exchange的操作将在其他到达该栅栏或交换点的线程被释放之前执行。如果CyclicBarrier使用一个栅栏操作，那么到达栅栏的操作将在栅栏操作之前执行，而栅栏操作又会在线程从栅栏中释放之前执行
     */




}
