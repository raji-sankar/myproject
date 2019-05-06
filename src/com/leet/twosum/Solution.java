package com.leet.twosum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int[] twoSum(int[] nums, int target){
        Map<Integer, Integer> map = new HashMap<>();
        int[] answer = new int[2];

        for (int i=0; i<nums.length; i++){
            map.put(nums[i], i);
        }

        for (int i=0; i<nums.length; i++){
            int diff = target - nums[i];
            int other = map.getOrDefault(diff, -1);
            if ( other != -1 && other!= i){
                answer[0] = i;
                answer[1] = map.get(diff);
                break;
            }
        }
        return answer;
    }


    public static void main(String[] args) {
        Solution sol = new Solution();

//        int[] nums = {2, 7, 11, 15};
        int[] nums = {3, 2, 4};
        int[] answer = sol.twoSum(nums, 6);
        System.out.println(Arrays.toString(answer));
    }


}


