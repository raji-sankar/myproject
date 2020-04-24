package com.cake.cakethief;

import java.util.Arrays;
import java.util.Comparator;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static org.junit.Assert.*;

public class Solution {

    public static class CakeType {

        final int weight;
        final int value;

        public CakeType(int weight, int value) {
            this.weight = weight;
            this.value  = value;
        }
    }

    public static long maxDuffelBagValue(CakeType[] cakeTypes, int weightCapacity) {

        if (cakeTypes.length == 0){
            throw new IllegalArgumentException("need to specify at least one cake type");
        }

        if(weightCapacity == 0){
            return 0;
        }

        if(weightCapacity < 1){
            throw new IllegalArgumentException("weight needs tbe greater than 0");
        }



        long[] maxValuesAtCapacity = new long[weightCapacity+1];
        Arrays.fill(maxValuesAtCapacity, 0);
        for(int i=1; i<=weightCapacity; i++){
            for(int j=0; j<cakeTypes.length; j++){
                if(cakeTypes[j].weight == 0 && cakeTypes[j].value > 0){
                    throw new IllegalArgumentException("Weight cannot be 0");
                }
                if(cakeTypes[j].weight <= i){
                    maxValuesAtCapacity[i] = Math.max(maxValuesAtCapacity[i],  cakeTypes[j].value + maxValuesAtCapacity[i - cakeTypes[j].weight]);
                }
            }
        }

        return maxValuesAtCapacity[weightCapacity];
    }



    // tests

    @Test
    public void oneCakeTest() {
        final CakeType[] cakeTypes = {new CakeType(2, 1)};
        final int weightCapacity = 9;
        final long expected = 4;
        final long actual = maxDuffelBagValue(cakeTypes, weightCapacity);
        assertEquals(expected, actual);
    }

    @Test
    public void twoCakesTest() {
        final CakeType[] cakeTypes = {new CakeType(4, 4), new CakeType(5, 5)};
        final int weightCapacity = 9;
        final long expected = 9;
        final long actual = maxDuffelBagValue(cakeTypes, weightCapacity);
        assertEquals(expected, actual);
    }

    @Test
    public void onlyTakeLessValuableCakeTest() {
        final CakeType[] cakeTypes = {new CakeType(4, 4), new CakeType(5, 5)};
        final int weightCapacity = 12;
        final long expected = 12;
        final long actual = maxDuffelBagValue(cakeTypes, weightCapacity);
        assertEquals(expected, actual);
    }

    @Test
    public void lotsOfCakesTest() {
        final CakeType[] cakeTypes = {
                new CakeType(2, 3), new CakeType(3, 6), new CakeType(5, 1),
                new CakeType(6, 1), new CakeType(7, 1), new CakeType(8, 1)
        };
        final int weightCapacity = 7;
        final long expected = 12;
        final long actual = maxDuffelBagValue(cakeTypes, weightCapacity);
        assertEquals(expected, actual);
    }

    @Test
    public void valueToWeightRatioIsNotOptimalTest() {
        final CakeType[] cakeTypes = {new CakeType(51, 52), new CakeType(50, 50)};
        final int weightCapacity = 100;
        final long expected = 100;
        final long actual = maxDuffelBagValue(cakeTypes, weightCapacity);
        assertEquals(expected, actual);
    }

    @Test
    public void zeroCapacityTest() {
        final CakeType[] cakeTypes = {new CakeType(1, 2)};
        final int weightCapacity = 0;
        final long expected = 0;
        final long actual = maxDuffelBagValue(cakeTypes, weightCapacity);
        assertEquals(expected, actual);
    }

    @Test
    public void cakeWithZeroValueAndWeightTest() {
        final CakeType[] cakeTypes = {new CakeType(0, 0), new CakeType(2, 1)};
        final int weightCapacity = 7;
        final long expected = 3;
        final long actual = maxDuffelBagValue(cakeTypes, weightCapacity);
        assertEquals(expected, actual);
    }

    @Test(expected = Exception.class)
    public void cakeWithNonZeroValueAndZeroWeightTest() {
        final CakeType[] cakeTypes = {new CakeType(0, 5)};
        final int weightCapacity = 5;
        maxDuffelBagValue(cakeTypes, weightCapacity);
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
