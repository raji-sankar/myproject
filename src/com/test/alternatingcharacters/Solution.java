package com.test.alternatingcharacters;

import java.util.Scanner;

/**
 * Created by Raji on 4/3/2016.
 */
public class Solution {

    public static int minDeletions(String s){
        int deletions = 0;
        char prev = s.charAt(0);
        for(int i=1; i<s.length(); i++){
            char next = s.charAt(i);
            if (prev == next){
                deletions++;
            }else {
                prev = next;
            }

        }
        return deletions;
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        for (int i=0; i<n; i++){
            String s = in.nextLine();
            System.out.println(minDeletions(s));
        }
    }
}
