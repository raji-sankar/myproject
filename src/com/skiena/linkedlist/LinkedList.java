package com.skiena.linkedlist;

class Node {

    int data;
    Node next;

    public Node(int data){
        this.data = data;
    }

    @Override
    public String toString() {
        return "data = " + data;
    }
}

public class LinkedList {

    Node head;

    public LinkedList(Node node){
        head = node;
    }

    public int getLength(){
        int len = 0;
        Node node = head;
        if (head == null) { return 0;}

        while(node.next != null){
            len++;
            node = node.next;
        }

        //increment last time for tail node
        len++;

        return len;
    }

    public Node getMiddleNode(){
        int len = getLength();
        int middle = len/2;
        Node node = head;
        for (int i =0; i < middle; i++){
            node = node.next;
        }
        return node;
    }

    public Node middleNode(){
        Node slow = head;
        Node fast = head;
        if (head != null){
            while(fast != null && fast.next != null){
                fast = fast.next.next;
                slow = slow.next;
            }
            return slow;
        }
        return null;
    }

    public void reverse(){
        Node current = head;
        Node prev = null;
        Node next = null;

        while (current != null){

            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node node = head;

        while (node.next != null){
            sb.append(" -> ");
            sb.append(node);
            node = node.next;
        }
        sb.append(" -> ");
        sb.append(node);
        return sb.toString();
    }

    public static void main(String[] args) {
        Node first = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        first.next = second;
        second.next = third;

        LinkedList list = new LinkedList(first);
        System.out.println(list.getLength());
        System.out.println(list.middleNode());
        System.out.println(list);
    }
}
