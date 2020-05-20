package com.leet.removeinvalidparentheses;

import java.util.*;

/**
 * 301. Remove Invalid Parentheses
 * Hard
 *
 * Remove the minimum number of invalid parentheses in order to make the input string valid. Return all possible results.
 *
 * Note: The input string may contain letters other than the parentheses ( and ).
 *
 * Example 1:
 *
 * Input: "()())()"
 * Output: ["()()()", "(())()"]
 * Example 2:
 *
 * Input: "(a)())()"
 * Output: ["(a)()()", "(a())()"]
 * Example 3:
 *
 * Input: ")("
 * Output: [""]
 */
public class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        if(s.length() == 0){
            result.add("");
            return result;
        }

        //1. Remove open paren at the end of the string
        s = removeOpenParenAtTheEnd(s);
        //2. remove close parentheses when there is no match
        s = removeCloseParenthesesWithNoMatch(s);
        //3.
        s = removeCloseParenthesesInBeginning(s);
        Set<String> valid = new HashSet<>();
        char[] chars = s.toCharArray();

        String current = "";

        backtrack(0, s, current, valid);


        int longest = 0;
        for(String paren: valid){
            longest = Math.max(longest, paren.length());
        }
        for(String paren: valid){
            if(paren.length() == longest){
                result.add(paren);
            }
        }
        if(result.size() == 0){
            result.add("");
        }
        return result;

    }

    private String removeOpenParenAtTheEnd(String s){
        while(s.length() > 0 && (s.lastIndexOf('(') == s.length() -1)){
            s = s.substring(0, s.length()-1);
        }

        return s;
    }

    private String removeCloseParenthesesWithNoMatch(String s){
        while(s.length() > 0 && (s.lastIndexOf(')') >= 0 && s.lastIndexOf('(') == -1)){
            int i = s.lastIndexOf(')') ;
            s = s.substring(0, i) + s.substring(i+1);
        }
        return s;
    }

    private String removeCloseParenthesesInBeginning(String s){
        while(s.length() > 0 && s.indexOf(')') > -1 && (s.indexOf(')') <  s.indexOf('('))){
            int i = s.indexOf(')') ;
            s = s.substring(0, i) + s.substring(i+1);
        }
        return s;
    }

    private void backtrack(int pos, String s, String current, Set<String> valid){

        if(isValid(current)){
            valid.add(current);
        }


        for(int i = pos; i < s.length(); i++){
            current = current + s.substring(i, i+1);
            backtrack(i+1, s, current, valid);
            current = current.substring(0, current.length() -1);
        }
    }

    private boolean isValid(String parens){
        if(parens == null || parens.length() == 0){
            return true;
        }
        Deque<Character> stack = new ArrayDeque();
        for(int i=0; i<parens.length(); i++){
            if(parens.charAt(i) == ')') {
                if(stack.isEmpty()){
                    return false;
                }else {
                    stack.pop();
                }
            } else if(parens.charAt(i) == '('){
                stack.push('(');
            }
        }
        if(!stack.isEmpty()){
            return false;
        }
        return true;
    }


    public static void main(String[] args) {
        Solution sol = new Solution();
//        System.out.println(sol.removeInvalidParentheses("x(123)"));
//        System.out.println(sol.removeInvalidParentheses(")t))()()bo)"));
        System.out.println(sol.removeInvalidParentheses("()())()"));
    }

}
