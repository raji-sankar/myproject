package com.test.test;

import java.io.BufferedReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class StringBuilderDemo {

    public static void writeFile(){

        Path inputfile = Paths.get("inop");
        Path outputFile = Paths.get("inop");
//        BufferedReader  x = Files.newBufferedReader(inputfile, Charset.defaultCharset());
    }

    public static void main(String[] args) {
        StringBuilder str = new StringBuilder();
        for (String arg : args){
            if(str.indexOf(arg) < 1)
                str.append(arg+" ");
        }
        System.out.println(str.toString());

        Scanner sc = new Scanner(str.toString());
        while(sc.hasNext()){
            if (sc.hasNextInt())
                System.out.print(sc.nextInt() + " ");
            else
                sc.next();
        }
    }
}
