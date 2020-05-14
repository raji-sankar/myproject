package com.uber.longestenvelopesequence;

// QUESTION:
//
// Given an array of envelopes, find the longest sequence
// such that you are able to fit a envelope inside another
// for all envelopes in that sequence.
//
// The envelopes can be rotated 90 degrees in order to fit inside another envelope.
// An envelope fits inside another if both side lengths are strictly less.
//
// Ex.
// Input =  { {2,2}, {10,10}, {1,2}, {10,8}, {9,9}, {20,20}, {3,8}, {6,1}, {7, 2}, {1,1}, {3,4}, {20,20} }
// Return: { {10,10}, {9,9}, {3,8}, {7,2}, {1,1} }

// 10,10 -> 1,2
// 10,10 -> 9,9
//              9,9  -> 3,8
//                          3,8 -> 6,1
//                          3,8 -> 7,2
//                                      7,2 -> 1,1
//                          3,8 -> 1,1
//              9,9  -> 6,1
//              9,9  -> 7,2
//                          7,2 -> 1,1
//              9,9  -> 1,1
//              9,9  -> 3,4
// 10,10 -> 3,8
// 10,10 -> 6,1
// 10,10 -> 7,2
// 10,10 -> 1,1
// 10,10 -> 3,4
//
// Input =  { {2,2}, {3,3}, {4,5}, {6,8}, {9,9}, {20,100} }
// Return: { any one element }

import java.util.ArrayList;

import java.util.List;

public class LongestSequence {

    static class Envelope{
        int h;
        int w;
        Envelope(int h, int w){
            this.h = h;
            this.w = w;
        }

        @Override
        public String toString() {
            return "{" + w + ", " + h + "}";
        }
    }

    public static boolean canFit(Envelope one, Envelope two){
        return (Math.max(one.h, one.w) > Math.max(two.h, two.w)  && Math.min(one.h, one.w) > Math.min(two.h, two.w));
    }

    public static List<Envelope> longestNestingSequence(Envelope[] input){
        List<Envelope> longestSeq = new ArrayList<>();

        List<List<Envelope>> sequences = new ArrayList<>();
        for(int k = input.length; k >=2; k--){
            if(sequences.size() > 0){
                break;
            }
            backtrack(0, k, input, new ArrayList<Envelope>(), sequences);
        }

        for(List<Envelope> envelopes: sequences){
            if(envelopes.size() >longestSeq.size()){
                longestSeq = envelopes;
            }
        }

        return longestSeq;
    }

    private static void backtrack(int index, int k, Envelope[] input, ArrayList<Envelope> envelopes, List<List<Envelope>> sequences) {
        if(envelopes.size() == k){

            sequences.add(new ArrayList<>(envelopes));
            return;
        }

        for(int i=index; i<input.length-1; i++){
            if((envelopes.size() > 0 &&  canFit(envelopes.get(envelopes.size() -1), input[i])) || envelopes.size() == 0) {
                envelopes.add(input[i]);
                backtrack(i + 1, k, input, envelopes, sequences);
                envelopes.remove(envelopes.size() - 1);
            }
        }


    }

    public static void main(String[] args) {

        // Input =  { {2,2}, {10,10}, {1,2}, {10,8}, {9,9}, {20,20}, {3,8}, {6,1}, {7, 2}, {1,1}, {3,4}, {20,20} }
        Envelope input[] = { new Envelope(2, 2),
                            new Envelope(10,10),
                            new Envelope(1,2),
                            new Envelope(10,8),
                            new Envelope(9,9),
                            new Envelope(20,20),
                            new Envelope(3,8),
                            new Envelope(6,1),
                            new Envelope(7, 2),
                            new Envelope(1,1),
                            new Envelope(3, 4),
                            new Envelope(20,20) };

        List<Envelope> envelopes = longestNestingSequence(input);
        envelopes.stream().forEach(System.out::println);
    }
}
