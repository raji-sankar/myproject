package com.cake.rotationpoint;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static org.junit.Assert.*;

public class Solution {

    public static int findRotationPoint(String[] words) {

        // find the rotation point in the array


        //check if already sorted
        if(words[0].compareTo(words[words.length -1]) < 0){
            return 0;
        }

        int floor = 0;
        int ceiling = words.length - 1;

        while(floor  < ceiling){
            int midPoint = (floor + ceiling)/2;
            if(words[midPoint].compareTo(words[floor])>= 0){
                floor = midPoint;
            } else {
                ceiling = midPoint ;
            }

            if(floor + 1 == ceiling){
                break;
            }
        }



        return ceiling;
    }

    public static int findRotationPoint(int[] nums){
        int rotationPoint = 0;

        //check if already sorted
        if(nums[0] < nums[nums.length -1]){
            return 0;
        }
        //brute force
//        for(int i=0; i<nums.length -1; i++){
//            if(nums[i] > nums[i+1]) {
//                return i+1;
//            }
//        }

        //binary search
        //Assume unique, no duplicates
        //1. start with midpoint index
        int floor = -1;
        int ceiling = nums.length;
        while((floor + 1) < ceiling) {
            int midpoint = (floor +1 + ceiling) / 2;
            if (nums[midpoint - 1] > nums[midpoint]) {
                return midpoint;
            } else {
                floor = midpoint -1;
            }
        }

        return rotationPoint;
    }




    // tests

    // tests

    @Test
    public void intArrayTest() {
        final int actual = findRotationPoint(new int[] {7, 8, 10, 4, 5});
        final int expected = 3;
        assertEquals(expected, actual);
    }

    @Test
    public void smallArrayTest() {
        final int actual = findRotationPoint(new String[] {"cape", "cake"});
        final int expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    public void mediumArrayTest() {
        final int actual = findRotationPoint(new String[] {"grape", "orange", "plum",
                "radish", "apple"});
        final int expected = 4;
        assertEquals(expected, actual);
    }

    @Test
    public void largeArrayTest() {
        final int actual = findRotationPoint(
                new String[] {"ptolemaic", "retrograde", "supplant", "undulate", "xenoepist",
                        "asymptote", "babka", "banoffee", "engender", "karpatka", "othellolagkage"});
        final int expected = 5;
        assertEquals(expected, actual);
    }

    @Test
    public void notRotated(){
        final int actual = findRotationPoint(
                new String[] {"apple", "banana", "carrot", "donut", "eclair"});
        final int expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    public void notRotatedInt(){
        final int actual = findRotationPoint(
                new int[] {1, 2, 3, 4, 5});
        final int expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    public void possiblyMissingEdgeCaseTest() {
        // are we missing any edge cases?
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
