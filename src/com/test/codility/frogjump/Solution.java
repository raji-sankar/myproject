package com.test.codility.frogjump;

public class Solution {

    public int solution(int X, int Y, int D){
        return (Y - X + D -1)/D;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(10, 85, 30));
    }
}
