package com.test.codility.frogriver;

import java.util.Arrays;

public class Solution {
    public int solution(int X, int[] A){
        int[] B = new int[X+1];
        Arrays.fill(B, -1);
        for (int i=0; i<A.length; i++){
            if (B[A[i]] == -1){
                B[A[i]] = i;
            }
        }


        int max = -1;
        for (int i=1; i<X+1; i++){
            if (B[i] == -1){
                return -1;
            }
            if (B[i] > max){
                max = B[i];
            }
        }
        return max;

    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(5, new int[] {1,3,1,4,2,3,5,4}));
    }
}
