package com.lesson;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Example {

    private static class NotComparable{
        private int i;

        private NotComparable(final int i){
            this.i = i;
        }
    }

    @Test
    public void sortNotComparable(){
        final List<NotComparable> objects = new ArrayList<>();
        for (int i=0; i < 10; i++){
            objects.add(new NotComparable(i))  ;
        }

//        try {
//            Arrays.sort(objects.toArray());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        objects.sort(new Comparator<NotComparable>() {
            @Override
            public int compare(NotComparable o1, NotComparable o2) {
                return o1.i - o2.i;
            }
        });
    }
}
