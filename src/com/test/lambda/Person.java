package com.test.lambda;

import java.time.LocalDate;

public class Person {

    private final String first;
    private final String last;
    private final LocalDate birthday;
    private final String gender;
    private final String emailAddress;
    private final int age;

    public Person(String first, String last, LocalDate birthday, String gender, String emailAddress, int age) {
        this.first = first;
        this.last = last;
        this.birthday = birthday;
        this.gender = gender;
        this.emailAddress = emailAddress;
        this.age = age;
    }

    public String getFirst() {
        return first;
    }

    public String getLast() {
        return last;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public String getGender() {
        return gender;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public int getAge() {
        return age;
    }
}
