package com.myooo.array;

public class jumpArray {

    public static void main(String[] args) {
        int[] array = new int[] {3,2,1,0,4};
        int[] array2 = new int[] {3,2,3};
        System.out.println(canJump(array));
    }
    public static boolean canJumpOut(int[] array) {
        if (array.length ==0) return false;
        int length = array.length;
        int temIndex = 0;
        for (int i = 0; i < length;i = temIndex) {
            if (array[i] == 0) return false;
            if (array[i] + i + 1 >= length) return true;
            temIndex = array[i];
        }
        return false;
    }

    public static boolean canJump(int[] arr) {
        int length = arr.length;
        int mostJump = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (i > mostJump) return false;
            mostJump = Math.max(mostJump, i + arr[i]);
            if (mostJump >= length - 1) return true;
        }
        return false;
    }
}
