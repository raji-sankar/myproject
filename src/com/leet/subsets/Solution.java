package com.leet.subsets;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        //generateSubsetWith + generateSubsetWithout
        generateSubsets(0, nums, new ArrayList<Integer>(), subsets);
        return subsets;
    }

    public void generateSubsets(int index, int[] nums, List<Integer> current, List<List<Integer>>subsets){
        subsets.add(new ArrayList<>(current));
        for(int i=index; i<nums.length; i++){
            current.add(nums[i]);
            generateSubsets(i+1, nums, current, subsets);
            current.remove(current.size() -1);
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        List<List<Integer>> subsets = sol.subsets(new int[] {1,2,3});
        for(List<Integer> list : subsets){
            String s = list.stream().map(n -> String.valueOf(n)).collect(Collectors.joining(","));
            System.out.println(s);
        }
    }
}