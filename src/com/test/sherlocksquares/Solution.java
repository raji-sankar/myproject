package com.test.sherlocksquares;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Raji on 5/28/2016.
 */
public class Solution {

    public static int countSquares(long a, long b){
        int n = 0;
        long j = a;
        while(j <= b){
            if (isCandidateSquare(j)) {
                int r = squareRoot(j);
                if (r != -1) {
                    n += 1;
                    j += 2 * r ;
                }
            }
            j += 1;
        }
        return n;

    }

    public static int squareRoot(long a){
        double b = Math.sqrt(a);
        int c = (int)Math.ceil(b);
        if ( c * c == a)
            return c;
        return -1;
    }

    public static boolean digitalRoot(long a){
        char[] charArr = String.valueOf(a).toCharArray();
        int sum = 0;
        for (int i = 0; i < charArr.length; i++){
            sum +=   Character.digit(charArr[i], 10);
        }
        if (sum > 9)
            return digitalRoot((long)sum);

        if ((sum == 1) || (sum == 4) || (sum == 9) || (sum == 7))
            return true;

        return false;
    }

    /**
     * Given a long a, returns whether it is a perfect square
     * @param a
     * @return
     */
    public static boolean isCandidateSquare(long a){
        List<Integer> squareDigits = new ArrayList<>();
        squareDigits.add(1);
        long x = a%10;
        if (x == 2 || x == 3 || x == 7 || x == 8  )
            return false;

        if ((x == 0) && (a % 100 == 0))
            return true;

        if ((x == 5) && (a % 100 == 25))
            return true;

        long y = (a/10)% 10;
        if (digitalRoot(a)){
            if ((((x == 9) ||  (x == 1) || (x == 4)) && (y %2 == 0)))
                return true;
            if ((x == 6) && (y % 2 == 1))
                return true;
            long z = a % 100;
            if (z%4 == 0)
                return true;
        }

        

        return false;

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i= 0; i < t; i++){
            long a = in.nextLong();
            long b = in.nextLong();

            System.out.println(countSquares(a, b));
        }

    }
}
