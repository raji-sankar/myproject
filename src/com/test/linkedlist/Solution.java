package com.test.linkedlist;

import java.util.Scanner;

/**
 * Created by Raji on 4/4/2016.
 */
public class Solution {

    public static Node insert(Node head, int data) {
        if (head == null) {
            head = new Node(data);
        } else {
            Node prev = head;
            Node newNode = new Node(data);
            while(prev !=null){
                if(prev.next == null && prev != newNode){
                    prev.next = newNode;
                }
                prev = prev.next;
            }

        }
        return head;
    }

    public static void display(Node head) {
        Node start = head;
        while (start != null) {
            System.out.print(start.data + " ");
            start = start.next;
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Node head = null;
        int t = sc.nextInt();
        while (t-- > 0) {
            int ele = sc.nextInt();
            head = insert(head, ele);
        }
        display(head);

    }
}

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }

}
