package com.test.codility.odd_occurrence;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {



    public int old_solution(int[] A) {
        int unpaired = 0;
        if (A.length % 2 == 0) throw new RuntimeException("Even number of elements");

        int[] values = new int[A.length];
        for (int i=0; i < A.length; i++) {
            values[A[i]] = ++values[A[i]];
        }

        for (int i=0; i<values.length; i++){
            if (values[i] == 1) {
                return i;
            }

        }
        return unpaired;
    }

    public int bitwise_solution(int[] A){
        int unpaired = 0;

        for (int i=0; i < A.length; i++) {
            unpaired ^= A[i];
        }


        return unpaired;
    }

    public int solution(int[] A){
        int unpaired = 0;

        for (int i=0; i < A.length; i++) {
            if (i % 2 == 1) {
                unpaired += A[i];
            } else {

            }
        }


        return unpaired;
    }

    public static void main(String[] args) {
        int[] A = {9, 3, 9, 3, 9, 7, 9};
        Solution sol = new Solution();
        System.out.println(sol.solution(A));
    }

}
