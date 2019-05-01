package com.test.codility.perm_missing_elem;

public class Solution {

    public int solution(int[] A){

        long sum = 0;

        for (int i=0; i<A.length; i++){
            sum += A[i];
        }

        long expectedSum = (long)(A.length + 1)* (A.length + 2)/2;
        if (sum > expectedSum) {
            System.out.println("expectedSum = " + expectedSum + "; sum = " + sum);
        }
        return (int)(expectedSum - sum);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(new int[] {2, 3, 1, 5}));
        System.out.println(sol.solution(new int[] {}));
    }
}
