package com.leet.addtwonumbers;

/*


You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example:

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sol {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode output = null;
        Integer[] x = listNodeMembers(l1);
        Integer[] y = listNodeMembers(l2);
        boolean isXLonger = x.length > y.length;
        int min = Math.min(x.length, y.length);
        int max = Math.max(x.length, y.length);
        List<Integer> out = new ArrayList<>();
        int carryover = 0;
        for (int i = 0; i < min; i++){
            int c = x[i] + y[i] + carryover;
            carryover = getAddCarryover(out, c);
        }
        if (max > min) {
            for(int i=min; i< max; i++){
                if(isXLonger) {
                    int c = x[i] + carryover;
                    carryover = getAddCarryover(out, c);

                } else{
                    int c = y[i] + carryover;
                    carryover = getAddCarryover(out, c);

                }
            }
        }
        if (carryover > 0) {
            out.add(carryover);
        }

        Integer[] z = out.toArray(new Integer[out.size()]);
        int[] a = Arrays.stream(z).mapToInt(Integer::intValue).toArray();
        output = ListNodeBuilder(a);

        printListNode(output);
        return output;
    }

    private int getAddCarryover(List<Integer> out, int c) {
        int carryover;
        carryover = 0;
        if (c > 9){
            int a = c % 10;
            out.add(a);
            carryover = 1;
        }else {
            out.add(c);
        }
        return carryover;
    }

    public static ListNode ListNodeBuilder(int[] nums){

        ListNode node = new ListNode(nums[0]);
        ListNode head = node;
        for(int i=1; i < nums.length; i++){
            ListNode x = new ListNode(nums[i]);
            node.next = x;
            node = x;
        }

        printListNode(head);
        return head;
    }

    public static void printListNode(ListNode k){

        while(k.next != null){
            System.out.print(k.val);
            System.out.print("->");
            k = k.next;
        }
        System.out.print(k.val);
        System.out.println("");

    }

    public static Integer[] listNodeMembers(ListNode k){
        List<Integer> m = new ArrayList<>();
        while(k.next != null){
            m.add(k.val);
            k = k.next;
        }
        m.add(k.val);

        return m.toArray(new Integer[m.size()]);
    }

    public static void main(String[] args) {
//        int[] x = {2, 4, 3};
        int[] x = {9, 9};
        ListNode k =Sol.ListNodeBuilder(x);
//        int[] y = {5, 6, 4};
        int[] y = {1};
        ListNode m = Sol.ListNodeBuilder(y);
        Sol sol = new Sol();
        ListNode result = sol.addTwoNumbers(k, m);

    }

}
