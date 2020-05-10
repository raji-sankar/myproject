package com.interviewbit.palindromepartition;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    public ArrayList<ArrayList<String>> partition(String a) {
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        if(a == null || a.length() == 0){
            return result;
        }

        backtrack(a, 0, new ArrayList<String>(), result);
        //have some sorting to satisfy the rules
        return result;
    }

    private void backtrack(String s, int pos, ArrayList<String> current, ArrayList<ArrayList<String>> result){

        if(pos >= s.length()){
            result.add(new ArrayList<>(current));
            return;
        }

        for(int i=pos; i<s.length(); i++){
            if(isPalindrome(s.substring(pos, i+1))) {

                current.add(s.substring(pos, i+1));
                backtrack(s, i + 1, current, result);
                current.remove(current.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s){

        int start = 0;
        int end = s.length() -1;
        while(start < end){
            if(s.charAt(start) == s.charAt(end)){
                start++;
                end--;
            } else {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        ArrayList<ArrayList<String>> result = sol.partition("aab");
        result.forEach(System.out::println);

    }
}
