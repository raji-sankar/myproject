package com.fb.oneeditaway;

/**
 * Write a function that returns whether two words are exactly "one edit" away using the following signature:
 * bool OneEditApart(string s1, string s2);
 * An edit is:
 * Inserting one character anywhere in the word (including at the beginning and end)
 * Removing one character
 * Replacing one character
 * Examples:
 * OneEditApart("cat", "dog") = false
 * OneEditApart("cat", "cats") = true
 * OneEditApart("cat", "cut") = true
 * OneEditApart("cat", "cast") = true
 * OneEditApart("cat", "at") = true
 * OneEditApart("cat", "act") = false
 */

public class Solution {
    boolean oneEditApart(String s1, String s2) {
        int d = 0;
        if (s1 == null || s2 == null) {
            return false;
        }
        if(Math.abs(s1.length() - s2.length()) > 1){
            return false;
        }
        if(s1.equals(s2)) return false;
        d = compareStrings(s1, s2, d);

        return d == 1 ? true : false;
    }

    private int compareStrings(String s1, String s2, int d) {
        if(s1.length() == s2.length()){

            for(int i=0; i< s1.length(); i++){
                if (s1.charAt(i) != s2.charAt(i)){
                    d++;
                }
            }

        } else {
            //one string is bigger than the other
            //remove the not matching character and try matching
            //use recursion
            String bigger = s1.length() > s2.length() ? s1 : s2;
            String smaller = bigger == s1 ? s2 : s1;

            for(int i=0; i<smaller.length(); i++){
                if (bigger.charAt(i) != smaller.charAt(i)){
                    d++;
                    return compareStrings(smaller, bigger.substring(0, i) + bigger.substring(i+1,bigger.length()), d);
                }
            }
            d++;
            return d;


        }
        return d;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.oneEditApart("cat", null));
        System.out.println(sol.oneEditApart("cat", "dog"));
        System.out.println(sol.oneEditApart("cat", "cat"));
        System.out.println(sol.oneEditApart("cat", "cut"));
        System.out.println(sol.oneEditApart("cat", "rat"));
        System.out.println(sol.oneEditApart("cat", "can"));
        System.out.println(sol.oneEditApart("cat", "cart"));
        System.out.println(sol.oneEditApart("scat", "cat"));
        System.out.println(sol.oneEditApart("cats", "cat"));
        System.out.println(sol.oneEditApart("cat", "act"));



    }
}
