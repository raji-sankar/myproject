package com.lesson;

import java.util.BitSet;

public class BitSetTest {

    public static void main(String[] args) {
        BitSet b1 = new BitSet(1);
        BitSet b2 = new BitSet(2);
        b2.and(b1);
        System.out.println(b2.toString());

    }
}
