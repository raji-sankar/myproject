package com.cake.matchingparen;


import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static org.junit.Assert.*;

public class Solution {

    public static int getClosingParen(String sentence, int openingParenIndex) {

        // find the position of the matching closing parenthesis
        // find the position of the matching closing parenthesis
        int openNestedParens = 0;
        for(int i = openingParenIndex+1; i< sentence.length(); i++){
            if(sentence.charAt(i) == '('){
                openNestedParens++;
            }else if(sentence.charAt(i) == ')'){
                if(openNestedParens == 0){
                    return i;
                }else {
                    openNestedParens--;
                }
            }
        }
        throw new IllegalArgumentException("No closing parentheis :(");
    }




    // tests

    @Test
    public void allOpenersThenClosersTest() {
        final int expected = 7;
        final int actual = getClosingParen("((((()))))", 2);
        assertEquals(expected, actual);
    }

    @Test
    public void mixedOpenersAndClosersTest() {
        final int expected = 10;
        final int actual = getClosingParen("()()((()()))", 5);
        assertEquals(expected, actual);
    }

    @Test(expected = Exception.class)
    public void noMatchingCloserTest() {
        getClosingParen("()(()", 2);
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
