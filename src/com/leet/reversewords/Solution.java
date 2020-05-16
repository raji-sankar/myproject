package com.leet.reversewords;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 151. Reverse Words in a String
 * Medium
 * Given an input string, reverse the string word by word.
 *
 *
 *
 * Example 1:
 *
 * Input: "the sky is blue"
 * Output: "blue is sky the"
 * Example 2:
 *
 * Input: "  hello world!  "
 * Output: "world! hello"
 * Explanation: Your reversed string should not contain leading or trailing spaces.
 * Example 3:
 *
 * Input: "a good   example"
 * Output: "example good a"
 * Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
 */
public class Solution {

    public String reverseWords(String s) {
        if(s== null || s.length() == 0){
            return s;
        }
        s = reverseString(s);
        s = s.trim();
        List<String> words = new ArrayList<>();
        int begin = 0;
        for(int i=0; i<= s.length(); i++){
            if(i == s.length() || s.charAt(i) == ' ' ){
                String word = (reverseString(s.substring( begin, i))).trim();
                if(word.length() > 0) {
                    words.add(word);
                }
                begin = i+1;
            }
        }

        s = words.stream().collect(Collectors.joining(" "));


        return s;

    }

    private String reverseString(String s){
        char[] letters = s.toCharArray();
        int left = 0;
        int right = s.length() -1;
        while(left < right){
            char temp = letters[left];
            letters[left] = letters[right];
            letters[right] = temp;
            left++;
            right--;
        }

        return new String(letters);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.reverseWords("a good   example"));
    }
}
