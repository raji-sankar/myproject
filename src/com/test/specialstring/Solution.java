package com.test.specialstring;

import java.io.*;
import java.util.*;

public class Solution {

    static long substrCount(int n, String s) {
        Map<String, Boolean> checked = new HashMap<>();
        long count = 0l;
        count += s.length();



       for(int j=0; j <= s.length() ; j++){
            int spCount = 0;
            int nonSpCount = 0;
            for(int i=2; j+i<=s.length(); i++){
                if((nonSpCount > 10 && nonSpCount > spCount) || (nonSpCount > 3 && spCount == 0 ) || (nonSpCount - spCount > 3)){
                    break;
                }
                String sub = s.substring(j, j+i);
                if(uniqueChars(sub) > 2){
                    break;
                }
                if(nonSpCount > 9){
                    System.out.println(sub );
                    System.out.println(nonSpCount + ", spCount = " + spCount);
                }

                Boolean special = checked.get(sub);
                if(special == null){
                    special = isSpecial(sub);
                    checked.put(sub, special);
                }
                if(special){
                    count++;
                    spCount++;
                } else{
                    nonSpCount++;
                }
            }

        }



        return count;
    }

    static int uniqueChars(String s){
        Set<Character> uniq = new HashSet<>();
        for(int i=0; i<s.length(); i++){
            uniq.add(s.charAt(i));
            if(uniq.size() > 2){
                break;
            }
        }
        return uniq.size();
    }

    static boolean isSpecial(String s) {
        //string s is special if all characters are same
        if (s.length() == 1) {
            return true;
        }
        char c = s.charAt(0);
        boolean allSame = true;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != c) {
                allSame = false;
                break;
            }
        }
        if (allSame) {
            return true;
        }

        if (s.length() % 2 == 0) {
            return false;
        }

        int midPoint = s.length() / 2;
        int left = 0;
        int right = s.length() - 1;
        while (left < right && left != midPoint && right != midPoint) {
            if (s.charAt(left) != s.charAt(right) || s.charAt(left) != s.charAt(0)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        long result = substrCount(n, s);
        System.out.println(result);
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
