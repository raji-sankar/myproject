package com.leet.searchsortedarray;

public class Solution {

    /**
     * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
     *
     * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
     *
     * You are given a target value to search. If found in the array return its index, otherwise return -1.
     *
     * You may assume no duplicate exists in the array.
     *
     * Your algorithm's runtime complexity must be in the order of O(log n).
     *
     * Example 1:
     *
     * Input: nums = [4,5,6,7,0,1,2], target = 0
     * Output: 4
     * Example 2:
     *
     * Input: nums = [4,5,6,7,0,1,2], target = 3
     * Output: -1
     */

    public int bruteforceSearch(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++){
            if (target == nums[i])
                return i;
        }

        return -1;
    }


    public int search(int[] nums, int target) {

        //use binary search
        //first find where the pivot is
        int first = nums[0];
        if (target == first)
            return 0;
        int last = nums[nums.length - 1];
        if (target == last) {
            return nums.length - 1;
        }
        if (first > last) {
            //array is sorted
            int midpoint = nums.length / 2;
            while (midpoint > -1 && midpoint < nums.length) {
                if (nums[midpoint] == target) {
                    return midpoint;
                } else if (target < nums[midpoint] && nums[midpoint + 1] > nums[midpoint]) {
                    midpoint = midpoint / 2;
                } else if (target < nums[midpoint] && nums[midpoint + 1] < nums[midpoint]) {
                    midpoint = (midpoint + nums.length) / 2;
                } else if (target > nums[midpoint] && nums[midpoint + 1] > nums[midpoint]) {
                    midpoint = (midpoint + nums.length) / 2;
                } else {
                    midpoint = midpoint / 2;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] input = {4,5,6,7,0,1,2};
        System.out.println(sol.bruteforceSearch(input, 0));
        System.out.println(sol.bruteforceSearch(input, 3));
    }

}

