package com.leet.linkedlist;

public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }

    @Override
    public String toString() {
        return val + (next != null ? "->" + next.toString() : "");
    }


}

class Solution {
    public ListNode reverseListIterative(ListNode head) {
        if(head == null) return null;
        ListNode node = head;
        ListNode prev = null;
        while(node.next != null){
            ListNode temp = node.next;
            node.next = prev;
            prev = node;
            node = temp;
        }
        node.next = prev;
        return node;

    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode node = reverseList(head.next);
        head.next.next = head;
        head.next = null;

        return node;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        Solution sol = new Solution();
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        System.out.println(node1);
        ListNode reverse = sol.reverseList(node1);
        System.out.println(reverse.toString());
        System.out.println(node1);
    }
}
