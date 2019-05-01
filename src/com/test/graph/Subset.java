package com.test.graph;

/**
 * Created by Raji on 5/30/2016.
 */
public class Subset {

    public static final int MAXCANDIDATES = 2;
    private boolean finished = false;

    public void backtrack(int[] a, int k, int n){
        int[] c = new int[MAXCANDIDATES];
        int ncandidates = 2;


        if(is_a_solution(a, k, n)){
            process_solution(a, k, n);
        } else {
            k = k + 1;
            construct_candidates(a, k, n, c);
            for (int i=0; i < ncandidates; i++){
                a[k] = c[i];
                backtrack(a, k, n);
                if (finished) return;
            }

        }


    }

    private void process_solution(int[] a, int k, int n) {int i; /* counter */
        System.out.printf("{");
        for (i=1; i<=k; i++)
            if (a[i] == 1) System.out.printf(" %d",i);
        System.out.printf(" }\n");
    }

    boolean is_a_solution(int[] a, int k, int n){
        return k == n;
    }

    void construct_candidates(int[] a, int k, int n, int[] c){
        c[0] = 1;
        c[1] = 0;
    }

    void generate_subset(int n){

        int[] a = new int[n+1];
        backtrack(a, 0, n);
    }

    public static void main(String[] args) {
        Subset sub = new Subset();
        sub.generate_subset(3);

    }

}
