package com.cake.binarysearch;

public class Solution {

    public static boolean binarySearch(int target, int[] nums){

        int floor = -1;
        int ceiling = nums.length;

        while(floor + 1 < ceiling){
            int distance = ceiling - floor;
            int midPoint = (ceiling + floor)/2;

            int guessValue = nums[midPoint];

            if(guessValue == target){
                return true;
            }
            if(guessValue > target){
                ceiling = midPoint;
            } else {
                floor = midPoint;
            }
        }
        return false;
    }
}
