package com.myooo.array;

import java.util.HashSet;
import java.util.Set;

public class FindRepeatNumber {

    public int findRepeatNumber(int[] nums) {
        int result = -1;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if(!set.add(nums[i])) {
                result = nums[i];
                break;
            }
        }
        return result;
    }



}
