package com.leet.linkedlist;

public class LinkedList {

    Node head;

    public Node getHead(){
        return head;
    }

    public LinkedList(Node head){
        this.head = head;
    }

    public Node getTail(){
        Node current = head;
        while (current.next != null){
            current = current.next;
        }
        return current;

    }
    public void insert(Node node){
        //insert to the end of the list
        Node tail = getTail();
        tail.next = node;
    }

    public LinkedList reverse(){
        //returns a new linked list that is reverse
        Node current = head;
        Node previous = head;
        Node newCurrent = new Node(head.data);
        while (current != null){

            previous = current.next;
            if (previous != null) {
                Node newNext = new Node(previous.data);
                newNext.next = newCurrent;
                newCurrent = newNext;
            }

            current = previous;
        }

        return new LinkedList(newCurrent);
    }



    public int midPointIndex(){
        Node runner1 = head;
        Node runner2 = head;
        int i = 0;

        while(runner2 != null && runner2.next != null){
            runner1 = runner1.next;
            runner2 = runner2.next;
            if(runner2 != null){
                runner2 = runner2.next;
            }
            i++;
        }

        return i;

    }


    @Override
    public String toString() {
        return head.toString();
    }

    public static void main(String[] args) {
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        one.next = two;
        two.next = three;

        LinkedList linkedList = new LinkedList(one);
        System.out.println(linkedList);

        LinkedList reversed = linkedList.reverse();
        System.out.println(reversed);

        Node four = new Node(4);
        Node five = new Node(5);
        three.next = four;
        four.next = five;
        System.out.println(linkedList);
        System.out.println("Mid-point index = " + linkedList.midPointIndex());

    }
}

class Node {
    int data;
    Node next;

    public Node(int data){
        this.data = data;
    }

    @Override
    public String toString() {

        String str = "Node{" +
                "data=" + data +
                ", next=" + next +
                '}';
        str = data + " -> " + next;
        return str;
    }
}
