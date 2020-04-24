package com.cake.binarysearch;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static org.junit.Assert.*;

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

    public static boolean contains( int[] nums, int target){

        int floor = -1;
        int ceiling = nums.length;

        while(floor  < ceiling){
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

    // tests

    @Test
    public void emptyArrayTest() {
        final boolean result = contains(new int[] {}, 1);
        assertFalse(result);
    }

    @Test
    public void oneItemArrayNumberPresentTest() {
        final boolean result = contains(new int[] {1}, 1);
        assertTrue(result);
    }

    @Test
    public void oneItemArrayNumberAbsentTest() {
        final boolean result = contains(new int[] {1}, 2);
        assertFalse(result);
    }

    @Test
    public void smallArrayNumberPresentTest() {
        final boolean result = contains(new int[] {2, 4, 6}, 4);
        assertTrue(result);
    }

    @Test
    public void smallArrayNumberAbsentTest() {
        final boolean result = contains(new int[] {2, 4, 6}, 5);
        assertFalse(result);
    }

    @Test
    public void largeArrayNumberPresentTest() {
        final boolean result = contains(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 8);
        assertTrue(result);
    }

    @Test
    public void largeArrayNumberAbsentTest() {
        final boolean result = contains(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 0);
        assertFalse(result);
    }

    @Test
    public void largeArrayNumberFirstTest() {
        final boolean result = contains(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 1);
        assertTrue(result);
    }

    @Test
    public void largeArrayNumberLastTest() {
        final boolean result = contains(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 10);
        assertTrue(result);
    }

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(Solution.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
    }
}
