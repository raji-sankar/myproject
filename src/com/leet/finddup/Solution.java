package com.leet.finddup;

import com.leet.addtwonumbers.Sol;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a non-empty array of integers, every element appears twice except for one. Find that single one.
 *
 * Note:
 *
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 *
 * Example 1:
 *
 * Input: [2,2,1]
 * Output: 1
 * Example 2:
 *
 * Input: [4,1,2,1,2]
 * Output: 4
 */

public class Solution {

    public int singleNumber(int[] nums) {
        int single = 0;
        Map<Integer, Integer> pairs = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (pairs.get(nums[i]) == null) {
                pairs.put(nums[i], 1);
            } else {
                pairs.put(nums[i], pairs.get(nums[i] + 1));
            }

        }

        for (int key : pairs.keySet()) {
            if (pairs.get(key) == 1) {
                return key;
            }
        }
        return single;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {4, 1, 2, 1, 2};
        System.out.println(sol.singleNumber(nums));
    }
}