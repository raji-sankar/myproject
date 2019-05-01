package com.test.nondivisiblesubset;



import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Raji on 6/1/2016.
 */
public class RevisedSolution {

    public static final int MAXCANDIDATES = 2;
    private boolean finished = false;
    private List<int[]> solutions = new ArrayList<>();
    private int[] nondivsub;

    public void backtrack(int[] a, int k, int n, int[] input, int m){
        int[] c = new int[MAXCANDIDATES];
        int ncandidates = 2;


        if(is_a_solution(a, k, n)){
            process_solution(a, k, input, m);
        } else {
            if (finished) return;
            k = k + 1;
            construct_candidates(a, k, n, c);
            for (int i=0; i < ncandidates; i++){
                a[k] = c[i];
                backtrack(a, k, n, input, m);
                if (finished) return;
            }

        }


    }

    private void process_solution(int[] a, int k, int[] input, int m) {

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
        int[] sol = new int[thelist.size()];
        if(checkSubsetNonDivisible(thelist.size(), m, sol)){
            nondivsub = sol;
            finished = true;
            System.out.println(sol.length);
        }


    }

    boolean is_a_solution(int[] a, int k, int n){
        return k == n-1;
    }

    void construct_candidates(int[] a, int k, int n, int[] c){
        c[0] = 1;
        c[1] = 0;
    }

    public void generate_subset(int[] input, int m){
        int n = input.length;
        int[] a = new int[n];
        backtrack(a, -1, n, input, m);
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
        RevisedSolution sub = new RevisedSolution();
//        int[] input = {1, 7, 2, 4};
//        sub.generate_subset(input);
//        System.out.println(sub.solutions.size());
//        System.out.println(sub.solutions);


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
            sub.generate_subset(a, k);
//            System.out.println(nonDivisibleSubset(n, k, a));


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}

