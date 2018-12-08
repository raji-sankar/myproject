package com.leet.addtwonumbers;

public class FasterSol {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;


        ListNode node = new ListNode(0);
        ListNode current = node;

        while(l1 != null || l2 != null){
            int val = (l1 == null ? 0 : l1.val) + ((l2 == null) ? 0 : l2.val) + current.val;
            current.val = (val > 9) ? val % 10 : val;
            ListNode next = new ListNode((val > 9) ? 1 : 0);
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
            if (next.val > 0 || l1 != null | l2 != null) {
                current.next = next;
                current = next;
            }
        }

        return node;
    }

    public static ListNode ListNodeBuilder(int[] nums){
        if (nums.length == 0) return null;
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

    public static void main(String[] args){
        int[] x = {2, 4, 3};
//        int[] x = {9};
        ListNode k = ListNodeBuilder(x);
        int[] y = {5, 6, 4};
//        int[] y = {9};
        ListNode m = ListNodeBuilder(y);
       FasterSol sol = new FasterSol();
        printListNode(sol.addTwoNumbers(k, m));
    }
}
