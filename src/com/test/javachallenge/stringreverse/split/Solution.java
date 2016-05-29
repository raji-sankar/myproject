package com.test.javachallenge.stringreverse.split;

import java.util.Scanner;

/**
 * Created by Raji on 4/2/2016.
 */
public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        str = str.trim();
        if (str.length() == 0) {
            System.out.println(0);
        } else {
            String[] parts = str.split("[ !,?._'@]+");
            System.out.println(parts.length);
            for (String part : parts) {
                System.out.println(part);
            }
        }

    }

}
