package com.leet.finddup;

public class BetterSol {
    public int singleNumber(int[] nums) {
        int a = 0;
        for(int i=0; i< nums.length; i++){
            a = a ^ nums[i];
        }
        return a;
    }

    public static void main(String[] args) {
        BetterSol sol = new BetterSol();
        int[] nums = {4, 1, 2, 1, 2};
        System.out.println(sol.singleNumber(nums));
    }
}
