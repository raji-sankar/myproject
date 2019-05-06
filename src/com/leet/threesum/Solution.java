package com.leet.threesum;

import java.util.*;

public class Solution {
    public List<List<Integer>> threeSumIncorrect(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> output = new ArrayList<>() ;
        Map<Integer, Integer> map = new HashMap<>();
        Set<List<Integer>> outputSet = new HashSet<>();
        //brute force
        //1. take one element
        //2. find the complement to sum to 0
        //3. twoSum on the target

        for(int i=0; i<nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        int target = 0;
        for(int i=0; i < nums.length; i++){
            target = 0 - nums[i];
            for (int key: map.keySet()){
                if (key != nums[i]){
                    int first = key;
                    int second = target - key;
                    if (map.get(second) != null){
                        //we have a solution
                        List<Integer> sol = new ArrayList<>();
                        sol.add(nums[i]);
                        sol.add(first);
                        sol.add(second);
                        outputSet.add(sol);
                    }
                }
            }


        }
        output.addAll(outputSet);
        return output;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        ArrayList<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int j = i + 1;
            int k = nums.length - 1;

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            while (j < k) {
                if (k < nums.length - 1 && nums[k] == nums[k + 1]) {
                    k--;
                    continue;
                }

                if (nums[i] + nums[j] + nums[k] > 0) {
                    k--;
                } else if (nums[i] + nums[j] + nums[k] < 0) {
                    j++;
                } else {
                    ArrayList<Integer> l = new ArrayList<>();
                    l.add(nums[i]);
                    l.add(nums[j]);
                    l.add(nums[k]);
                    result.add(l);
                    j++;
                    k--;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        Solution sol = new Solution();
        List<List<Integer>> output = sol.threeSum(nums);
        for(List<Integer> list : output){
            list.forEach(System.out::println);
        }
    }
}
