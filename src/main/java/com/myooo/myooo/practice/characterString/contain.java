package com.myooo.myooo.practice.characterString;

public class contain {

    public static void main(String[] args) {
        int a[] = {8,5,4};
        int b[] = {1,3,8,5,4,7};
        System.out.println(solve(a,b));
    }

    public static int solve(int[] a, int[] b) {

        int m = a.length;
        int n = b.length;

        int i = 0, j = 0, result = 0;
        while (i < n && j < m) {
            if (a[i] == b[j]) {
                i++;
                if (i == a.length) {
                    break;
                }
            }
            result++;
            j++;
        }
        return result;
    }

}
