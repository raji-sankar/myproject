package com.test.javachallenge.stringreverse.ipregex;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Created by Raji on 4/2/2016.
 */
public class Solution {

    public static void main(String []args)
    {
        Scanner in = new Scanner(System.in);
        while(in.hasNext())
        {
            String ip = in.next();

//            boolean match = Pattern.matches( "[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}", ip);
//            System.out.println(match);

            System.out.println(ip.matches(new myRegex().pattern));

        }

    }
}

class myRegex {
//    public String pattern = "[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}";
    public String pattern = "^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
        "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
        "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
        "([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";
}
