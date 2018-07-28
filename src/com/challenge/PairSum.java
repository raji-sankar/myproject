package com.challenge;

import java.util.HashMap;
import java.util.Map;

public class PairSum {

    static boolean pairSumsToKSorted(int[] arr, int K){

        Map<Integer, Integer> map = new HashMap<>();
        for (int i =0; i < arr.length; i++){
            int count = 1;
//            if (map.get(i) != null){
//                count = map.get(i) + 1;
//            }
            map.put(arr[i], count);

        }

        for (int i = 0; i < arr.length; i++){

            if (map.get(K - arr[i]) != null){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {-2, 1, 2, 3, 4, 7, 9, 10, 15, 17};
        int K = 10;
        boolean result = pairSumsToKSorted(arr, K);
        System.out.println(result);
    }
}
