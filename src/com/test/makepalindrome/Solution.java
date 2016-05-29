package com.test.makepalindrome;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

/**
 * Created by Raji on 4/3/2016.
 */
public class Solution {
    public static void main(String[] args){
        try {
            Scanner in;
            if (args!=null && args.length>0 && args[0].equals("-d")){
                in = new Scanner(new File(args[1]));
            } else {
                in = new Scanner(System.in);
            }
            int n = in.nextInt();
            System.out.println(n);
            in.nextLine();
            for(int i=0; i<n; i++){
                String s = in.nextLine();
                System.out.println(s);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
