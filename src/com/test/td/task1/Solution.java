package com.test.td.task1;

/*
YOu're given an implementation of a function

which accepts as input a non-empty 0 indexed array A consisting of N integers.

The function works slowly on large input data and the goal is to optimize it so
as to achieve better time and/or space complexity. The optimized function should return
the same result as the given implementation for every input that satisfies the assumptions.

For example, given an array {4, 6, 2, 2, 6, 6, 1}, the function returns 4.

Also, given an array A such that A[0] = 2, A[50000] = 2, A[K] = 2 for each K (0 <= K <= 50000), the given implementation
is 2, but the function would return 50,000

Assume that
1. N is an integer with range [1..100,000]
2. each element of array A is an integer within the range [1..N]

Complexity
1. expected worst-case time complexity is O(N)
2. expected time complexity is O(N)
 */

import java.util.*;

public class Solution {

    int given_solution(int[] A) {
        int N = A.length;
        int result = 0;
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                if (A[i] == A[j])
                    result = Math.max(result, Math.abs(i - j));
        return result;
    }

    int solution(int[] A){

        Map<Integer, Integer> minIndex = new HashMap<>();
        Map<Integer, Integer> maxIndex = new HashMap<>();

        for (int i=0; i< A.length; i++){
            if (minIndex.getOrDefault(A[i], -1) == -1) {
                minIndex.put(A[i], i);
            }
        }

        for (int i=A.length-1; i>= 0; i--){
            if (maxIndex.getOrDefault(A[i], 1000000) == 1000000){
                maxIndex.put(A[i], i);
            }
        }
        int maxDiff = -1;

        for ( int key: maxIndex.keySet()){
            int diff = maxIndex.get(key) - minIndex.get(key);
            if (diff > maxDiff){
                maxDiff = diff;
            }
        }


        return maxDiff;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(new int[] {4, 6, 2, 2, 6, 6, 1}));

        int[] a = new int[50001];
        Arrays.fill(a, 2);
        System.out.println(sol.solution(a));
    }
}
