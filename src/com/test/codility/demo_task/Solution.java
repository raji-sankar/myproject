package com.test.codility.demo_task;

public class Solution {
    public int solution(int[] A){
        int smallest = 1;
        boolean[] values = new boolean[1000001];
        for (int i=0; i < A.length; i++){
            if(A[i] > 0){
                values[A[i]] = Boolean.valueOf(Boolean.TRUE);
            }
        }

        for (int i=1; i<values.length; i++){
            if (!values[i]){
                return i;
            }
        }

        return smallest;
    }

    public static void main(String[] args) {
        int[] A =  {1, 3, 6, 4, 1, 2};
        Solution sol = new Solution();

        int[] B = {-1, -3};
        System.out.println(sol.solution(B));

    }
}

