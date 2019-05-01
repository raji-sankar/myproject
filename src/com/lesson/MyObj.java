package com.lesson;

import java.util.HashMap;
import java.util.Map;

public class MyObj {

    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();

        map.put(1, "abc");
        map.put(200, "def");

        System.out.println(map);

        System.out.println(map.get(3));
    }
}
