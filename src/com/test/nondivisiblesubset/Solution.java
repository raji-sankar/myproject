package com.test.nondivisiblesubset;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by Raji on 6/4/2016.
 * Non-Divisible Subset
 * Given a set,S , of n  integers, print the size of a maximal subset, S+, of S where the sum of any  numbers in  are not evenly divisible by k.

 Input Format

 The first line contains 2 space-separated integers, n and k, respectively.
 The second line contains n space-separated integers (we'll refer to the ith value as ai) describing the unique values of the set.

 Constraints
 1 <= n <= 10e5
 1 <= k <= 100
 1 <= ai <= 10e9

 All of the given numbers are distinct.
 Output Format

 Print the size of the largest possible subset (S+).
 */
public class Solution {

    private static int nonDivisibleSubset(int n, int k, int[] a) {

        int num = 0;

        boolean isEven = (k % 2 == 0);

        int[] remainder = new int[k];

        for(int i = 0; i < n; i++){
            int p = a[i] % k;
            remainder[p] += 1;
        }

        int m = isEven ? k/2 : (k+1)/2;
        num += remainder[0] > 0 ? 1 : 0;
        if (isEven){
            num += remainder[m] > 0 ? 1 : 0;
        }
        for(int i = 1; i < m; i++){
            num += Math.max(remainder[i], remainder[k-i]);
        }
        return num;
    }

    public static void main(String[] args) {
        try {
            Scanner in;
            if (args!=null && args.length>0 && args[0].equals("-d")){

                in = new Scanner(new File(args[1]));

            } else {
                in = new Scanner(System.in);
            }
            int n = in.nextInt();
            int k = in.nextInt();
            int[] a = new int[n];
            for (int i=0; i <n; i++){
                a[i] = in.nextInt();
            }
            System.out.println(nonDivisibleSubset(n, k, a));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }


}
