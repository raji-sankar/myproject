package com.test.lambda;


import java.util.ArrayList;
import java.util.List;

public class Example3 {

    public void usage(){
        List<String> list = new ArrayList<>();
        initialize(list, String::new);
    }

    private <T>void initialize(List<T> list, Factory<T> factory) {
        for (int i=0; i<10;i++){
            list.add(factory.create());
        }
    }
}
