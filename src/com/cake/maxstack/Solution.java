package com.cake.maxstack;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import java.util.Stack;



import static org.junit.Assert.*;

public class Solution {

    // fill in the definitions for push(), pop(), and getMax()


    public static class MaxStack {
        private Stack<Integer> stack;

        private int max;

        public MaxStack(){
            stack = new Stack<>();
        }

        public void push(int item) {
            max = Math.max(max, item);
            stack.push(item);
        }

        public int pop() {
            int popped = stack.pop();
            if(popped == max){
                recalculateMax();
            }
            return popped;
        }

        public int getMax() {

            return max;
        }

        private void recalculateMax(){
            Stack<Integer> temp = new Stack<>();
            max = 0;
            while(!stack.empty()){
                int x = stack.pop();
                max = Math.max(max, x);
                temp.push(x);
            }
            while(!temp.empty()){
                stack.push(temp.pop());
            }
        }
    }





    // tests

    @Test
    public void maxStackTest() {
        final MaxStack s = new MaxStack();
        s.push(5);
        assertEquals("check max after 1st push", 5, s.getMax());
        s.push(4);
        s.push(7);
        s.push(7);
        s.push(8);
        assertEquals("check before 1st pop", 8, s.getMax());
        assertEquals("check pop #1", 8, s.pop());
        assertEquals("check max after 1st pop", 7, s.getMax());
        assertEquals("check pop #2", 7, s.pop());
        assertEquals("check max after 2nd pop", 7, s.getMax());
        assertEquals("check pop #3", 7, s.pop());
        assertEquals("check max after 3rd pop", 5, s.getMax());
        assertEquals("check pop #4", 4, s.pop());
        assertEquals("check max after 4th pop", 5, s.getMax());
    }

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(Solution.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
    }
}