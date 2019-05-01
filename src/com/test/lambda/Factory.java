package com.test.lambda;

@FunctionalInterface
public interface Factory<T> {
    T create();
}
