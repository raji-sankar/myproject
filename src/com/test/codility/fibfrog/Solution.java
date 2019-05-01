package com.test.codility.fibfrog;
/*
The Fibonacci sequence is defined using the following recursive formula:

    F(0) = 0
    F(1) = 1
    F(M) = F(M - 1) + F(M - 2) if M >= 2
A small frog wants to get to the other side of a river. The frog is initially located at one bank of the river (position −1) and wants to get to the other bank (position N). The frog can jump over any distance F(K), where F(K) is the K-th Fibonacci number. Luckily, there are many leaves on the river, and the frog can jump between the leaves, but only in the direction of the bank at position N.

The leaves on the river are represented in an array A consisting of N integers. Consecutive elements of array A represent consecutive positions from 0 to N − 1 on the river. Array A contains only 0s and/or 1s:

0 represents a position without a leaf;
1 represents a position containing a leaf.
The goal is to count the minimum number of jumps in which the frog can get to the other side of the river (from position −1 to position N). The frog can jump between positions −1 and N (the banks of the river) and every position containing a leaf.

For example, consider array A such that:

    A[0] = 0
    A[1] = 0
    A[2] = 0
    A[3] = 1
    A[4] = 1
    A[5] = 0
    A[6] = 1
    A[7] = 0
    A[8] = 0
    A[9] = 0
    A[10] = 0
The frog can make three jumps of length F(5) = 5, F(3) = 2 and F(5) = 5.

Write a function:

class Solution { public int solution(int[] A); }

that, given an array A consisting of N integers, returns the minimum number of jumps by which the frog can get to the other side of the river. If the frog cannot reach the other side of the river, the function should return −1.

For example, given:

    A[0] = 0
    A[1] = 0
    A[2] = 0
    A[3] = 1
    A[4] = 1
    A[5] = 0
    A[6] = 1
    A[7] = 0
    A[8] = 0
    A[9] = 0
    A[10] = 0
the function should return 3, as explained above.

Assume that:

N is an integer within the range [0..100,000];
each element of array A is an integer that can have one of the following values: 0, 1.
Complexity:

expected worst-case time complexity is O(N*log(N));
expected worst-case space complexity is O(N) (not counting the storage required for input arguments).
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public int fib(int n){
        if (n < 1){
            return n;
        }
        return fib(n -1) + fib(n - 2);
    }

    public int[] getFibUpToN(int n){
        final int FIB_LENGTH = 27;
        int[] fib = new int[FIB_LENGTH];
        fib[0] = 0;
        fib[1] = 1;
        for (int i=2; i<FIB_LENGTH; i++){
            fib[i]   = fib[i-1] + fib[i-2];
            if (fib[i] > n){
                return Arrays.copyOfRange(fib, 2, i);
            }
        }

        return fib;
    }

    public Integer[] getFib(int n){
        final int FIB_LENGTH = 27;
        Integer[] fib = new Integer[FIB_LENGTH];
        fib[0] = 0;
        fib[1] = 1;
        for (int i=2; i<FIB_LENGTH; i++){
            fib[i]   = fib[i-1] + fib[i-2];
            if (fib[i] > n){
                return Arrays.copyOfRange(fib, 2, i);
            }
        }

        return fib;
    }

    public int solution_mk(int[] A){
        // add dest to the input array
        int[] a = new int[A.length + 1];
        System.arraycopy(A, 0, a, 0, A.length);
        a[A.length] = 1;

        int[] fibs = getFibUpToN(a.length);

        int[] reachable = new int[a.length];
        Arrays.fill(reachable, -1);

        for (int jump: fibs){
            if (a[jump-1] == 1){
                reachable[jump-1] = 1;
            }
        }

        for (int i=0; i<a.length; i++){
            if (a[i] == 0 || reachable[i] > 0){
                continue;
            }

            int min_idx = -1;
            int min_value = 1000;

            for (int jump: fibs){
                int prev_idx = i - jump;
                if (prev_idx < 0) break;
                if (reachable[prev_idx] > 0 && min_value > reachable[prev_idx]){
                    min_value = reachable[prev_idx];
                    min_idx = prev_idx;
                }
            }
            if (min_idx != 1){
                reachable[i] = min_value + 1;
            }
        }

        return -1;
    }

    public int solution(int[] A) {

        System.out.format(Arrays.toString(A));
        if (A.length == 0){
            return 1;
        }

        //1. create an array of fib
        Integer[] fib = getFib(A.length + 1);

        List<Integer> fibs = Arrays.asList(fib);
        //2. Add dest node to the array
        int[] a = new int[A.length + 1];
        System.arraycopy(A, 0, a, 0, A.length);
        a[A.length] = 1;

        //3a. see if there is a way to get to dest node directly from the start
        if (fibs.indexOf(A.length) > -1){
            return 1;
        }

        //3b. Find all reachable nodes
        int[] reachable = new int[a.length];
        Arrays.fill(reachable, -1);

        for (int jump: fibs){
            if (a[jump-1] == 1){
                reachable[jump-1] = 1;
            }
        }








        List<Integer> jumps = new ArrayList<>();
        int current = 0;
        int count = 0;

        for(int i=0; i<A.length; i++){
            current++;
            if (A[i] == 1){
                if (fibs.indexOf(current) > -1){
                    System.out.println("i = " + i + " current = " + current);
                    jumps.add(current);
                    count++;
                    current = 0;
                }
            }
        }
        current++; //to indicate the final jump
        if (current > 0 && fibs.indexOf(current) > -1){
            jumps.add(current);
            count++;
        }

        System.out.println(jumps);
        return count > 0 ? count : -1;
    }

    public int brute_force_not_optimal_solution(int[] A) {
        //1. create an array of fib
        final int FIB_LENGTH = 20;
        Integer[] fib = new Integer[FIB_LENGTH];
        fib[0] = 0;
        fib[1] = 1;
        for (int i=2; i<FIB_LENGTH; i++){
            fib[i]   = fib[i-1] + fib[i-2];
        }

        List<Integer> fibs = Arrays.asList(fib);

        List<Integer> jumps = new ArrayList<>();
        int current = 0;
        int count = 0;

        for(int i=0; i<A.length; i++){
            current++;
            if (A[i] == 1){
                if (fibs.indexOf(current) > -1){
                    System.out.println("i = " + i + " current = " + current);
                    jumps.add(current);
                    count++;
                    current = 0;
                }
            }
        }
        current++; //to indicate the final jump
        if (current > 0 && fibs.indexOf(current) > -1){
            jumps.add(current);
            count++;
        }

        System.out.println(jumps);
        return count > 0 ? count : -1;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(new int[] {0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 0}));
//        System.out.println(sol.solution(new int[] {0, 0, 0}));
//        System.out.println(sol.solution(new int[] {0, 1, 0, 1, 1, 0, 1, 0, 0, 0, 0}));

        System.out.println(sol.solution(new int[] {}));
        System.out.println(sol.solution(new int[] {0}));
        System.out.println(sol.solution(new int[] {0, 0}));
        System.out.println(sol.solution(new int[] {1}));
        System.out.println(sol.solution(new int[] {1, 1, 1}));
    }
}
