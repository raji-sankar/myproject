package com.cake.coin;

import java.util.Arrays;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static org.junit.Assert.*;

public class Solution {

    public static int changePossibilities(int amount, int[] denominations) {

        // calculate the number of ways to make change
        //assuming denominations is a sorted array
        return changePossibilitiesTopDown(amount, denominations, 0);
    }

    public static int changePossibilitiesTopDown(int amountLeft, int[] denominations, int currentIndex){
        //base case
        if(amountLeft == 0){
            return 1;
        }

        if(amountLeft < 1){
            return 0;
        }

        if(currentIndex == denominations.length){
            return 0;
        }

        System.out.printf("checking ways to make %d with %s \n", amountLeft,
                Arrays.toString(Arrays.copyOfRange(denominations, currentIndex, denominations.length)));


        int currentCoin = denominations[currentIndex];

        int numPossibilities = 0;

        while(amountLeft >=0){
            numPossibilities += changePossibilitiesTopDown(amountLeft, denominations, currentIndex + 1);
            amountLeft -= currentCoin;
        }

        return numPossibilities;

    }




    // tests

    @Test
    public void sampleInputTest() {
        final int actual = changePossibilities(4, new int[] {1, 2, 3});
        final int expected = 4;
        assertEquals(expected, actual);
    }

    @Test
    public void oneWayToMakeZeroCentsTest() {
        final int actual = changePossibilities(0, new int[] {1, 2});
        final int expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    public void noWaysIfNoCoinsTest() {
        final int actual = changePossibilities(1, new int[] {});
        final int expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    public void bigCoinValueTest() {
        final int actual = changePossibilities(5, new int[] {25, 50});
        final int expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    public void bigTargetAmountTest() {
        final int actual = changePossibilities(50, new int[] {5, 10});
        final int expected = 6;
        assertEquals(expected, actual);
    }

    @Test
    public void changeForOneDollarTest() {
        final int actual = changePossibilities(100, new int[] {1, 5, 10, 25, 50});
        final int expected = 292;
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
