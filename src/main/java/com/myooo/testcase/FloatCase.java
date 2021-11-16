package com.myooo.testcase;

public class FloatCase {
    /**
     * 浮点数为什么会有精度问题？
     * https://wingsxdu.com/post/why/float-precision-problem/#gsc.tab=0
     * @param args
     */
    public static void main(String[] args) {
        float a = 20014999;
        double b = a;
        double c = 20014999;

        System.out.println("a=" + Long.toBinaryString(Float.floatToRawIntBits(a)));
        System.out.println("2000= " + Long.toBinaryString(20014999));
        System.out.println("1001100010110011110010111".length());
//        1001100010110011110010111 = 1 x 2^
        System.out.println("b=" + b);
        System.out.println("c=" + c);


//        System.out.println(a-b);
    }

}
