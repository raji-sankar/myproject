package com.test.codility.min_avg_slice;
/*
A non-empty array A consisting of N integers is given. A pair of integers (P, Q), such that 0 ≤ P < Q < N, is called a slice of array A (notice that the slice contains at least two elements). The average of a slice (P, Q) is the sum of A[P] + A[P + 1] + ... + A[Q] divided by the length of the slice. To be precise, the average equals (A[P] + A[P + 1] + ... + A[Q]) / (Q − P + 1).

For example, array A such that:

    A[0] = 4
    A[1] = 2
    A[2] = 2
    A[3] = 5
    A[4] = 1
    A[5] = 5
    A[6] = 8
contains the following example slices:

slice (1, 2), whose average is (2 + 2) / 2 = 2;
slice (3, 4), whose average is (5 + 1) / 2 = 3;
slice (1, 4), whose average is (2 + 2 + 5 + 1) / 4 = 2.5.
The goal is to find the starting position of a slice whose average is minimal.

Write a function:

class Solution { public int solution(int[] A); }

that, given a non-empty array A consisting of N integers, returns the starting position of the slice with the minimal average. If there is more than one slice with a minimal average, you should return the smallest starting position of such a slice.

For example, given array A such that:

    A[0] = 4
    A[1] = 2
    A[2] = 2
    A[3] = 5
    A[4] = 1
    A[5] = 5
    A[6] = 8
the function should return 1, as explained above.

Assume that:

N is an integer within the range [2..100,000];
each element of array A is an integer within the range [−10,000..10,000].
Complexity:

expected worst-case time complexity is O(N);
expected worst-case space complexity is O(N) (not counting the storage required for input arguments).
 */

import java.util.Arrays;

public class Solution {

    public int solution(int[] A){
        int min_i = -1;
        double min = 100000.0;
        for(int i=0; i<A.length -1; i++){
            if ((A[i] + A[i+1])/2.0 < min){
                min_i = i;
                min = (A[i] + A[i+1])/2.0;
            }
            if (i < A.length -2 && ((A[i] + A[i+1] + A[i+2])/3.0) < min){
                min_i = i;
                min = (A[i] + A[i+1] + A[i+2])/3.0;
            }
        }
        return min_i;
    }

    public int not_optimal_solution(int[] A) {
        System.out.println(Arrays.toString(A));
        int[] sum = new int[A.length];
        sum[0] = A[0];
        for (int i = 1; i < A.length; i++) {
            sum[i] = sum[i - 1] + A[i];
        }
        double min = (double)sum[A.length-1]/A.length;
        int min_i = -1;

        double avg = min;
        int[][] subset_sum = new int[A.length][A.length];

        for (int i = 0; i < A.length - 1; i++) {
//            if (A[i] > min) continue;
            subset_sum[i][i] = A[i];
            for (int j = i + 1; j < A.length; j++) {
//                if (A[j] > avg) break;
                subset_sum[i][j] = subset_sum[i][j-1] + A[j];
                if (A[j] >= min) continue;

                avg = (double)subset_sum[i][j]/(j - i + 1);
//                if (i > 0) {
//                    avg = ((double) sum[j] - sum[i - 1]) / (j - i + 1);
//                } else {
//                    avg = (double) sum[j] / (j + 1);
//                }
                if (avg < min) {
                    min = avg;
                    min_i = i;


                }
                System.out.format("sum[%d][%d]= %d, avg = %f , min = %f, i = %d, j = %d%n", i, j,subset_sum[i][j], avg, min, i, j);
            }

        }

        return min_i;
    }


    public int solution_1(int[] A){

        int[] sum = new int[A.length];
        sum[0] = A[0];
        for (int i=1; i < A.length ; i++){
            sum[i] = sum[i-1]  + A[i];
        }
        double min = 1000000;
        int min_i = -1;
        for (int i=0; i<A.length -1; i++){

            for(int j=i+1; j< A.length; j++){
                double avg = 0.0;
                if (i > 0) {
                    avg = ((double) sum[j] - sum[i - 1]) / (j - i + 1);
                } else {
                    avg = (double)sum[j]/(j+1);
                }
                if (avg < min){
                    min = avg;
                    min_i = i;
                }
            }


        }


        return min_i;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(new int[] {4, 2, 2, 5, 1, 5, 8}));
        System.out.println(sol.solution(new int[] {1, 2, 2, 5}));
        System.out.println(sol.solution(new int[] {5, 1, 2, 2}));

        System.out.println(sol.solution(new int[] {5, 5, 2, 2, 1}));
    }
}
