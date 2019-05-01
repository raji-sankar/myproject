package com.lesson;

import java.util.*;
import java.util.Stack;
import java.util.concurrent.DelayQueue;

public class Generics {

    public static void testUnboundWildcard(Collection<?> col){
        System.out.println(col.size());
    }

    public static void main(String[] args) {
        Object[] objectArray = new Long[1];
//        objectArray[0] = "I dont fit in";

        Collection<String> col = new ArrayList<String>();
        col.add("one");
        testUnboundWildcard(col);

        List<Integer> ints = new ArrayList<>();
        for (int i=0; i < 10; i++){
            ints.add(i);
        }
        testUnboundWildcard(ints);

        Stack<Number> numberStack = new Stack<>();

//        List<Object> ol = new ArrayList<Long>();

    }
    /*
    Difference between java arrays and generics
    1. Arrays are covariant - if Sub is a subtype of Super, then array Sub[] is a subtype of array Super[]
    Generics are invariant: for two distinct types Type1 and Type2, List<Type1> is neither a subtype nor
    a super tyope of List<Type2>
    2. Arrays are reified. Arrays know and enforce their type at runtime
    Generics are implemented by erasure - they only enforce type constraints at compile time and discard or
    erase their element type at runtime
    3. Illegal to create an array of a generic type, a parameterized type or a type parameter
    illegal new List<E>[], new List<String>[], new E[]. They result in generic array creation errors at compile time
    E[], List<E>, and List<String> are nonreifiable types. Non-refiable type is one whose runtime representation
    contains less information than its compile time representation. Because of type erasure, the only
    parameterized types that are refiable are unbounded wildcard types such as List<?> and Map<?,?>
    4. When to use bounded wildcars
    PECS - producer-extends, consumer-super
     */
}
