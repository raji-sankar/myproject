package com.test.codility.binary_gap;

public class Solution {

    public int solution(int n){
//        for(int i=0; i < 100; i++){
//            System.out.println("i = " + i + ": bin = " + Integer.toBinaryString(i));
//        }
        String bin = Integer.toBinaryString(n);
        System.out.println(bin);
        int maxGap = 0;
        int gap = 0;
        // the binary string will always start with 1 for any number > 0
        for (int i=0; i<bin.length(); i++){
            char c = bin.charAt(i);
            if (c == '0'){
                gap++;
            } else {
                if (maxGap < gap) maxGap = gap;
                gap = 0;
            }
        }
        return maxGap;
    }

    public static void main(String[] args){
        int n = 1041;
        Solution sol = new Solution();
        int x = sol.solution(n);
        System.out.println("maxGap = " + x);
        n = 32;
        System.out.println("number = " + n + ": bin = " + Integer.toBinaryString(n) + ": maxGap = " + sol.solution(n));
    }
}
