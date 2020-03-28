package com.cake.wordcloud;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static org.junit.Assert.*;

public class Solution {

    public static class WordCloudData {

        private Map<String, Integer> wordsToCounts = new HashMap<>();

        public WordCloudData(String inputString) {
            populateWordsToCounts(inputString);
        }

        private void populateWordsToCounts(String inputString) {
            int startIndex = 0;
            int wordLetterCount = 0;
            for(int i=0; i < inputString.length(); i++){
                if (wordLetterCount == 0){
                    startIndex = i;
                }
                if(Character.isLetter(inputString.charAt(i))){
                    wordLetterCount++;
                } else if ((inputString.charAt(i) == '-' || inputString.charAt(i) == '\'')  && wordLetterCount > 0){
                    wordLetterCount++;
                } else if((inputString.charAt(i) == ' ' || inputString.charAt(i) == '.')&& wordLetterCount > 0){
                    addWordToMap(inputString.substring(startIndex, startIndex + wordLetterCount));
                    wordLetterCount = 0;
                }
            }
            if (wordLetterCount > 0){
                addWordToMap(inputString.substring(startIndex, startIndex + wordLetterCount));
            }

        }

        private void addWordToMap(String word){
            //handle case insensitive
            if(wordsToCounts.keySet().contains(word.toLowerCase())){
                wordsToCounts.put(word.toLowerCase(), wordsToCounts.get(word.toLowerCase()) + 1);
            } else if(wordsToCounts.keySet().contains(capitalizeWord(word))){
                wordsToCounts.put(word,wordsToCounts.get(capitalizeWord(word)) +1 );
                wordsToCounts.remove(capitalizeWord(word));

            }else {

                wordsToCounts.put(word, wordsToCounts.getOrDefault(word, 0) + 1);
            }


        }

        private String capitalizeWord(String word){
            return word.substring(0, 1).toUpperCase() + word.substring(1);
        }



        public Map<String, Integer> getWordsToCounts() {
            return wordsToCounts;
        }
    }



    // tests

    // There are lots of valid solutions for this one. You
    // might have to edit some of these tests if you made
    // different design decisions in your solution.

    @Test
    public void simpleSentenceTest() {
        final String text = "I like cake";
        final Map<String, Integer> expected = new HashMap<String, Integer>() { {
            put("I", 1);
            put("like", 1);
            put("cake", 1);
        }};
        final WordCloudData actual = new WordCloudData(text);
        assertEquals(expected, actual.getWordsToCounts());
    }

    @Test
    public void longerSentenceTest() {
        final String text = "Chocolate cake for dinner and pound cake for dessert";
        final Map<String, Integer> expected = new HashMap<String, Integer>() { {
            put("and", 1);
            put("pound", 1);
            put("for", 2);
            put("dessert", 1);
            put("Chocolate", 1);
            put("dinner", 1);
            put("cake", 2);
        }};
        final WordCloudData actual = new WordCloudData(text);
        assertEquals(expected, actual.getWordsToCounts());
    }

    @Test
    public void punctuationTest() {
        final String text = "Strawberry short cake? Yum!";
        final Map<String, Integer> expected = new HashMap<String, Integer>() { {
            put("cake", 1);
            put("Strawberry", 1);
            put("short", 1);
            put("Yum", 1);
        }};
        final WordCloudData actual = new WordCloudData(text);
        assertEquals(expected, actual.getWordsToCounts());
    }

    @Test
    public void hyphenatedWordsTest() {
        final String text = "Dessert - mille-feuille cake";
        final Map<String, Integer> expected = new HashMap<String, Integer>() { {
            put("cake", 1);
            put("Dessert", 1);
            put("mille-feuille", 1);
        }};
        final WordCloudData actual = new WordCloudData(text);
        assertEquals(expected, actual.getWordsToCounts());
    }

    @Test
    public void ellipsesBetweenWordsTest() {
        final String text = "Mmm...mmm...decisions...decisions";
        final Map<String, Integer> expected = new HashMap<String, Integer>() { {
            put("mmm", 2);
            put("decisions", 2);
        }};
        final WordCloudData actual = new WordCloudData(text);
        assertEquals(expected, actual.getWordsToCounts());
    }

    @Test
    public void apostrophesTest() {
        final String text = "Allie's Bakery: Sasha's Cakes";
        final Map<String, Integer> expected = new HashMap<String, Integer>() { {
            put("Bakery", 1);
            put("Cakes", 1);
            put("Allie's", 1);
            put("Sasha's", 1);
        }};
        final WordCloudData actual = new WordCloudData(text);
        assertEquals(expected, actual.getWordsToCounts());
    }

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(Solution.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
    }
}
