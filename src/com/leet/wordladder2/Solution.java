package com.leet.wordladder2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 126. Word Ladder II
 * Hard
 * Given two words (beginWord and endWord), and a dictionary's word list, find all shortest transformation sequence(s) from beginWord to endWord, such that:
 *
 * Only one letter can be changed at a time
 * Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
 * Note:
 *
 * Return an empty list if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 * You may assume no duplicates in the word list.
 * You may assume beginWord and endWord are non-empty and are not the same.
 * Example 1:
 *
 * Input:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 *
 * Output:
 * [
 *   ["hit","hot","dot","dog","cog"],
 *   ["hit","hot","lot","log","cog"]
 * ]
 * Example 2:
 *
 * Input:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 *
 * Output: []
 *
 * Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
 */
public class Solution {

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> result = new ArrayList<>();
        if(wordList == null || wordList.size() == 0 ||  !(wordList.contains(endWord))){
            return result;
        }


        int index = wordList.indexOf(endWord);
        if(index > -1){
            wordList.remove(index);
            wordList.add(endWord);
        }
        index = wordList.indexOf(beginWord);
        if(index > -1){
            wordList.remove(index);
        }



        List<String> current = new ArrayList<>();
        current.add(beginWord);
        wordLadder(0, endWord, wordList, current, result);


        int min = wordList.size() + 1;
        for(List<String> wl: result){
            min = Math.min(wl.size(), min);
        }

        List<List<String>> output = new ArrayList<>();
        for(List<String> wl: result){
            if(wl.size() == min){
                output.add(wl);
            }
        }
        return output;

    }

    private void wordLadder(int pos, String endWord, List<String> wordList, List<String> current, List<List<String>>result){
        if((current.get(current.size() -1)).equals(endWord)){
            result.add(new ArrayList<>(current));
            return;
        }

        for(int i=pos; i < wordList.size(); i++){
            if(countDiff(current.get(current.size() -1), wordList.get(i)) == 1){
                current.add(wordList.get(i));
                wordLadder(i+1, endWord, wordList, current, result);
                current.remove(current.size() -1);
            }
        }


    }


    private int countDiff(String s1, String s2){
        if(s1.length() != s2.length()){
            return Math.max(s1.length(), s2.length());
        }
        int count = 0;
        for(int i=0; i<s1.length(); i++){
            if(s1.charAt(i) != s2.charAt(i)){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> wordList = Arrays.asList("hot","dot","dog","lot","log","cog");
//        List<List<String>> res = solution.findLadders("hit", "cog", wordList);
//        System.out.println(res.stream().collect(Collectors.toList()));

//        System.out.println(solution.findLadders("hot", "dog",
//                Arrays.asList("hot", "dog", "dot")).stream().collect(Collectors.toList()));
        List<String> wordList2 = new ArrayList<>(Arrays.asList("ted","tex","red","tax","tad","den","rex","pee"));


        System.out.println(solution.findLadders("red", "tax",
                wordList2).stream().collect(Collectors.toList()));
    }

}
