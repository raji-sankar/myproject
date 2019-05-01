package com.test.td.task3;
/*
Write a class Solution that implements a stack data structure. The data structure will hold positive
integers within the range [1..1,000,000,000] and should implement the following stack operations:

1. push(value): Pushes an elment value to the stack
2. top(): returns the topmost element (without removing it from the stack), or 0 if the stack is empty
3. pop(): Removes the topmost element from the stack, or does nothing if the stack is empty

In addition to the above operations, the stack should also support transactions by implementing the
following operations:
1. begin(): opens a new transaction block. Transaction blocks can be nested; a begin()
can be issued inside another existing block. Note that no transaction is in progress before the
first begin() call.
2. rollback(): Undoes every stack operation issued in the current transaction block, and closed the block. Returns
true if successful, false if no transaction is in progress.
3. commit(): Applies every stack operation issued in the current transaction block, and closes the block.
Returns true if successful, or false if no transaction is in progress.

During the assessment of your program, a single test will execute N operation, where N is at most 100,000.
During the assessment there can be more than one instance of class Solution working at the same time

worst case time complexity O(N) and space complexity O(N)
 */

import java.util.Arrays;
import java.util.Stack;


public class Solution {

    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private int[] elements;
    private Solution txs;
    private int txCount = 0;


    public Solution() {
        elements = new int[DEFAULT_CAPACITY];
    }

    private void ensureCapacity(){
        int newSize = elements.length * 2;
        elements = Arrays.copyOf(elements, newSize);
    }

    public void push(int value) {
        if (size == elements.length){
            ensureCapacity();
        }
        elements[size++] = value;
    }

    public int top() {
        if (size > 0) {
            return elements[size - 1];
        } else {
            return 0;
        }
    }

    public void pop() {
        if (size > 0) {
            int value = elements[--size];
            elements[size] = 0;
        }
    }

    public void begin() {
        System.out.println("Begin tx");
        if (txs == null){
            txs = new Solution();
        }
        txs.push(txCount++);

    }

    public boolean rollback() {
        System.out.println("rollback tx");
        return false;
    }

    public boolean commit() {
        System.out.println("commit tx");
        return false;
    }

    @Override
    public String toString() {
        return "Solution{" +
                "size=" + size +
                ", elements=" + Arrays.toString(elements) +
                '}';
    }

    public static void test() {
        // Define your tests here
        Solution sol = new Solution();
        sol.push(42);
        System.out.println(sol);
        assert sol.top() == 42 : "top() should be 42";
        System.out.println(sol.top());
    }

    public static void example1(){
        Solution sol = new Solution();
        sol.push(5);
        sol.push(2);                    // stack: [5,2]
        System.out.println(sol);
        assert sol.top() == 2;
        sol.pop();                      // stack: [5]
        System.out.println(sol);
        assert sol.top() == 5;
        System.out.println(sol);

        Solution sol2 = new Solution();
        assert sol2.top() == 0;         // top of an empty stack is 0
        sol2.pop();
        System.out.println(sol2);
    }

    public static void example2(){
        Solution sol = new Solution();
        sol.push(4);
        sol.begin();                    // start transaction 1
        sol.push(7);                    // stack: [4,7]
        sol.begin();                    // start transaction 2
        System.out.println(sol);
        sol.push(2);                    // stack: [4,7,2]
        assert sol.rollback() == true;  // rollback transaction 2
        assert sol.top() == 7;          // stack: [4,7]
        System.out.println(sol);
        sol.begin();                    // start transaction 3
        sol.push(10);                   // stack: [4,7,10]
        System.out.println(sol);
        assert sol.commit() == true;    // transaction 3 is committed
        assert sol.top() == 10;
        assert sol.rollback() == true;  // rollback transaction 1
        assert sol.top() == 4;          // stack: [4]
        assert sol.commit() == false;   // there is no open transaction
        System.out.println(sol);
    }

    public static void main(String[] args) {
        test();
        example1();
        example2();
    }


}
