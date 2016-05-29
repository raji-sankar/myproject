package com.test.day13;

/**
 * Created by Raji on 4/2/2016.
 */
public abstract class Book {

    String title;
    String author;
    Book(String t,String a){
        title=t;
        author=a;
    }
    abstract void display();
}
