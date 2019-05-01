package com.test.collection;

import java.util.ArrayList;
import java.util.List;

public class Coll {

    private List<Animal> myList = new ArrayList<>();

    public void add(Animal a){
        myList.add(a);
    }

    public static void main(String[] args) {
        Coll coll = new Coll();

        Ape ape = new Ape();
        Cat cat = new Cat();

        coll.add(ape);
        coll.add(cat);

        for (int i=0; i< coll.myList.size(); i++){
            System.out.println(coll.myList.get(i).getLegs());
        }
    }


}

class Animal {

    int getLegs(){
        return 4;
    }
}

class Ape extends Animal{

    int getLegs(){
        return 2;
    }
}

class Cat extends Animal{

}
