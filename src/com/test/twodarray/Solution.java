package com.test.twodarray;

import java.util.Scanner;

/**
 * Created by Raji on 4/2/2016.
 */
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int arr[][] = new int[6][6];
        for(int i=0; i < 6; i++){
            for(int j=0; j < 6; j++){
                arr[i][j] = in.nextInt();
            }
        }

        int max_hourglass_sum = -82;
        int hour_glass_sum = -82;

        for (int i = 0; i < 4; i++){
            for (int j=0; j < 4; j++){
                if (max_hourglass_sum < hour_glass_sum){
                    max_hourglass_sum = hour_glass_sum;
                }
                hour_glass_sum = 0;
                for (int k=0; k < 3; k++) {
                    for (int m = 0; m < 3; m++) {
                        if (k == 1 &&(( m == 0) || (m == 2))){
                            //do nothing
                        } else {
                            hour_glass_sum += arr[i + k][j + m];
                        }
                    }
                }
            }

        }
        if (max_hourglass_sum < hour_glass_sum){
            max_hourglass_sum = hour_glass_sum;
        }
        System.out.println(max_hourglass_sum);
    }
}
