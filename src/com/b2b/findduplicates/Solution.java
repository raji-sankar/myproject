package com.b2b.findduplicates;

import java.util.*;

public class Solution {

    public static int[] findDuplicates(int[] nums){
        List<Integer> dups = new ArrayList<>();
        int[] counts = new int[nums.length +1];
        for(int i=0; i<nums.length; i++){
            counts[nums[i]]++;
        }

        for(int i =0; i < counts.length; i++){
            if(counts[i] > 1){
                dups.add(i);
            }
        }


        return dups.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findDuplicates(new int[]{1, 2, 1, 2})));

        System.out.println(Arrays.toString(findDuplicates(new int[]{1, 2, 3})));

        System.out.println(Arrays.toString(findDuplicates(new int[]{3, 3, 3})));
    }
}
