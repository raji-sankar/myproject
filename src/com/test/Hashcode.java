package com.test;

public class Hashcode {

    private static final int D = 256;
    private static final int q = 101;
    public static int computeHash(String s){


        int t = 0;
        for(int i=0; i<s.length(); i++){
            t = (D*t + s.charAt(i)) % q ;
        }

        return t;
    }

    public static void main(String[] args) {
        String s = "abc";
        String s1 = "bc";
        String s2 = "c";
        String s3 = "c";
        String s4 = "bc";
        int myhash1 = computeHash(s1);
        int myhash2 = computeHash(s2);
        int[] hashcodes = new int[3];
        hashcodes[0] = s.hashCode();
        hashcodes[1] = s1.hashCode();
        hashcodes[2] = s2.hashCode();
        int[] h = new int[s.length()];
        h[h.length-1] = 1;
        for (int i=h.length -2; i>=0; i--){
            h[i] = (h[i+1] * D) % q;

        }
        int[] hash = new int[s.length()];
        hash[0] = computeHash(s);
        for(int i=1; i<s.length(); i++){
            hash[i] =  (hash[i-1] - (s.charAt(i-1) * h[i-1])) % q ;
            hash[i] = (hash[i] < 0 ? hash[i] + q : hash[i]);
        }

        System.out.println(hash[0]);
        System.out.println(myhash1);
        System.out.println(myhash2);
        System.out.println(hash[1]);
        System.out.println(hash[2]);








    }
}
