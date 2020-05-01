package com.leet.minsteps;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 1347. Minimum Number of Steps to Make Two Strings Anagram
 * Medium
 *
 * 134
 *
 * 13
 *
 * Add to List
 *
 * Share
 * Given two equal-size strings s and t. In one step you can choose any character of t and replace it with another character.
 *
 * Return the minimum number of steps to make t an anagram of s.
 *
 * An Anagram of a string is a string that contains the same characters with a different (or the same) ordering.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "bab", t = "aba"
 * Output: 1
 * Explanation: Replace the first 'a' in t with b, t = "bba" which is anagram of s.
 * Example 2:
 *
 * Input: s = "leetcode", t = "practice"
 * Output: 5
 * Explanation: Replace 'p', 'r', 'a', 'i' and 'c' from t with proper characters to make t anagram of s.
 * Example 3:
 *
 * Input: s = "anagram", t = "mangaar"
 * Output: 0
 * Explanation: "anagram" and "mangaar" are anagrams.
 * Example 4:
 *
 * Input: s = "xxyyzz", t = "xxyyzz"
 * Output: 0
 * Example 5:
 *
 * Input: s = "friend", t = "family"
 * Output: 4
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 50000
 * s.length == t.length
 * s and t contain lower-case English letters only.
 */

public class Solution {
    public int minSteps(String s, String t) {
        Map<Character, Integer> sChars = new HashMap<>();
        Map<Character, Integer> tChars = new HashMap<>();

        for(int i=0; i< s.length(); i++){
            sChars.put(s.charAt(i), sChars.getOrDefault(s.charAt(i),0) + 1);
            tChars.put(t.charAt(i), tChars.getOrDefault(t.charAt(i),0) + 1);
        }
        int presentInT = 0;


        Set<Character> sKeySet = sChars.keySet();
        Set<Character> tKeySet = tChars.keySet();

        for(char c: sKeySet){
            if(tKeySet.contains(c)){
                presentInT += Math.min(sChars.get(c), tChars.get(c));
            }
        }


        return s.length() - presentInT;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.minSteps("leetcode", "practice"));
    }
}
