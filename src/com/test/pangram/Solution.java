package com.test.pangram;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by Raji on 4/3/2016.
 */
public class Solution {

    public static boolean isPangram(String s){
        s = s.toLowerCase();
        s = s.replaceAll(" ", "");
        Set<Character> letters = new HashSet<>();
        for (int i=0; i < s.length(); i++){
            char c = s.charAt(i);
            letters.add(c);
        }

        if (letters.size() == 26){
            return true;
        }
        return false;

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();

        if (isPangram(s)){
            System.out.println("pangram");
        } else {
            System.out.println("not pangram");
        }
    }
}
