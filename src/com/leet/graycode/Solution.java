package com.leet.graycode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 89. Gray Code
 * Medium
 *
 * Share
 * The gray code is a binary numeral system where two successive values differ in only one bit.
 *
 * Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.
 *
 * Example 1:
 *
 * Input: 2
 * Output: [0,1,3,2]
 * Explanation:
 * 00 - 0
 * 01 - 1
 * 11 - 3
 * 10 - 2
 *
 * For a given n, a gray code sequence may not be uniquely defined.
 * For example, [0,2,3,1] is also a valid gray code sequence.
 *
 * 00 - 0
 * 10 - 2
 * 11 - 3
 * 01 - 1
 * Example 2:
 *
 * Input: 0
 * Output: [0]
 * Explanation: We define the gray code sequence to begin with 0.
 *              A gray code sequence of n has size = 2^n, which for n = 0 the size is 2^0 = 1.
 *              Therefore, for n = 0 the gray code sequence is [0].
 */

public class Solution {
    public List<Integer> grayCode(int n) {

        char[] chars = new char[n];
        Arrays.fill(chars, '0');
        List<Integer> result = new ArrayList<>();
        if(n == 0){
            result.add(0);
            return result;
        }
        for(int k=0; k <= n; k++) {
            backtrack(0, k, chars, result);
        }
//        backtrack(0, 2, chars, result);
        return result;

    }

    void backtrack(int index, int k, char[] chars, List<Integer> result){
        if(countBits(chars) == k) {
            String st = new String(chars);
            int num = Integer.parseInt(st, 2);
            if(!result.contains(Integer.valueOf(num))) {
                result.add(Integer.valueOf(num));
            }
        }

        for(int i=index; i<chars.length; i++){
            setBit(chars.length -1 - i, chars);
            backtrack(i+1, k, chars, result);
            unsetBit(chars.length  -1 - i, chars);
        }
    }

    void setBit(int i, char[] chars){
        chars[i] = '1';
    }

    void unsetBit(int i, char[] chars){
        chars[i] = '0';
    }

    int countBits(char chars[]){
        int count = 0;
        for(char c: chars){
            if(c == '1'){
                count++;
            }
        }
        return count;
    }

    List<Integer> grayCodeSimple(int n){
        List<Integer> codes = new ArrayList<>();
        for(int i=0; i < (1 << n); i++){
            codes.add(i ^ (i >>1));
        }
        return codes;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<Integer> result =  solution.grayCodeSimple(3);
        result.stream().forEach(System.out::println);

//        System.out.println(solution.countBits(new char[] {'1' , '1'}));
    }
}
