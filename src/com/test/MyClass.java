package com.test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Raji on 3/27/2016.
 */
public class MyClass {

    public static void main(String[] args) {
        int[][] twod = new int[3][];
        twod[0] = new int[]{5, 4};
        twod[1] = new int[]{2, 3};
        twod[2] = new int[]{5, 3};

        Arrays.sort(twod, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {

                if (Integer.valueOf(o1[0]) != (Integer.valueOf(o2[0]))){
                    return Integer.valueOf(o1[0]).compareTo(Integer.valueOf(o2[0]));
                } else {
                    return Integer.valueOf(o1[1]).compareTo(Integer.valueOf(o2[1]));
                }
            }

        });

        for(int i=0; i < twod.length; i++){
            System.out.println(Arrays.toString(twod[i]));
        }


    }
}
