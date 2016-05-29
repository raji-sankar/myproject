package com.test.taumbday;

import java.util.Scanner;

/**
 * Created by Raji on 5/25/2016.
 */
public class Solution {

    public static long minCost(long b, long w, long x, long y, long z){
        if (x == y){
            return b*x + w*y;
        } else if (x > y && (x-y) > z){
            return b*y + w*y + b*z;
        } else if (y > x && (y -x) > z){
            return b*x + w*x + w*z;
        } else {
            return b*x + w*y;
        }

    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            long b = in.nextLong();
            long w = in.nextLong();
            long x = in.nextLong();
            long y = in.nextLong();
            long z = in.nextLong();
            System.out.println(Solution.minCost(b, w, x, y, z));
        }
    }
}
