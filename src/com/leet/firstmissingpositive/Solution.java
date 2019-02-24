package com.leet.firstmissingpositive;

public class Solution {
    /**
     * Given an unsorted integer array, find the smallest missing positive integer.
     *
     * Example 1:
     *
     * Input: [1,2,0]
     * Output: 3
     * Example 2:
     *
     * Input: [3,4,-1,1]
     * Output: 2
     * Example 3:
     *
     * Input: [7,8,9,11,12]
     * Output: 1
     *
     * Note:
     *
     * Your algorithm should run in O(n) time and uses constant extra space.
     */

    public int firstMissingPositive(int[] nums) {

        boolean[] seen = new boolean[nums.length + 1];
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0 && nums[i] <= nums.length){
                seen[nums[i]] = true;
            }
        }

        for(int i = 1; i <= nums.length ; i++){
            if (!seen[i])
                return i;
        }

        return nums.length + 1;

    }

    public static void main(String[] args) {
        int[] nums = {3,4,-1,1};
        Solution sol = new Solution();
        System.out.println(sol.firstMissingPositive(nums));
        int[] nums2 = {1};
        System.out.println(sol.firstMissingPositive(nums2));
    }
}
