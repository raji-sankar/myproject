package com.interviewcake.findduplicate;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
 /*
  * Find a duplicate, Space Edition™.

  * We have a list of integers, where:

    The integers are in the range 1..n1..n
    The list has a length of n+1n+1
    It follows that our list has at least one integer which appears at least twice. But it may have several duplicates, and each duplicate may appear more than twice.

    Write a function which finds an integer that appears more than once in our list. (If there are multiple duplicates, you only need to find one of them.)
  */

    static int findDuplicate(int[] nums){

        int n = nums.length - 1;

        Set<Integer> set = new HashSet<>();

        for(int i=0; i<nums.length; i++){
            if (set.contains(nums[i])){
                return nums[i];
            } else {
                set.add(nums[i]);
            }
        }
        return 0;
    }

    public static int findRepeat(int[] numbers){

        for(int i =1; i < numbers.length; i++ ){
            boolean hasBeenSeen = false;
            for(int number: numbers){
                if (number == i) {
                    if (hasBeenSeen) {
                        return number;
                    } else {
                        hasBeenSeen = true;
                    }
                }
            }
        }

        return 0;
    }

    public static int findDup(int[] numbers){

        int sum = 0;
        for (int number: numbers){
            sum += number;
        }

        int expectedSum = numbers.length * (numbers.length -1) /2;

        int dup = sum - expectedSum;

        return dup;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 2};
        System.out.println(findDup(a));
    }

}
