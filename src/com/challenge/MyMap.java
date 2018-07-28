package com.challenge;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class MyMap {

    /*
    How does a HashMap work?
    A HashMap is an implementation of Map interface which maps an Object to a key.

    Internally a HashMap stores an array of Node<K,V> objects. Node<K,V> implements Map.Entry<K,V> interface

    The Node<K,V> class in a HashMap is a linked list. In addition to key and value, the Node object
    has a hash and next - pointer to the next item that shares the same hash.

    hash value is computed by key.hashCode and (XORs) higher bits of hash to lower. For example if you
    add key = Integer(1) and key = Integer(65536), they will get the same hash.
     */

    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();

        map.put(1, "First");



        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        /* 65536 will get the same hash as 1 because the HashMap hash function
         * gets the key.hashCode() and XOR's with a right shift >>> 16 bits
         */
        map.put(65536, "same has as first");

        map.put(2000000, "Second");

        map.put(3000, "Third");
        Random random = new Random();

        for (int i=0; i < 100; i++){
            int next = random.nextInt();
            map.put(next, String.valueOf(next));
        }

        String val = map.get(3000);
        System.out.println(val);
    }




}
