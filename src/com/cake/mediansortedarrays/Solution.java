package com.cake.mediansortedarrays;

public class Solution {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int[] merged = mergeArrays(nums1, nums2);
        int k = merged.length;
        if (k % 2 == 1){
            //odd, just return middle element
            return merged[k/2];
        } else {
            //even avg os 2 middle elements
            return (merged[(k/2) -1] + merged[k/2])/2.0;
        }

    }

    public int[] mergeArrays(int[] array1, int[] array2){
        int[] merged = new int[array1.length + array2.length];

        int i = 0;
        int j = 0;
        int k = 0;

        while(k < merged.length){
            boolean array1Exhausted = i >= array1.length;
            boolean array2Exhausted = j >= array2.length;
            if(!array1Exhausted && (array2Exhausted || array1[i] <= array2[j])) {
                merged[k] = array1[i];
                i++;
            } else {
                merged[k] = array2[j];
                j++;
            }

            k++;
        }

        return merged;
    }
}
