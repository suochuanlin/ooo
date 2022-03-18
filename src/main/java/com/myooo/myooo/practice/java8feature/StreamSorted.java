package com.myooo.myooo.practice.java8feature;

import java.util.HashMap;
import java.util.Map;

public class StreamSorted {

    //根据value排序map，输出key
    public static void main(String[] args) {
        Map<String, Integer> sourceFeeMap = new HashMap<>();
        sourceFeeMap.put("1212", 1);
        sourceFeeMap.put("2324", 2);
        sourceFeeMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue()).forEachOrdered(e -> System.out.println(e.getKey()));
    }
}
