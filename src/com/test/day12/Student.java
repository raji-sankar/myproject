package com.test.day12;



/**
 * Created by Raji on 4/1/2016.
 */
public class Student extends Person {
    int[] scores;



    Student(String firstName, String lastName, int id, int[] scores){
        super(firstName, lastName, id);
        this.scores = scores;
    }

    public char calculate(){
        int sum = 0;
        char grade;
        for (int score : this.scores){
            sum += score;
        }
        int avg = (int)(double)sum/this.scores.length;

        if (avg >= 90){
            grade = 'O';
        } else if (avg >= 80){
            grade = 'E';
        } else if (avg >= 70){
            grade = 'A';
        } else if (avg >= 55){
            grade = 'P';
        } else if (avg >= 40){
            grade = 'D';
        } else {
            grade = 'T';
        }
        return grade;
    }

    public static void main(String[] args){

    }

}
