package com.challenge;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class MyMap {

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
