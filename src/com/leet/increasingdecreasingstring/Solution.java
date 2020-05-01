package com.leet.increasingdecreasingstring;

/**
 * 1370. Increasing Decreasing String
 * Easy
 *
 * 102
 *
 * 80
 *
 * Add to List
 *
 * Share
 * Given a string s. You should re-order the string using the following algorithm:
 *
 * Pick the smallest character from s and append it to the result.
 * Pick the smallest character from s which is greater than the last appended character to the result and append it.
 * Repeat step 2 until you cannot pick more characters.
 * Pick the largest character from s and append it to the result.
 * Pick the largest character from s which is smaller than the last appended character to the result and append it.
 * Repeat step 5 until you cannot pick more characters.
 * Repeat the steps from 1 to 6 until you pick all characters from s.
 * In each step, If the smallest or the largest character appears more than once you can choose any occurrence and append it to the result.
 *
 * Return the result string after sorting s with this algorithm.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "aaaabbbbcccc"
 * Output: "abccbaabccba"
 * Explanation: After steps 1, 2 and 3 of the first iteration, result = "abc"
 * After steps 4, 5 and 6 of the first iteration, result = "abccba"
 * First iteration is done. Now s = "aabbcc" and we go back to step 1
 * After steps 1, 2 and 3 of the second iteration, result = "abccbaabc"
 * After steps 4, 5 and 6 of the second iteration, result = "abccbaabccba"
 */

public class Solution {

    public String sortString(String s) {
        String result = "";
        char[] chars = s.toCharArray();

        for(int i=0; i<chars.length; i++){
            if (i == 3){
                break;
            }
            result = result + smallestCharacter(s.toCharArray(), null);
            s = s.substring(0, s.length()-1);
        }


        return result;

    }

    private Character smallestCharacter(char[] chars, Character a){
        Character min = null;
        for(char c: chars){
            if( c > a && ((min != null &&c < min) || min == null) ){
                min = c;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        String s = "aacbcddee";
        Solution sol = new Solution();
        System.out.println(sol.sortString(s));
    }
}
