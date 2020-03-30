package com.cake.stringpermutation;

import java.util.Arrays;
import java.util.Collections;
import java.util.Set;
import java.util.HashSet;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static org.junit.Assert.*;

public class Solution {

    public static Set<String> getPermutations(String inputString) {

        // base case
        if (inputString.length() <= 1) {
            return new HashSet<>(Collections.singletonList(inputString));
        }

        Set<String> permutations = new HashSet<>();

        // generate all permutations of the input string

        char[] chars = inputString.toCharArray();

        getPermutations(chars, chars.length, permutations);


        return permutations;
    }

    private static void getPermutations(char[] chars, int n, Set<String> permutations){
        if(n == 1){
            permutations.add(new String(chars));
            return;
        }

        for(int i=0; i < n; i++){
            swap(chars, i, n-1);
            getPermutations(chars, n-1, permutations);
            swap(chars, i, n-1);
        }

    }

    private static void swap(char[] chars, int i, int n){
        char temp = chars[i];
        chars[i] = chars[n];
        chars[n] = temp;
    }



    // tests

    @Test
    public void emptyStringTest() {
        final Set<String> expected = new HashSet<>(Arrays.asList(""));
        final Set<String> actual = getPermutations("");
        assertEquals(expected, actual);
    }

    @Test
    public void oneCharacterStringTest() {
        final Set<String> expected = new HashSet<>(Arrays.asList("a"));
        final Set<String> actual = getPermutations("a");
        assertEquals(expected, actual);
    }

    @Test
    public void twoCharacterStringTest() {
        final Set<String> expected = new HashSet<>(Arrays.asList("ab", "ba"));
        final Set<String> actual = getPermutations("ab");
        assertEquals(expected, actual);
    }

    @Test
    public void threeCharacterStringTest() {
        final Set<String> expected = new HashSet<>(Arrays.asList("abc", "acb", "bac", "bca",
                "cab", "cba"));
        final Set<String> actual = getPermutations("abc");
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