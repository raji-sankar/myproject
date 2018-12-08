package com.leet.addtwonumbers;



public class Solution {

    public String getNumber(ListNode node){
        if (node == null){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        long number = 0;
        int i = 0;
        ListNode current = node;
        while(current.next != null){
            sb.append(current.val) ;
            current = current.next;
            i += 1;
        }

        //add last node
        sb.append(current.val);

        return sb.reverse().toString();
    }

    public ListNode getListNode(String strNum){
//        String strNum = Long.valueOf(number).toString();
        char[] digits = strNum.toCharArray();
        if (digits.length == 0){
            return null;
        }
        ListNode head = new ListNode(Integer.valueOf(String.valueOf(digits[digits.length -1])));
        ListNode node = head;
        for(int i = digits.length -2; i >= 0 ; i--){
            ListNode next = new ListNode(Integer.valueOf(String.valueOf(digits[i]))) ;
            node.next = next;
            node = next;
        }
        return head;
    }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {


        String num1 = getNumber(l1);
        String num2 = getNumber(l2);

        String sum = "";
        int len1 = num1.length();
        int len2 = num2.length();
        //lengths can be equal
        //len1 is bigger
        //len2 is bigger

        int bigger = len1 >= len2 ? len1 : len2;
        int smaller = len1 == bigger ? len2 : len1;

        char[] num1Truncated = null;
        char[] num2Truncated = null;

        if (num1.length() > smaller){
            num1Truncated = num1.substring(0, smaller).toCharArray();
        }

        for (int i = smaller -1; i >= 0; i++){
            int tot = Integer.valueOf(String.valueOf(num1Truncated[i]));
        }


        return getListNode(sum);
    }

    public static void main(String[] args) {

        Solution sol = new Solution();
        ListNode first = sol.getListNode("999999999991");
        ListNode second = sol.getListNode("465");
        System.out.println("first " + sol.getNumber(first));
        System.out.println("second " + sol.getNumber(second));
        System.out.println(sol.getNumber(sol.addTwoNumbers(first, second)));



    }
}
