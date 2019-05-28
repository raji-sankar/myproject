package com.test.morganstring;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    static String morganAndString(String a, String b) {
        StringBuffer sb = new StringBuffer();

        int i = 0, j = 0;
        while(i < a.length() && j < b.length()){
            if(a.charAt(i) < b.charAt(j)){
                sb.append(a.charAt(i));
                i++;
            } else if (a.charAt(i) > b.charAt(j)){
                sb.append(b.charAt(j));
                j++;
            } else {
                int x = i, y = j;
                char ca = a.charAt(i);
                for(; x < a.length() && y < b.length(); x++, y++){
                    if(a.charAt(x) != b.charAt(y)){
                        break;
                    } else if (a.charAt(x) > ca){
                        sb.append(a.substring(i, x)).append(b.substring(j, y));
                        i=x; j = y;
                        ca = a.charAt(x);
                    }
                }

                if(x == a.length()){
                    sb.append(b.charAt(j));
                    j++;
                } else if (y == b.length()){
                    sb.append(a.charAt(i));
                    i++;
                } else {
                    if(a.charAt(x) < b.charAt(y)){
                        sb.append(a.charAt(i));
                        i++;
                    } else {
                        sb.append(b.charAt(j));
                        j++;
                    }
                }

            }
        }
        sb.append(a.substring(i)).append(b.substring(j));
        return sb.toString();
    }

    // Complete the morganAndString function below.
    static String morganAndString_stack(String a, String b) {
        Stack<Character> astack = new Stack();
        Stack<Character> bstack = new Stack();
        StringBuffer result = new StringBuffer();

        char[] achars = a.toCharArray();
        for(int i= achars.length -1; i >= 0; i--){
            astack.push(achars[i]);
        }

        char[] bchars = b.toCharArray();
        for(int i=bchars.length -1; i >= 0; i--){
            bstack.push(bchars[i]);
        }

        while(!astack.empty() && !bstack.empty()){
            if(astack.peek() <= bstack.peek()) {
                result.append(astack.pop());
            }else {
                result.append(bstack.pop());
            }
        }

        while(!astack.empty()){
            result.append(astack.pop());
        }
        while(!bstack.empty()){
            result.append(bstack.pop());
        }

        return result.toString();

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String a = scanner.nextLine();

            String b = scanner.nextLine();

            String result = morganAndString(a, b);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}

