package com.leet.arrayintersection;

import java.util.*;
import java.util.stream.Stream;

import static java.lang.Math.min;

/**
 * Given two arrays, write a function to compute their intersection.
 *
 * Example 1:
 *
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2,2]
 * Example 2:
 *
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [4,9]
 * Note:
 *
 * Each element in the result should appear as many times as it shows in both arrays.
 * The result can be in any order.
 * Follow up:
 *
 * What if the given array is already sorted? How would you optimize your algorithm?
 * What if nums1's size is small compared to nums2's size? Which algorithm is better?
 * What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
 */

public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer,Integer> nums1Map = new HashMap<>();
        Map<Integer,Integer> nums2Map = new HashMap<>();

        for(int i=0; i < nums1.length; i++){
            nums1Map.merge(nums1[i], 1, Integer::sum);
        }

        for(int i=0; i < nums2.length; i++){
            nums2Map.merge(nums2[i], 1, Integer::sum);
        }

        List<Integer> common = new ArrayList<>();
        Set<Integer> keys = new HashSet<>();
        Stream.of(nums1Map.keySet(), nums2Map.keySet()).forEach(keys::addAll); ;

        keys.addAll(nums2Map.keySet());

        for(Integer key: keys){
            if(nums1Map.getOrDefault(key, 0) > 0 && nums2Map.getOrDefault(key, 0) > 0){
                for(int i =0; i<min(nums1Map.get(key),nums2Map.get(key)); i++){
                    common.add(key);
                }
            }
        }


        return common.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums1 = {4,9,5};
        int[] nums2 = {9,4,9,8,4};
        int[] res = sol.intersect(nums1, nums2);
        for(int i=0; i<res.length-1; i++){
            System.out.print(res[i] + ", ");
        }
        if(res.length>0)
            System.out.print(res[res.length -1]);
    }
}
