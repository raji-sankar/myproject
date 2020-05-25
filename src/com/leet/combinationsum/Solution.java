package com.leet.combinationsum;

import java.util.ArrayList;
import java.util.List;

/**
 * 39. Combination Sum
 * Medium
 *
 * Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.
 *
 * The same repeated number may be chosen from candidates unlimited number of times.
 *
 * Note:
 *
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * Example 1:
 *
 * Input: candidates = [2,3,6,7], target = 7,
 * A solution set is:
 * [
 *   [7],
 *   [2,2,3]
 * ]
 * Example 2:
 *
 * Input: candidates = [2,3,5], target = 8,
 * A solution set is:
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 */
public class Solution {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if(candidates == null || candidates.length == 0){
            return result;
        }

        backtrack(0, candidates, target, 0, new ArrayList<Integer>(), result);
        return result;


    }

    private void backtrack(int pos, int[] candidates, int target, int currentSum, List<Integer> current, List<List<Integer>> result){
        if(pos == candidates.length || currentSum >= target){
            if(currentSum == target){
                result.add(new ArrayList<>(current));
            }
            return;
        }

        for(int i = pos; i<candidates.length; i++){
            int val = candidates[i];
            current.add(val);
            backtrack(i, candidates, target, currentSum+val, current, result);
            current.remove(current.size() -1);
        }

    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.combinationSum(new int[]{2,3,7}, 7));
    }
}
