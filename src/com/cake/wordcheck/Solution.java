package com.cake.wordcheck;

import org.junit.platform.commons.util.StringUtils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {

    public static boolean wordSearch(Set<String> dictionary, String word){
        if(word == null || word.length() == 0){
            return true;
        }

        for(int i=0; i<=word.length(); i++){
            if(dictionary.contains(word.substring(0, i)) && wordSearch(dictionary, word.substring(i))){
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Set<String> dictionary = new HashSet<>();
        String[] dict = {"i", "like", "sam", "sung", "samsung", "mobile", "ice", "cream", "icecream", "man", "go", "mango"};
        dictionary.addAll(Arrays.asList(dict));
//        System.out.println(wordSearch(dictionary, "ilike"));
//        System.out.println(wordSearch(dictionary, "ilikethis"));
        System.out.println(wordSearch(dictionary, "saman"));
    }
}
