package com.leet.lettercombinations;

import com.leet.addtwonumbers.Sol;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    static final String[] codes = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};


    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0){
            return new ArrayList<String>();
        } else {
            return getCombinations(digits);
        }


    }

    private List<String> getCombinations(String digits){
        if(digits.length() ==0){
            List<String> baseResult = new ArrayList<>();
            baseResult.add("");
            return baseResult;
        }
        char ch = digits.charAt(0);
        String remaining = digits.substring(1);
        List<String> prev = getCombinations(remaining);
        List<String> result = new ArrayList<>();
        String code = codes[ch - '0'];

        for(String val: prev){
            for(int i=0; i < code.length(); i++){
                result.add(code.charAt(i)+ val);
            }
        }



        return result;
    }


    public static void main(String[] args) {

        Solution sol = new Solution();
//        System.out.println(sol.letterCombinations("23"));
//        System.out.println(sol.letterCombinations("27"));
//        System.out.println(sol.letterCombinations(""));

        System.out.println(sol.letterCombinations("2365789345683"));

    }

}
