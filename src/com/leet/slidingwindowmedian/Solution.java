package com.leet.slidingwindowmedian;

import java.util.Arrays;
import java.util.Collections;
import java.util.TreeMap;

public class Solution {
    public double[] medianSlidingWindowBruteForce(int[] nums, int k) {
        double[] output = new double[nums.length - k + 1];

        for(int i=0; i<nums.length-k + 1; i++){
            int[] slice = Arrays.copyOfRange(nums, i, i+k);
            Arrays.sort(slice);
            if (k % 2 == 0){
                output[i] = (double)(slice[k/2])/2 + (double)(slice[k/2 - 1])/2;
            } else {
                output[i] = (slice[k/2]);
            }
        }
        return output;
    }

    public double[] medianSlidingWindow(int[] nums, int k) {
        double[] output = new double[nums.length - k + 1];
        TreeMap<Integer, Integer> minHeap = new TreeMap<>();
        TreeMap<Integer, Integer> maxHeap = new TreeMap<>(Collections.reverseOrder());
        int minHeapCap = k/2;
        int maxHeapCap = k -minHeapCap;
        for(int i=0; i < k; i++){
            maxHeap.put(nums[i], maxHeap.getOrDefault(nums[i], 0) + 1);
        }
        int[] slice = Arrays.copyOfRange(nums, 0, k);
        Arrays.sort(slice);
        output[0] = (k % 2 == 1) ? slice[k/2] : (double)(slice[k/2])/2 + (double)(slice[k/2 - 1])/2;
        for(int i=1; i<nums.length-k + 1; i++) {
            //slice already sorted, remove slice[0], rearrange the rest depending on where nums[i] falls
            int replacement = nums[i+k-1];
            if (replacement < output[i-1]){
                for (int j=0; j < k; j++){
                    slice[j] = replacement <= slice[j] ? replacement : slice[j];
                }
            }
        }
        return output;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {1,3,-1,-3,5,3,6,7};
        System.out.println(Arrays.toString(sol.medianSlidingWindow(nums, 3)));

        int[] nums2 = {2147483647,2147483647};
        System.out.println(Arrays.toString(sol.medianSlidingWindow(nums2, 2)));
    }
}
