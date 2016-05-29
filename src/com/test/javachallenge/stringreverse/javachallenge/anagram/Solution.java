package com.test.javachallenge.stringreverse.javachallenge.anagram;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by Raji on 4/2/2016.
 */
public class Solution {

    public static boolean isAnagram(String a, String b) {
        if (a.length() != b.length()){
            return false;
        }

        a = a.toLowerCase();
        b = b.toLowerCase();
        Map<Character, Integer> charCount1 = new HashMap<>();
        Map<Character, Integer> charCount2 = new HashMap<>();

        for (int i = 0; i < a.length(); i++){
            char c = a.charAt(i);
            if (charCount1.containsKey(c)){
                int count = charCount1.get(c);
                charCount1.put(c, ++count);
            } else {
                charCount1.put(c,1);
            }

            char d = b.charAt(i);
            if (charCount2.containsKey(d)){
                int count = charCount2.get(d);
                charCount2.put(d, ++count);
            } else {
                charCount2.put(d,1);
            }
        }
        if (charCount1.equals(charCount2)){
            return true;
        }

        return false;

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();
        boolean ret = isAnagram(a, b);
        if (ret) System.out.println("Anagrams");
        else System.out.println("Not Anagrams");

    }

}
