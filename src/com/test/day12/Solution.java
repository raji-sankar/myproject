package com.test.day12;

import java.util.Scanner;

/**
 * Created by Raji on 4/2/2016.
 */
public class Solution {


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String firstName = in.next();
        String lastName = in.next();
        int id = in.nextInt();
        in.nextLine();
        int n = in.nextInt();
        int[] scores = new int[n];
        for (int i=0; i < n; i++){
            scores[i] = in.nextInt();
        }

        Student student = new Student(firstName, lastName, id, scores);
//        System.out.println("Name: " + student.lastName + ", " + student.firstName);
//        System.out.println("ID: " + student.idNumber);
        student.printPerson();
        System.out.println("Grade: " + student.calculate());


    }
}
