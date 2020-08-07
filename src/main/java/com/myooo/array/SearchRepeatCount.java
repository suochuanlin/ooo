package com.myooo.array;

public class SearchRepeatCount {

    public static void main(String[] args) {
        SearchRepeatCount instance = new SearchRepeatCount();
        int[] nums = new int[]{5,7,7,8,8,10};
        System.out.println(instance.search2(nums,8));
    }

    public int search(int[] nums, int target) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                count++;
            }
            if (nums[i] > target) {
                break;
            }
        }
        return count;
    }

    public int search2(int[] nums, int target) {
        int count = 0;
        int length = nums.length;
        int strat = 0;
        int end = length - 1;
        while (end > strat) {
            int current = (strat + end) / 2;
            if (target > nums[current] ) {
                strat = current;
            } else if (target < nums[current]) {
                end = current;
            } else if (target == nums[current]) {
                int right = current;
                int left = current;
                //操作先往右
                while (nums[right] == target) {
                    count++;
                    right++;
                }
                //再往左边
                while (nums[left] == target) {
                    count++;
                    left--;
                }
                count--;
                break;
            }
        }
        return count;
    }
}
