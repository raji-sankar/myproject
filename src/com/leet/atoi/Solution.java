package com.leet.atoi;

import java.text.MessageFormat;

public class Solution {

    /**
     * Implement atoi which converts a string to an integer.
     *
     * The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.
     *
     * The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.
     *
     * If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.
     *
     * If no valid conversion could be performed, a zero value is returned.
     *
     * Note:
     *
     * Only the space character ' ' is considered as whitespace character.
     * Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. If the numerical value is out of the range of representable values, INT_MAX (231 − 1) or INT_MIN (−231) is returned.
     * Example 1:
     *
     * Input: "42"
     * Output: 42
     * Example 2:
     *
     * Input: "   -42"
     * Output: -42
     * Explanation: The first non-whitespace character is '-', which is the minus sign.
     *              Then take as many numerical digits as possible, which gets 42.
     * Example 3:
     *
     * Input: "4193 with words"
     * Output: 4193
     * Explanation: Conversion stops at digit '3' as the next character is not a numerical digit.
     * Example 4:
     *
     * Input: "words and 987"
     * Output: 0
     * Explanation: The first non-whitespace character is 'w', which is not a numerical
     *              digit or a +/- sign. Therefore no valid conversion could be performed.
     * Example 5:
     *
     * Input: "-91283472332"
     * Output: -2147483648
     * Explanation: The number "-91283472332" is out of the range of a 32-bit signed integer.
     *              Thefore INT_MIN (−231) is returned.
     * @param str
     * @return
     */

    public int myAtoi(String str) {


        //1. trim whitespace
        //2. Find first character - has to be [0-9+-], else return 0
        //3. Ignore '+' and '0' first character
        //4. If '-' set negative boolean to true
        //5. for loop from index 1 to end of string
        //6. Append 0 to string only if string length > 0 to prevent 0 padded strings
        //7. Append 1 - 9
        //8. Any other character break out of the for loop
        //9. convert resulting string of length < 11 to long
        //10. if long value exceeds Integer.MAX, return Integer.MAX
        //11. If long value less than Integer.MIN return Integer.MIN
        //12. else return int value
        str = str.trim();
        if (str == ""){
            return 0;
        }
        boolean negative = false;
        StringBuffer buf = new StringBuffer();

        char first = str.charAt(0);
        if (first != 43 && first != 45 && (first > 57 || first < 48)){
            return 0;
        } else if (first == 45){
            negative = true;
            //0 and + can be ignored
        } else if( (first > 48 && first <= 57) ){
            buf.append(first);
        }
        char[] validChars = {'+', '-', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        for(int i = 1; i < str.length(); i++){
            char x = str.charAt(i);
            if (x == 48){
                //append only if preceding characters are non-zero
                String temp = buf.toString();
                if (temp.length() > 0 ){
                    buf.append(x);
                }
            } else if( (x > 48 && x <= 57) ){
                buf.append(x);
            } else {
                break;
            }
        }

        String val = buf.toString();
        if (val.length() > 0 && val.length() < 11) {
            long resultVal = Long.parseLong(val);
            resultVal = negative ? resultVal * -1 : resultVal;
            if (resultVal > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            if (resultVal < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }

            return (int) resultVal;
        } else if(val.length() >= 11) {
            return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        } else {
            return 0;
        }

    }

    public static void output(String input, int expected){
        //given an input computes myAtoi and asserts expected
        Solution sol = new Solution();
        int i = sol.myAtoi(input);
        System.out.println("Input "  + input + ", output " +  i);
        System.out.println(MessageFormat.format("Input {0}, output {1}", input, i));

    }

    public static void main(String[] args) {
        output("-0", 0);
        output("+", 0);
        output("-", 0);
        output( "", 0);
        output("42", 42);
        output("-42", -42);
        output("+42", 42);
        output("4193 with words", 4193);
        output("words and 987", 0);
        output("-91283472332", -2147483648);
        output("20000000000000000000", Integer.MAX_VALUE);
        output("  0000000000012345678", 12345678);
        output("1234567890123456789012345678901234567890", Integer.MAX_VALUE);
        output("000000000000000000000000000000000000000010000000000000000000000000", Integer.MAX_VALUE);
    }
}
