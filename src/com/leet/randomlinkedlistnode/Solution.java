package com.leet.randomlinkedlistnode;

import java.util.Random;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        this.val = x;
    }
}

public class Solution {

    ListNode head;
    Random rand;
    /** @param head The linked list's head.
    Note that the head is guaranteed to be not null, so it contains at least one node. */
    public Solution(ListNode head) {
        this.head = head;
        rand = new Random();
    }

    /** Returns a random node's value. */
    public int getRandom() {
        int result = -1;
        int count =0;
        ListNode current = head;
        while(current != null){
            if(rand.nextInt(++count) == 0) {
                result = current.val;
            }
            current = current.next;
        }
        return result;

    }



    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        Solution solution = new Solution(head);
        System.out.println(solution.getRandom());
    }


}
