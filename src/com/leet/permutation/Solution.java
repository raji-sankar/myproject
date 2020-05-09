package com.leet.permutation;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Given a collection of distinct integers, return all possible permutations.
 *
 * Example:
 *
 * Input: [1,2,3]
 * Output:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 */
public class Solution {
    public static List<List<Integer>> permutations(int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null || nums.length == 0){
            return result;
        }
        permutate(nums, 0, result);

        return result;
    }

    private static void permutate(int[] nums, int pos, List<List<Integer>> result) {
        if(pos == nums.length){
            result.add(IntStream.of(nums).boxed().collect(Collectors.toList()));
        }
        for(int i=pos; i<nums.length; i++){
            swap(nums, i, pos);
            permutate(nums, pos+1, result);
            swap(nums, i, pos);
        }

    }

    private static void swap(int[] nums, int i, int pos) {
        int temp = nums[i];
        nums[i] = nums[pos];
        nums[pos] = temp;

    }

    public static List<String> stringPermutations(String input){
        List<String> output = new ArrayList<>();
        if(input == null || input.length() == 0){
            return output;
        }

        permutate(input, 0, output);
        return output;
    }

    private static void permutate(String input, int pos, List<String> output) {
        if(pos == input.length()){
            output.add(input);
        }
        for(int i=pos; i<input.length(); i++){
            input = swap(input, i, pos);
            permutate(input, pos+1, output);
            input = swap(input, i, pos);
        }
    }

    private static String swap(String input, int i, int j){
        if(i==j){
            return input;
        }
        char c = input.charAt(i);
        input = input.substring(0, i) + input.charAt(j) + input.substring(i+1);
        input = input.substring(0, j) + c + input.substring(j+1);
        return input;
    }

    public static void main(String[] args) {
        int nums[] = {1, 2, 3};
        List<List<Integer>> result = permutations(nums);
        result.forEach(System.out::println);

        List<String> stringPerms = stringPermutations("ABC");
        stringPerms.forEach(System.out::println);
    }
}
