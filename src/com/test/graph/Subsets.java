package com.test.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Raji on 5/30/2016.
 */
public class Subsets {

    public static final int MAXCANDIDATES = 2;
    private boolean finished = false;
    private List<Integer[]> solutions = new ArrayList<>();

    public void backtrack(int[] a, int k, int n, int[] input){
        int[] c = new int[MAXCANDIDATES];
        int ncandidates = 2;


        if(is_a_solution(a, k, n)){
            process_solution(a, k, input);
        } else {
            k = k + 1;
            construct_candidates(a, k, n, c);
            for (int i=0; i < ncandidates; i++){
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
        for (int i=0; i <= k; i++) {
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

    boolean is_a_solution(int[] a, int k, int n){
        return k == n-1;
    }

    void construct_candidates(int[] a, int k, int n, int[] c){
        c[0] = 1;
        c[1] = 0;
    }

    public void generate_subset(int[] input){
        int n = input.length;
        int[] a = new int[n];
        backtrack(a, -1, n, input);
    }

    public List<Integer[]> getSolutions() {
        return solutions;
    }

    public static void main(String[] args) {
        Subsets sub = new Subsets();
        int[] input = {1, 7, 2, 4};
        sub.generate_subset(input);
        System.out.println(sub.solutions.size());
        System.out.println(sub.solutions);
    }

}
