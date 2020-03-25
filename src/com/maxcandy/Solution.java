package com.maxcandy;

import java.util.*;

/**
 * Codlility
 * Mary has N candies. The i-th candy is of a type is represented by an integer T[i]
 * Mary's parents told her to share the candies with her brother. She must give him
 * exactly half the candies. Fortunately, the number of candies N is even.
 *
 * After giving away half the candies, Mary will eat the remaining ones. She likes variety,
 * so she want to have candies of various types. Can you find the maximum number of
 * different types of candy that Mary can eat?
 *
 * Write a function:
 * class Solution {public int solution(int[] T);}
 *
 * given an array of T of N integers, representing all types of candies, returns
 * the maximum possible number of different types of candy Mary can eat after
 * she has given N/2 candies to her brother.
 *
 * For example, given:
 *  T = [3, 4, 7, 7, 6, 6]
 *  the function should return 3. One optimal strategy for Mary is to give away
 *  one candy of type 4, one of type 7 and one of type 6. The remaining candies would be
 *  [3, 7, 6], candies of 3 different types.
 *
 *  Given:
 *  T = [80, 80, 1000, 80, 80, 80, 80, 80, 80, 12345]
 *  the function should also return 3. Here Mary starts with 10 candies. She can give away candies
 *  of type 80 and the remaining candies would be [1000, 80, 80, 80, 12345]. There are only
 *  three different types
 *
 *  Write an efficient algorithm for the following assumptions:
 *  1. N is an integer with the range [2..100000]
 *  2. N is even
 *  3. each element of array T is an integer within the range [1..1000000000]
 */

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] T) {
        // write your code in Java SE 8

        Map<Integer,Integer> candies = new HashMap<>();
        for(int i=0; i< T.length; i++){
            int count = candies.getOrDefault(T[i], 0);
            candies.put(T[i], ++count);
        }
        if (candies.keySet().size() >= T.length/2){
            return T.length/2;
        } else {
            return candies.keySet().size();
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] t = {3, 4, 7, 7, 6, 6};
        System.out.println(sol.solution(t));
        int[] p = {80, 80, 1000, 80, 80, 80, 80, 80, 80, 12345};
        System.out.println(sol.solution(p));
    }
}
