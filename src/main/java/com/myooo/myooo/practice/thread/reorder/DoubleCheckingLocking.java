package com.myooo.myooo.practice.thread.reorder;

public class DoubleCheckingLocking {

    /**
     * Happens-Before规则:
     * volatile规则。对volatile修饰的变量的写操作发生在volatile变量的读操作之前。访问volatile的变量时候强制从主内存中进行读取，volatile修饰的变量被修改之后会被强制的刷新到主内存中。所以说volatile修饰的变量保证了可见性
     */
    private static volatile DoubleCheckingLocking instance;

    public static DoubleCheckingLocking getInstance() {
        if (instance == null) {
            synchronized (DoubleCheckingLocking.class) {
                if (instance == null)
                    instance = new DoubleCheckingLocking();
            }
        }
        return instance;
    }


}
