package com.test.codility.cyclic_rotation;

import java.util.Arrays;

public class Solution {
    public int[] solution(int[] A, int K){
        if (A.length == 0) return A;
        int[] result = new int[A.length];
        if (K >= A.length) K = K % A.length;
        if (K == 0) return A;

        System.arraycopy(A, A.length - K, result, 0, K);

        System.arraycopy(A, 0, result, K,  A.length - K);

        return result;
    }

    public static void main(String [] args){
        int[] A = {3, 8, 9, 7, 6};
        Solution sol = new Solution();
        int[] result = sol.solution(A, 1);
        System.out.println(Arrays.toString(result));
        int[] B = {1, 2, 3, 4};
        System.out.println(Arrays.toString(sol.solution(B, 4)));

        int[] C = {};
        System.out.println(Arrays.toString(sol.solution(C, 1)));
    }

}
