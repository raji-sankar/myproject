package com.test;

/**
 * Created by Raji on 5/29/2016.
 */
public class TwoEntrances {

    public int count(int[] a, int[] b, int s1, int s2){
        return 0;
    }

    public static void main(String[] args) {
        TwoEntrances twoEntrances = new TwoEntrances();
        int[] a = {0, 1, 2};
        int[] b = {1, 2, 3};
        int s1 = 0;
        int s2 = 1;
        int x = twoEntrances.count(a, b, s1, s2);
        System.out.println("x = " + Integer.toString(x));
    }
}
