package com.test.nondivisiblesubset;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Raji on 5/29/2016.
 */

class Subsets {

    public static final int MAXCANDIDATES = 2;
    private boolean finished = false;
    private List<Integer[]> solutions = new ArrayList<>();

    public void backtrack(int[] a, int k, int n, int[] input) {
        int[] c = new int[MAXCANDIDATES];
        int ncandidates = 2;


        if (is_a_solution(a, k, n)) {
            process_solution(a, k, input);
        } else {
            k = k + 1;
            construct_candidates(a, k, n, c);
            for (int i = 0; i < ncandidates; i++) {
                a[k] = c[i];
                backtrack(a, k, n, input);
                if (finished) return;
            }

        }


    }

    private void process_solution(int[] a, int k, int[] input) {

        System.out.printf("{");
        int j = 0;
        List<Integer> thelist = new ArrayList<>();
        for (int i = 0; i <= k; i++) {
            if (a[i] == 1) {
                System.out.printf(" %d", input[i]);
                j = j + 1;
                thelist.add(input[i]);
            }
        }
        System.out.printf(" }\n");
        Integer[] sol = new Integer[thelist.size()];
        solutions.add(thelist.toArray(sol));

    }

    boolean is_a_solution(int[] a, int k, int n) {
        return k == n - 1;
    }

    void construct_candidates(int[] a, int k, int n, int[] c) {
        c[0] = 1;
        c[1] = 0;
    }

    public void generate_subset(int[] input) {
        int n = input.length;
        int[] a = new int[n];
        backtrack(a, -1, n, input);
    }

    public List<Integer[]> getSolutions() {
        return solutions;
    }

}
    public class AllSubsetSolution {

    public static int nonDivisibleSubset(int n, int k, int[] a){
        //largest subset has n-1 elements

        Subsets subsets = new Subsets();
        int max = -1;

        subsets.generate_subset(a);
        List<Integer[]> sols = subsets.getSolutions();

        for (Integer[] sol : sols){
            int[] mysol = new int[sol.length];
            if (sol.length >0) {
                for (int i = 0; i < sol.length; i++) {
                    mysol[i] = sol[i];
                }
                if (checkSubsetNonDivisible(mysol.length, k, mysol) && max < mysol.length) {
                    max = mysol.length;
                }
                if (max == n) {
                    return max;
                }
            }
        }

        return max;
    }

    public static boolean checkSubsetNonDivisible(int n, int k, int[] a){
        for (int i=0; i < n; i++){
            for(int j= i+1; j < n; j++ ){
                if ((a[i] + a[j]) % k == 0)
                    return false;
            }
        }
        return true;
    }



    public static void main(String[] args) {
        try {
            Scanner in;
            if (args!=null && args.length>0 && args[0].equals("-d")){

                in = new Scanner(new File(args[1]));

            } else {
                in = new Scanner(System.in);
            }
            int n = in.nextInt();
            int k = in.nextInt();
            int[] a = new int[n];
            for (int i=0; i <n; i++){
                a[i] = in.nextInt();
            }
            System.out.println(nonDivisibleSubset(n, k, a));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

}
