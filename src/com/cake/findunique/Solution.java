package com.cake.findunique;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import java.util.Set;
import java.util.HashSet;


import static org.junit.Assert.*;

public class Solution {

    public static int findUniqueDeliveryId(int[] deliveryIds) {

        // find the one unique ID in the array
        //create a set of unique ids, when the same one shows up remove it
        //O(n) time and O(n) space
//        Set<Integer> unique = new HashSet<>();
//        for(int deliveryId : deliveryIds){
//            if(unique.contains(deliveryId)){
//                unique.remove(deliveryId);
//            }else {
//                unique.add(deliveryId);
//            }
//        }
//        return unique.iterator().next();
        int uniqueId = 0;
        for(int deliveryId : deliveryIds){
            uniqueId ^= deliveryId;
        }

        return uniqueId;
    }




    // tests

    @Test
    public void oneDroneTest() {
        final int expected = 1;
        final int actual = findUniqueDeliveryId(new int[] {1});
        assertEquals(expected, actual);
    }

    @Test
    public void uniqueIdComesFirstTest() {
        final int expected = 1;
        final int actual = findUniqueDeliveryId(new int[] {1, 2, 2});
        assertEquals(expected, actual);
    }

    @Test
    public void uniqueIdComesLastTest() {
        final int expected = 1;
        final int actual = findUniqueDeliveryId(new int[] {3, 3, 2, 2, 1});
        assertEquals(expected, actual);
    }

    @Test
    public void uniqueIdInTheMiddleTest() {
        final int expected = 1;
        final int actual = findUniqueDeliveryId(new int[] {3, 2, 1, 2, 3});
        assertEquals(expected, actual);
    }

    @Test
    public void manyDronesTest() {
        final int expected = 8;
        final int actual = findUniqueDeliveryId(new int[] {2, 5, 4, 8, 6, 3, 1, 4, 2, 3, 6, 5, 1});
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