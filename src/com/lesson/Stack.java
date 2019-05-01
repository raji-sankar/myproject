package com.lesson;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class Stack<E>{

    private final List<E> values;

    public Stack(){
        values = new LinkedList<>();
    }

    public void push(E value){
        values.add(0, value);
    }

    public E pop(){
        return values.remove(0);
    }

    public void pushAll(Iterable<? extends E> src){
        for (E e: src){
            push(e);
        }
    }

    public boolean isEmpty(){
        return values.size() == 0;
    }

    public void popAll(Collection<E> dst){
        while(!isEmpty()){
            dst.add(pop()) ;
        }
    }

    public static void main(String[] args) {
        Stack<Number> numberStack = new Stack<>();
        List<Integer> integers = new ArrayList<>();
        for (int i=0; i < 10; i++){
            integers.add(i);
        }
        Iterable<Integer> ints = integers;

        numberStack.pushAll(ints);
    }
}
