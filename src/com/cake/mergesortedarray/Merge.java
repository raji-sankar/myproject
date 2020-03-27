package com.cake.mergesortedarray;

import java.util.Arrays;

public class Merge {

    public static int[] mergeArrays(int[] array1, int[] array2){
        int[] merged = new int[array1.length + array2.length];

        int i = 0;
        int j = 0;
        int k = 0;
        while(k < merged.length){
            if(i < array1.length && j < array2.length) {
                if(array1[i] <= array2[j]){
                    merged[k] = array1[i];
                    i++;
                } else {
                    merged[k] = array2[j];
                    j++;
                }
            } else if(i == array1.length && j < array2.length){
                merged[k] = array2[j];
                j++;
            } else if(i < array1.length && j == array2.length){
                merged[k] = array1[i];
                i++;
            }
            k++;
        }

        return merged;
    }

    public static void main(String[] args) {
        int[] myArray = new int[]{3, 4, 6, 10, 11, 15};
        int[] alicesArray = new int[]{1, 5, 8, 12, 14, 19};

        System.out.println(Arrays.toString(mergeArrays(myArray, alicesArray)));

        int[] one = new int[]{1};
        int[] two = new int[] {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(mergeArrays(one, two)));

        int[] four = new int[]{1};
        int[] three = new int[] {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(mergeArrays(three, four)));

        int[] zero = new int[]{};
        int[] zero2 = new int[]{};
        System.out.println(Arrays.toString(mergeArrays(zero, zero2)));



    }
}
