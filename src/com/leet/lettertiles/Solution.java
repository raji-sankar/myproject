package com.leet.lettertiles;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int numTilePossibilities(String tiles) {
        Set<String> poss = possibilities(tiles);
        return poss.size();

    }

    private Set<String> possibilities(String tiles){
        if(tiles.length() == 1){
            return new HashSet<>(Collections.singletonList(tiles));
        } else {
            int len = tiles.length();
            String exceptLastChar = tiles.substring(0, len -1);
            String lastChar = tiles.substring(len -1, len);
            Set<String> allPermsExceptLast = possibilities(exceptLastChar);
            Set<String> allPerms = new HashSet<>();

            for(String perm: allPermsExceptLast){
                for(int i=0; i<len ; i++){
                    String p = perm.substring(0, i) + lastChar + perm.substring(i, len-1);
                    allPerms.add(p);
                }
            }
            return allPerms;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String tiles  = "AAB";
        System.out.println(sol.numTilePossibilities(tiles));
    }
}
