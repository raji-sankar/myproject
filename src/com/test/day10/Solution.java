package com.test.day10;

import java.util.Scanner;

/**
 * Created by Raji on 4/2/2016.
 */
public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        String bin = Integer.toBinaryString(n);
        int max = 0;
        int current_count = 0;
        for (int i=0; i < bin.length(); i++){
            if (bin.charAt(i) == '1'){
                current_count++;
            } else {
                if (current_count > max){
                    max = current_count;
                }
                current_count = 0;
            }
        }
        if (current_count > max){
            max = current_count;
        }
        System.out.println(max);
    }
}
