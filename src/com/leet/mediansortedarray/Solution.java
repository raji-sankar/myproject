package com.leet.mediansortedarray;

import com.leet.addtwonumbers.Sol;

class Solution {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] combined = mergeSortedArrays(nums1, nums2);
        int n = combined.length;
        if (n % 2 == 1){
            return combined[n/2];
        } else {
            return (combined[(n/2) - 1] + combined[n/2])/2.0;
        }

    }

    private int[] mergeSortedArrays(int[] nums1, int[] nums2){
        int[] result = new int[nums1.length + nums2.length];

        int count= 0;
        int i = 0;
        int j = 0;

        while (count < result.length){
            if (i < nums1.length && j < nums2.length) {
                if (nums1[i] < nums2[j]) {
                    result[count] = nums1[i];
                    count++;
                    i++;
                } else if (nums1[i] == nums2[j]) {
                    result[count] = nums1[i];
                    count++;
                    i++;
                    result[count] = nums2[j];
                    count++;
                    j++;
                } else {
                    result[count] = nums2[j];
                    count++;
                    j++;
                }
            } else if (i < nums1.length && j == nums2.length){
                result[count] = nums1[i];
                count++;
                i++;
            } else if (i == nums1.length && j < nums2.length){
                result[count] = nums2[j];
                count++;
                j++;
            }

        }
        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
//        int[] nums1 = {1, 3};
//        int[] nums2 = {2};
//        System.out.println(sol.findMedianSortedArrays(nums1, nums2));

        int[] nums3 = {1, 2};
        int[] nums4 = {3, 4};
        System.out.println(sol.findMedianSortedArrays(nums3, nums4));
    }
}
