package com.myooo.array;

public class FindMissingNumber {

    public static void main(String[] args) {
        FindMissingNumber instance = new FindMissingNumber();
        int[] array = new int[] {0,1,2,3,4,5,6,7,9};

        System.out.println(instance.missingNumber(array));
    }

    public int missingNumber(int[] nums) {
        int startIdx = 0;
        int endIdx = nums.length - 1;
        while (startIdx <= endIdx) {
            int currentIndx = (startIdx + endIdx) / 2;
            if (currentIndx == nums[currentIndx]) {
                startIdx = currentIndx + 1;
            }
            if (currentIndx != nums[currentIndx]) {
                endIdx = currentIndx - 1;
            }
        }
        return startIdx;
    }
}
