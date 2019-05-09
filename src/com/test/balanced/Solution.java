package com.test.balanced;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Solution {
    private static final String[] OPEN = {"{", "[", "("};
    private static final String[] CLOSE = {"}", "]", ")"};

    public static boolean isBalanced(String input){

        Stack<Character> stack = new Stack();
        char[] chars = input.toCharArray();
        for(char ch : chars){
            if (ch == '{' || ch == '[' || ch == '('){
                stack.push(ch);
            } else if (ch == '}' || ch == ']' || ch == ')') {
                if (stack.empty())
                    return false;
                int index = Arrays.asList(CLOSE).indexOf(String.valueOf(ch));
                if (stack.peek() != OPEN[index].charAt(0))
                    return false;
                else
                    stack.pop();
            }
        }
        if (!stack.empty())
            return false;

        return true;

    }

    public static void main(String []argh)
    {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String input=sc.next();
            //Complete the code
            System.out.println(isBalanced(input));
        }

    }
}
