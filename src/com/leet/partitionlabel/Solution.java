package com.leet.partitionlabel;



import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A string S of lowercase letters is given. We want to partition this string into as many parts as possible so that
 * each letter appears in at most one part, and return a list of integers representing the size of these parts.
 *
 * Example 1:
 * Input: S = "ababcbacadefegdehijhklij"
 * Output: [9,7,8]
 * Explanation:
 * The partition is "ababcbaca", "defegde", "hijhklij".
 * This is a partition so that each letter appears in at most one part.
 * A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits S into less parts.
 * Note:
 *
 * S will have length in range [1, 500].
 * S will consist of lowercase letters ('a' to 'z') only.
 */

public class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] maxPos = new int[26];
        char[] chars = s.toCharArray();
        for(int i=0; i<s.length(); i++){
            maxPos[chars[i] - 'a'] = i;
        }

        int anchor = 0;
        int j = 0;

        List<Integer> output = new ArrayList<>();
        for(int i=0; i<s.length(); i++){
            j = Math.max(j, maxPos[chars[i] -'a']);
            if (i == j){
                output.add(i -anchor + 1);
                anchor = i+1;
            }
        }

        return output;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.partitionLabels("ababcbacadefegdehijhklij"));
    }
}
