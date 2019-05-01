package com.test.divisiblesumpairs;

import java.util.Scanner;

/**
 * Created by Raji on 5/29/2016.
 */
public class Solution {

    public static int countPairs(int n, int k, int[] a){

        int count = 0;
        for (int i=0; i < n; i++){
            for(int j= i+1; j < n; j++ ){
                if ((a[i] + a[j]) % k == 0)
                    count += 1;
            }
        }

        return count;

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] a = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        System.out.println(countPairs(n, k, a));
    }
}
