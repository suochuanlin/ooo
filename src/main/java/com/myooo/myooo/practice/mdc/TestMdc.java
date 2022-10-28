package com.myooo.myooo.practice.mdc;

import ch.qos.logback.classic.util.LogbackMDCAdapter;

import java.util.Map;

public class TestMdc {
    public static void main(String[] args) {
        testLogbackMDCAdapter();
    }


    public static void testLogbackMDCAdapter() {
        LogbackMDCAdapter mdcAdapter = new LogbackMDCAdapter();
        // 第一次操作put
        mdcAdapter.put("a", "123");
        // 注意: 方法名虽然看着像在做copy map，实际没有记录成copy map操作
        System.out.println(mdcAdapter.getCopyOfContextMap());

        // 第二次操作 copy map（这个方法里面里面才真正记录了 copy map操作)
        Map<String, String> snapshot = mdcAdapter.getPropertyMap();
        System.out.println("snapshot: " + snapshot);

        // 第三次操作put
        mdcAdapter.put("b", "456");
        System.out.println(mdcAdapter.getCopyOfContextMap());
        System.out.println("snapshot: " + mdcAdapter.getPropertyMap());
//
//        mdcAdapter.put("c", "789");
//        System.out.println(mdcAdapter.getCopyOfContextMap());
//        Map<String, String> snapshot2 = mdcAdapter.getPropertyMap();
//        System.out.println("snapshot2: " + snapshot2);

    }
}
