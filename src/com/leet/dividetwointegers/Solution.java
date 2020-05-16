package com.leet.dividetwointegers;

/**
 * 29. Divide Two Integers
 * Medium
 *
 * Given two integers dividend and divisor, divide two integers without using multiplication, division and mod operator.
 *
 * Return the quotient after dividing dividend by divisor.
 *
 * The integer division should truncate toward zero, which means losing its fractional part. For example, truncate(8.345) = 8 and truncate(-2.7335) = -2.
 *
 * Example 1:
 *
 * Input: dividend = 10, divisor = 3
 * Output: 3
 * Explanation: 10/3 = truncate(3.33333..) = 3.
 * Example 2:
 *
 * Input: dividend = 7, divisor = -3
 * Output: -2
 * Explanation: 7/-3 = truncate(-2.33333..) = -2.
 * Note:
 *
 * Both dividend and divisor will be 32-bit signed integers.
 * The divisor will never be 0.
 * Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. For the purpose of this problem, assume that your function returns 231 − 1 when the division result overflows.
 */

public class Solution {

    public static int divide(int dividend, int divisor) {
        int answer = 0;
        if( divisor == 0){
            return answer;
        }
        if(dividend == Integer.MIN_VALUE && divisor == -1){
            return Integer.MAX_VALUE;
        }


        boolean negative = (dividend < 0) ^ (divisor < 0);

        if(Math.abs(divisor) == 1){
            return negative ? 0 - Math.abs(dividend) : Math.abs(dividend);
        }


        long output = 0l;
        long num = Math.abs((long)dividend);
        long denom = Math.abs((long)divisor);
        while(num >= denom){
            num = num - denom;
            output++;
        }
        if(output > Integer.MAX_VALUE || output < Integer.MIN_VALUE){
            output = Integer.MAX_VALUE;
        }
        return negative ? 0 - (int)output : (int)output;

    }

    public static void main(String[] args) {
        System.out.println(divide(-2147483648, 2));
    }
}
