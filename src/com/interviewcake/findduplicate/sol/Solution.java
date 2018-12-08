package com.interviewcake.findduplicate.sol;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static org.junit.Assert.*;

public class Solution {

    public static int findRepeat(int[] theArray) {

        int sum = 0;
        for (int number: theArray){
            sum += number;
        }

        // if there is just one repeated item, it can be found easily
        int expectedSum = theArray.length * (theArray.length -1) /2;

        System.out.println("Sum = " + sum + ", expected = " + expectedSum);

        int dupCandidate = sum - expectedSum;

        if (dupCandidate > 0) {
            if(dupCandidate < theArray.length) {
                //valid case
                if (isDuplicate(theArray, dupCandidate)) return dupCandidate;
            } else {
                for (int i = 0; i < theArray.length; i++){

                }
            }
        } else {
            //smaller number is repeated so the sum < expectedSum
            dupCandidate = Math.abs(dupCandidate);
            dupCandidate = dupCandidate - (dupCandidate - (theArray.length -1));
            if (isDuplicate(theArray, dupCandidate)) return dupCandidate;
        }

        return 0;



    }

    public static boolean isDuplicate(int[] theArray, int candidate){

        for (int i=0; i < theArray.length; i++){
            if (candidate == theArray[i]) {
                return true;
            }
        }
        return false;
    }




    // tests

    @Test
    public void justTheRepeatedNumberTest() {
        final int[] numbers = {1, 1};
        final int expected = 1;
        final int actual = findRepeat(numbers);
        assertEquals(expected, actual);
    }

    @Test
    public void justTheRepeatedNumberTestLonger() {
        final int[] numbers = {1, 1, 1, 1, 1, 1, 1};
        final int expected = 1;
        final int actual = findRepeat(numbers);
        assertEquals(expected, actual);
    }

    @Test
    public void shortArrayTest() {
        final int[] numbers = {1, 2, 3, 2};
        final int expected = 2;
        final int actual = findRepeat(numbers);
        assertEquals(expected, actual);
    }

    @Test
    public void mediumArrayTest() {
        final int[] numbers = {1, 2, 5, 5, 5, 5};
        final int expected = 5;
        final int actual = findRepeat(numbers);
        assertEquals(expected, actual);
    }

    @Test
    public void mediumArraySecondTest() {
        final int[] numbers = {1, 2, 5, 5, 4, 4};
        final int[] expected = {5, 4};
        final int actual = findRepeat(numbers);
        assertTrue(actual == expected[0] || actual == expected[1]);
    }

    @Test
    public void longArrayTest() {
        final int[] numbers = {4, 1, 4, 8, 3, 2, 7, 6, 5};
        final int expected = 4;
        final int actual = findRepeat(numbers);
        assertEquals(expected, actual);
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