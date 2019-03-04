package com.leet.slidingwindowmax;
import java.util.Arrays;


class Solution {
    /**
     * Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position. Return the max sliding window.
     *
     * Example:
     *
     * Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
     * Output: [3,3,5,5,6,7]
     * Explanation:
     *
     * Window position                Max
     * ---------------               -----
     * [1  3  -1] -3  5  3  6  7       3
     *  1 [3  -1  -3] 5  3  6  7       3
     *  1  3 [-1  -3  5] 3  6  7       5
     *  1  3  -1 [-3  5  3] 6  7       5
     *  1  3  -1  -3 [5  3  6] 7       6
     *  1  3  -1  -3  5 [3  6  7]      7
     * Note:
     * You may assume k is always valid, 1 ≤ k ≤ input array's size for non-empty array.
     * @param nums
     * @param k
     * @return
     */

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0){
            return new int[0];
        }
        int max = Integer.MIN_VALUE;
        int[] output = new int[nums.length -k + 1];
        //first first max
        if (k == 1){
            for(int i=0; i<nums.length; i++){
                output[i] = nums[i];
            }
        }
        if (k > 1){
            for(int i=0; i < k; i++){
                max = Math.max(nums[i], max);
                output[0] = max;
            }

            for (int i = 1; i < output.length; i++){
                if (nums[i-1] == max){
                    //calculate new max
                    int[] slice = Arrays.copyOfRange(nums, i, i+k);
                    max = calculateMax(slice);

                } else {
                    max = Math.max(nums[i+k-1], max);
                }
                output[i] = max;
            }
        }
        return output;
    }

    public int calculateMax(int[] a){
        int max = Integer.MIN_VALUE;
        for(int i=0; i<a.length; i++){
            max = Math.max(a[i], max);
        }
        return max;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {1,3,-1,-3,5,3,6,7};
        System.out.println(Arrays.toString(sol.maxSlidingWindow(nums, 3)));
        System.out.println(Arrays.toString(sol.maxSlidingWindow(nums, 1)));
        int[] nums2 = {};
        System.out.println(Arrays.toString(sol.maxSlidingWindow(nums2, 1)));
        int[] nums3 = {7, 4, -4};
        System.out.println(Arrays.toString(sol.maxSlidingWindow(nums3, 2)));
    }
}
