package com.test.javachallenge.usernamechecker;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Raji on 4/2/2016.
 */
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());
        while (testCases > 0) {
            String username = in.nextLine();
//            String pattern = "^[a-zA-Z]+[a-zA-Z0-9_]{7,29}";
//            String pattern = "^(?=.{8,30}$)(?![_0-9])[a-zA-Z0-9_]";
//            String pattern = "^[a-zA-Z]([a-zA-Z0-9_]){7,29}";
            String pattern = "^(?=.{8,30}$)^[a-zA-Z]+([a-zA-Z0-9_]{7,29})$";
            Pattern r = Pattern.compile(pattern);
            Matcher m = r.matcher(username);
            if (m.find()){
                System.out.println("Valid");
            } else {
                System.out.println("Invalid");
            }

        }
    }
}
