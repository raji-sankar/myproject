package com.leet.longestsubstr;
/*
Given a string, find the length of the longest substring without repeating characters.

Example 1:

Input: "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
             Note that the answer must be a substring, "pwke" is a subsequence and not a substring.

 */

import java.util.*;

public class Solution {

    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }

    public int ar_lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        int[] index = new int[128]; // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            i = Math.max(index[s.charAt(j)], i);
            ans = Math.max(ans, j - i + 1);
            index[s.charAt(j)] = j + 1;
        }
        return ans;
    }

    public int bruteLengthOfLongestSubstring(String s) {
        if (s == null || s == "") return 0;

        char[] chars = s.toCharArray();

        int[] values = new int[s.length() ];

        for (int i = values.length; i >= 1; --i){
            int numCandidates = chars.length - i + 1;
            char[][] candidates = new char[numCandidates][i];
            for (int j = 0; j < numCandidates; j++){
                candidates[j] = Arrays.copyOfRange(chars, j, i+j);
                char[] candidate = candidates[j];
                if (isSolution(candidate))  return i;
            }
        }

        return 0;
    }



    private boolean isSolution(char[] candidate) {
        boolean unique = true;

        Map<Character, Integer> charMap = new HashMap<>();
        for (char c : candidate){
            if (charMap.get(c) != null) return false;
            charMap.put(c, 1);
        }

        return unique;
    }

    public static void main(String[] args){
        Solution sol = new Solution();

        System.out.println(sol.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(sol.lengthOfLongestSubstring("bbbbb"));
        System.out.println(sol.lengthOfLongestSubstring("pwwkew"));

    }


}
