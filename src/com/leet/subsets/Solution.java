package com.leet.subsets;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Solution {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        for (int k=0; k < n+1; k++){
            generateSubsets(0, n, k, nums, new ArrayList<>(), result);
        }
        return result;
    }

    private void generateSubsets(int index, int n, int k, int[] nums, List<Integer> current, List<List<Integer>> answer){

        if(current.size() == k){
            answer.add(new ArrayList<>(current));
        }
        for(int i=index; i < n; i++){
            current.add(nums[i]);
            generateSubsets(i+1, n, k, nums, current, answer);
            current.remove(current.size() -1);
        }

    }

    public List<List<Integer>> subsetSizeK(int[] nums, int k){
        List<List<Integer>> answer = new ArrayList<>();
        generateSubsets(0, nums.length, k, nums, new ArrayList<>(), answer);
        return answer;
    }
//    public List<List<Integer>> subsets(int[] nums) {
//        List<List<Integer>> subsets = new ArrayList<>();
//        //generateSubsetWith + generateSubsetWithout
//        generateSubsets(0, nums, new ArrayList<Integer>(), subsets);
//        return subsets;
//    }
//
//    public void generateSubsets(int index, int[] nums, List<Integer> current, List<List<Integer>>subsets){
//        subsets.add(new ArrayList<>(current));
//        for(int i=index; i<nums.length; i++){
//            current.add(nums[i]);
//            generateSubsets(i+1, nums, current, subsets);
//            current.remove(current.size() -1);
//        }
//    }

    public static void main(String[] args) {
        Solution sol = new Solution();
//        List<List<Integer>> subsets = sol.subsets(new int[] {1,2,3});
//        for(List<Integer> list : subsets){
//            String s = list.stream().map(n -> String.valueOf(n)).collect(Collectors.joining(","));
//            System.out.println(s);
//        }

        List<List<Integer>> subsetK = sol.subsetSizeK(new int[] {1, 2, 3, 4}, 2);
        for(List<Integer> list : subsetK){
            String s = list.stream().map(n -> String.valueOf(n)).collect(Collectors.joining(","));
            System.out.println(s);
        }
    }
}