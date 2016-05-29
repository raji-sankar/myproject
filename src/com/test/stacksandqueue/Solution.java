package com.test.stacksandqueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by Raji on 4/9/2016.
 */
public class Solution {
    private Stack<Character> stack = new Stack<>();
    private Queue<Character> queue = new LinkedList<>();

    void pushCharacter(char ch){
        stack.push(ch);
    }

    void enqueueCharacter(char ch){
        queue.add(ch);
    }

    char popCharacter(){
        return stack.pop();
    }

    char dequeueCharacter(){
        return queue.poll();
    }
}
