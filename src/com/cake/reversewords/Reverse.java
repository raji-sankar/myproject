package com.cake.reversewords;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Reverse {

    public static void reverseWords2(char[] input){
        int len = input.length;

        List<String> words = new ArrayList<>();
        int begin = 0;
        String word = "";
        for(int i=0; i <len; i++){
            if(input[i] == ' '){
                if(word.length() > 0)
                    words.add(word);
                begin += i+1;
                word = "";
            } else {
                word = word + input[i];
            }
        }

        if(word.length() > 0)
            words.add(word);


        int start = 0;
        for(int i= words.size() - 1; i >= 0; --i){
            word = words.get(i);
            for(int j=0; j<word.length(); j++){
                input[start+j] = word.charAt(j);
            }
            start += word.length();
            if(i != 0){
                input[start] = ' ';
            }
            start += 1;


        }

    }

    private static void reverse(char[] input, int begin, int end){

        while(begin < end){
            char temp = input[begin];
            input[begin] = input[end];
            input[end] = temp;
            begin++;
            end--;
        }
    }

    public static void reverseWords(char[] input){
        //1. reverse input array
        reverse(input , 0, input.length -1);
        //2. now break up into smaller arrays and reverse them
        int begin = 0;
        for(int i=0; i< input.length; i++){
            if (input[i] == ' ' && i > begin){
                reverse(input, begin, i-1);
                begin = i + 1;
            }
        }
        reverse(input, begin, input.length - 1);

    }



    public static void main(String[] args) {
        char[] message = { 'c', 'a', 'k', 'e', ' ',
                'p', 'o', 'u', 'n', 'd', ' ',
                's', 't', 'e', 'a', 'l' };
        reverseWords(message);
        System.out.println(message);


        char[] blank = " ".toCharArray();
        reverseWords(blank);
        System.out.println(blank);

        char[] crazy = "This is crazy I like it".toCharArray();
        reverseWords(crazy);
        System.out.println(crazy);

        char[] yoda = "Wars not make one great".toCharArray();
        reverseWords(yoda);
        System.out.println(yoda);

        char[] end = "This is the end ".toCharArray();
        reverseWords(end);
        System.out.println(end);
    }
}
