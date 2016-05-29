package com.test.lonelyinteger;

import java.util.*;

/**
 * Created by Raji on 4/3/2016.
 */
public class Solution {
    static int lonelyinteger(int[] a) {
        Set<Integer> set = new HashSet();
        for (int x: a){
            if (set.contains(x)) {
                set.remove(x);
            } else {
                set.add(x);
            }
        }
        //set should only contain the one element
        Integer[] items = new Integer[set.size()];
        items =  set.toArray(items);
        return items[0];
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int res;

        int _a_size = Integer.parseInt(in.nextLine());
        int[] _a = new int[_a_size];
        int _a_item;
        String next = in.nextLine();
        String[] next_split = next.split(" ");

        for(int _a_i = 0; _a_i < _a_size; _a_i++) {
            _a_item = Integer.parseInt(next_split[_a_i]);
            _a[_a_i] = _a_item;
        }

        res = lonelyinteger(_a);
        System.out.println(res);

    }
}
