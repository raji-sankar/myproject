package com.cake.highestproductofthree;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static org.junit.Assert.*;

public class Solution {

    public static int highestProductOf3(int[] intArray) {

        // calculate the highest product of three numbers
        if(intArray.length < 3){
            throw new IllegalArgumentException("intArray needs atleast 3 elements ");
        }

        int lowest = Math.min(intArray[0], intArray[1]);
        int highest = Math.max(intArray[0], intArray[1]);
        int highestProductOf2 =intArray[0] * intArray[1] ;
        int lowestProductOf2 =intArray[0] * intArray[1];
        int highestProductOf3 = intArray[0] * intArray[1] * intArray[2];
        for(int i=2; i <intArray.length; i++){
            highestProductOf3 = Math.max(highestProductOf3, Math.max(highestProductOf2 * intArray[i], lowestProductOf2 * intArray[i]));

            highestProductOf2 = Math.max(Math.max(highest * intArray[i], lowest * intArray[i]), highestProductOf2);
            lowestProductOf2 = Math.min(Math.max(lowest * intArray[i], highest * intArray[i]), lowestProductOf2);

            lowest = Math.min(intArray[i], lowest);
            highest = Math.max(intArray[i], highest);
        }


        return highestProductOf3;
    }




    // tests

    @Test
    public void shortArrayTest() {
        final int actual = highestProductOf3(new int[] {1, 2, 3, 4});
        final int expected = 24;
        assertEquals(expected, actual);
    }

    @Test
    public void longerArrayTest() {
        final int actual = highestProductOf3(new int[] {6, 1, 3, 5, 7, 8, 2});
        final int expected = 336;
        assertEquals(expected, actual);
    }

    @Test
    public void arrayHasOneNegativeTest() {
        final int actual = highestProductOf3(new int[] {-5, 4, 8, 2, 3});
        final int expected = 96;
        assertEquals(expected, actual);
    }

    @Test
    public void arrayHasTwoNegativesTest() {
        final int actual = highestProductOf3(new int[] {-10, 1, 3, 2, -10});
        final int expected = 300;
        assertEquals(expected, actual);
    }

    @Test
    public void arrayIsAllNegativesTest() {
        final int actual = highestProductOf3(new int[] {-5, -1, -3, -2});
        final int expected = -6;
        assertEquals(expected, actual);
    }

    @Test(expected = Exception.class)
    public void exceptionWithEmptyArrayTest() {
        highestProductOf3(new int[] {});
    }

    @Test(expected = Exception.class)
    public void exceptionWithOneNumberTest() {
        highestProductOf3(new int[] {1});
    }

    @Test(expected = Exception.class)
    public void exceptionWithTwoNumbersTest() {
        highestProductOf3(new int[] {1, 1});
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
