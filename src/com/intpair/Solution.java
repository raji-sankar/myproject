package com.intpair;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        Map<Integer,Integer> countMap = new HashMap<>();
        for(int i=0; i < A.length; i++){
            int current = countMap.getOrDefault(A[i], 0);
            countMap.put(A[i], ++current);
        }
        for(int key: countMap.keySet()){
            int odd = countMap.get(key) % 2;
            if (odd == 1){
                return key;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] input = {90, 3, 90, 3, 9, 7, 9};
        Solution sol = new Solution();
        System.out.println(sol.solution(input));
    }
}
