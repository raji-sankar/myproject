package com.test.codility.tape_equi;

public class Solution {
    public int solution(int[] A){

        int [] left_sum = new int[A.length - 1];
        int [] abs_diff = new int[A.length -1];
        int tot = 0;
        for (int i=0; i<A.length; i++){
            tot += A[i] ;
            if (i < A.length -1) {
                left_sum[i] = tot;
            }
        }
        System.out.println();

        int min_abs_diff = 1000000;
        for (int i=0; i< left_sum.length; i++){
            abs_diff[i] = Math.abs(left_sum[i] - (tot - left_sum[i]));
            if (abs_diff[i] < min_abs_diff){
                min_abs_diff = abs_diff[i];
            }
        }

        return min_abs_diff;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(new int [] {3, 1, 2, 4, 3}));
        System.out.println(sol.solution(new int [] {2000, 4000}));
    }

}
