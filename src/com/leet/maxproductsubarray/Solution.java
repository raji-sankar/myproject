package com.leet.maxproductsubarray;

/**
 * Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.
 *
 * Example 1:
 *
 * Input: [2,3,-2,4]
 * Output: 6
 * Explanation: [2,3] has the largest product 6.
 * Example 2:
 *
 * Input: [-2,0,-1]
 * Output: 0
 * Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 */
public class Solution {


    public int maxProduct(int[] nums){
        int max = nums[0];
        for(int i=1, imax=max, imin=max; i < nums.length; i++){
            if(nums[i] < 0){
                int temp = imax;
                imax = imin;
                imin = temp;
            }
            imax = Math.max(nums[i], imax * nums[i]);
            imin = Math.min(nums[i], imin * nums[i]);

            max = Math.max(max, imax);
        }
        return max;
    }



    public static void main(String[] args) {
        int[] nums = {2,3,-2,4};
        Solution sol = new Solution();
        System.out.println(sol.maxProduct(nums));
        int[] nums2 = {-2,0,-1};
        System.out.println(sol.maxProduct(nums2));
        int[] nums3 = {2,3,-2,4, 5};
        System.out.println(sol.maxProduct(nums3));
        int[] nums4 = {0,2};
        System.out.println(sol.maxProduct(nums4));
        int[] nums5 = {-2, 3,-4};
        System.out.println(sol.maxProduct(nums5));
        int[] nums6 = {2,-5,-2,-4,3};
        System.out.println(sol.maxProduct(nums6));
    }
}
