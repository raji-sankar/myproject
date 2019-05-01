package com.test.thread.goetz;

import jdk.nashorn.internal.ir.annotations.Immutable;

import java.util.HashSet;
import java.util.Set;

@Immutable
public final class ThreeStooges {

    private final Set<String> names = new HashSet<>();

    public ThreeStooges() {
        names.add("Larry");
        names.add("Curly");
        names.add("Moe");
    }

    public boolean isStooge(String name){
        return names.contains(name);
    }
}
