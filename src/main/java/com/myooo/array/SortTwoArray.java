package com.myooo.array;

import java.util.*;
import java.util.stream.Collectors;

public class SortTwoArray {


    public static void main(String[] args) {
        int a[] = {4,7,2,1,3};
        int b[] = {5,7,2,1,3};
        System.out.println(Arrays.toString(sortTwoArrayMap(a, b)));
    }


    /**
     * 两个数组、去重复、只取偶数,输出数组
     * @param a 数据a
     * @param b 数组b
     * @return
     */
    public static Integer[] sortTwoArray(int[] a, int[] b) {

        Integer[] result = new Integer[]{};
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < a.length; i++) {
            if (a[i] % 2 == 0) {
                set.add(a[i]);
            }
        }
        for (int i = 0; i < b.length; i++) {
            if (b[i] % 2 == 0) {
                set.add(b[i]);
            }
        }

        return set.stream().sorted((o1, o2) -> o2-o1).collect(Collectors.toList()).toArray(result);
    }

    /**
     * map实现
     * @param a
     * @param b
     * @return
     */
    public static Integer[] sortTwoArrayMap(int[] a, int[] b) {
        Map<Integer, Integer> amap = new HashMap<>();
        Integer[] result = new Integer[]{};
        int firstMaxIndex = 0;
        for (int i = 0; i < a.length; i++) {
            if (!amap.containsKey(a[i]) && (a[i] % 2 == 0)) {
                amap.put(a[i], i);
                firstMaxIndex++;
            }
        }

        for (int i = 0; i < b.length; i++) {
            if (!amap.containsKey(b[i]) && b[i] % 2 == 0){
                amap.put(b[i], firstMaxIndex++);
            }
        }
        return amap.keySet().stream().sorted((o1, o2) -> o2 - o1).collect(Collectors.toList()).toArray(result);
    }

}
