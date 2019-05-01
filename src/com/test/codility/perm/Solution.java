package com.test.codility.perm;

import com.sun.org.apache.xpath.internal.operations.Bool;

public class Solution {
    public int solution(int[] A){

        boolean[] val = new boolean[A.length + 1];
        for (int i=0; i<A.length; i++){
            if (A[i] > A.length) return 0;
            val[A[i]] = Boolean.TRUE;
        }

        for (int i=1; i<val.length; i++){
            if (!val[i]) return 0;
        }

        return 1;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(new int[] {4,3,1,2}));
        System.out.println(sol.solution(new int[] {4,3,1}));
    }
}
