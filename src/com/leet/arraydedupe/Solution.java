package com.leet.arraydedupe;

import java.util.Arrays;

class Solution {
    public int removeDuplicates(int[] nums) {
        int len = 0;
        int priv = -1000;
        for (int i=0; i < nums.length; i++){
            if (nums[i] == priv ) {
                continue;
            } else {
                nums[len] = nums[i];
                len++;
                priv = nums[i];
            }
        }
        return len;

    }

    public void print( int[] nums){
        int len = removeDuplicates(nums);
        System.out.println(len);
        System.out.println(Arrays.toString(Arrays.copyOfRange(nums, 0, len)));

    }

    public static void main(String[] args) {
//        int[] nums = {1, 1, 2};
//
        Solution sol = new Solution();
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        sol.print(nums);
        int[] nums2 = {1, 1, 2};

        sol.print( nums2);

        int[] nums3 = {1, 1};
        sol.print(nums3);

        int[] nums4 = {-1,0,0,0,0,3,3};
        sol.print(nums4);

    }
}