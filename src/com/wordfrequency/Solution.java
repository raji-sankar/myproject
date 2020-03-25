package com.wordfrequency;
import java.io.*;
import java.util.*;

/**
 * Word Count Engine
 * Implement a document scanning function wordCountEngine, which receives a string document and returns a list of all unique words in it and their number of occurrences, sorted by the number of occurrences in a descending order. If two or more words have the same count, they should be sorted according to their order in the original sentence. Assume that all letters are in english alphabet. You function should be case-insensitive, so for instance, the words “Perfect” and “perfect” should be considered the same word.
 *
 * The engine should strip out punctuation (even in the middle of a word) and use whitespaces to separate words.
 *
 * Analyze the time and space complexities of your solution. Try to optimize for time while keeping a polynomial space complexity.
 *
 * Examples:
 *
 * input:  document = "Practice makes perfect. you'll only
 *                     get Perfect by practice. just practice!"
 *
 * output: [ ["practice", "3"], ["perfect", "2"],
 *           ["makes", "1"], ["youll", "1"], ["only", "1"],
 *           ["get", "1"], ["by", "1"], ["just", "1"] ]
 * Important: please convert the occurrence integers in the output list to strings (e.g. "3" instead of 3). We ask this because in compiled languages such as C#, Java, C++, C etc., it’s not straightforward to create mixed-type arrays (as it is, for instance, in scripted languages like JavaScript, Python, Ruby etc.). The expected output will simply be an array of string arrays.
 *
 * Constraints:
 *
 * [time limit] 5000ms
 * [input] string document
 * [output] array.array.string
 */



class Solution {

    static String[][] wordCountEngine(String document) {
        // your code goes here
        if (document == null || document.length() == 0){
            return null;
        }

        Map<String,String> wordMap = new LinkedHashMap<>();
        String[] words = document.replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+");
        for(String word: words){
            int count = Integer.parseInt(wordMap.getOrDefault(word, "0"));
            count += 1;
            wordMap.put(word, Integer.toString(count));
        }
        int len = wordMap.keySet().size();
        String[][] output = new String[len][2];
        int i = 0;
        for (String key: wordMap.keySet()){
            String[] val = new String[2];
            val[0] = key;
            val[1] = wordMap.get(key);
            output[i] =   val;
            i++;
        }
        return output;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String document = "Practice makes perfect. you'll only get Perfect by practice. just practice!";
        String[][] output = solution.wordCountEngine(document);
        for (int i=0; i < output.length; i++){
            System.out.println(output[i][0] + " " + output[i][1]);
        }

    }

    static class WordCount implements Comparator<WordCount>{
        private String word;
        private int count;

        @Override
        public int compare(WordCount o1, WordCount o2) {
            return o1.count - o2.count;
        }
    }

}
