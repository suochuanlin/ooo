package com.myooo.integerCache;

public class IntegerCache {

    public static void main(String[] args) {
        int a = 100;
        int b = 100;

        Integer c = 100;
        Integer d = 100;

        int e = 200;
        Integer g = 200;
        Integer h = 200;

        System.out.println(a == b); //true
        System.out.println(a == c); // true
        System.out.println(c == d); //true

        System.out.println(e == g); //true
        System.out.println(g == h); //false
        System.out.println(g.equals(h)); //true
    }
}
