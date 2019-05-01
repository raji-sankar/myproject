package com.test.lambda;

        import java.time.LocalDate;
        import java.util.ArrayList;
        import java.util.List;

public class Example4 {
    public void usage(){
        List<Person> list = new ArrayList<>();
//        initialize(list, Person::new, first, last, birthday, gender, emailAddress, age);
//        PersonFactory factory = Person::new;
    }

    private void initialize(List<Person> list, PersonFactory factory, String first, String last, LocalDate birthday, String gender, String emailAddress, int age) {
        for (int i=0; i<10;i++){
            list.add(factory.create(first, last, birthday, gender, emailAddress, age));
        }
    }

    @FunctionalInterface
    interface PersonFactory{
        Person create(String first, String last, LocalDate birthday, String gender, String emailAddress, int age);
    }
}
