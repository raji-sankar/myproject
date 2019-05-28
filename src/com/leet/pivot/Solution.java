package com.leet.pivot;

public class Solution {

    public int pivotIndex(int[] nums) {

        int pivot = -1;
        if (nums.length < 1){
            return -1;
        }

        int[] leftSum = new int[nums.length];
        int[] rightSum = new int[nums.length];
        leftSum[0] = 0;
        rightSum[nums.length -1] = 0;
        for(int i=1; i<nums.length; i++){
            leftSum[i] = leftSum[i-1] + nums[i-1];
        }

        for(int i=nums.length -2; i > -1; i--){
            rightSum[i] = rightSum[i+1] + nums[i+1];
        }

        for(int i=0; i<nums.length ; i++){
            if (leftSum[i] == rightSum[i])
                return i;
        }


        return pivot;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {1, 7, 3, 6, 5, 6};
//        System.out.println(sol.pivotIndex(nums));
        int[] nums2 = {1, 2, 3};
//        System.out.println(sol.pivotIndex(nums2));
        int[] nums3 = {-1,-1,-1,0,1,1};
//        System.out.println(sol.pivotIndex(nums3));

        int[] nums4 = {-1,-1,0,1,1,0};
        System.out.println(sol.pivotIndex(nums4));
    }
}
