package com.linkedlist;

import java.util.ArrayList;
import java.util.List;

public class LinkedList {

    public LinkedList(Node node){
        this.head = node;
    }

    public LinkedList(int data){
        head = new Node(data);
    }

    private Node head;

    void insert(int data){
        Node newNode = new Node(data);
        Node tail = getTail();
        tail.setNext(newNode);
    }

    Node getTail(){
        Node currentNode = head;

        while(currentNode.getNext() != null){
            currentNode = currentNode.getNext();
        }
        return currentNode;
    }

    boolean detectCycle(){
        boolean hasCycle = false;
        List<Node> seen = new ArrayList<>();
        Node current = head;
        while(current.getNext() != null){
            if (seen.indexOf(current) > -1){
                return true;
            }
            seen.add(current);

        }

        return hasCycle;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node current = head;
        sb.append(current);
        while (current.getNext() != null){

        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        Node second = new Node(2);
        head.setNext(second);
        LinkedList ll = new LinkedList(head);
        second = ll.getTail();
        ll.insert(3);
        System.out.println(ll.detectCycle());
        Node third = ll.getTail();
        third.setNext(second);

    }


}
