package com.test.nondivisiblesubset;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Raji on 5/29/2016.
 */
public class Solution {

    public static int nonDivisibleSubset(int n, int k, int[] a){
        //largest subset has n-1 elements

        boolean[] in_subset = new boolean[n];
        for (int i=0; i < n; i++){
            Arrays.fill(in_subset, true);
            in_subset[i] = false;
            int[] subset = new int[n-1];
            int j = 0;
            int m = 0;
            while(j < n){
                if (in_subset[j]) {
                    subset[m] = a[j];
                    m++;
                    j++;
                } else {
                    j++;
                }

            }
            if (checkSubsetNonDivisible(subset.length, k, subset)){
                return subset.length;
            }
        }
        return 0;
    }

    public static boolean checkSubsetNonDivisible(int n, int k, int[] a){
        for (int i=0; i < n; i++){
            for(int j= i+1; j < n; j++ ){
                if ((a[i] + a[j]) % k == 0)
                    return false;
            }
        }
        return true;
    }



    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] a = new int[n];
        for (int i=0; i <n; i++){
            a[i] = in.nextInt();
        }
        System.out.println(nonDivisibleSubset(n, k, a));

    }

}
