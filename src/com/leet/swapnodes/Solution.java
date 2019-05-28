package com.leet.swapnodes;

class ListNode{
    int data;
    public ListNode next;
    public ListNode(int data){
        this.data = data;
    }
}

public class Solution {

    public static ListNode swapPairs(ListNode head) {

        if (head != null && head.next != null){
            ListNode temp = head;
            head = temp.next;
            temp.next = head.next;
            head.next = temp;
            if (head.next != null )
                head.next.next = swapPairs(head.next.next);
        }
        return head;

    }

    public static void printNodes(ListNode head){
        ListNode current = head;

        while (current != null){
            System.out.print("->");
            System.out.print(current.data);
            current = current.next;
        }
    }

    public static void main(String[] args) {

        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);

        one.next = two;
        two.next = three;
        three.next = four;

        printNodes(one);
        System.out.println();
        ListNode swapped = swapPairs(one);
        printNodes(swapped);
    }

}
