package com.cake.reversestring;

public class ReverseString {

    public static void reverse(char[] input){
        int len = input.length;
        if (len < 2){
            //do nothing
        } else {
            for (int i=0; i < len/2; i++){
                char temp = input[i];
                input[i] = input[len-1 -i];
                input[len-1 -i] = temp;
            }
        }

    }

    public static void reverse2(char[] input){
        int left = 0;
        int right = input.length -1;

        while(left < right){
            char temp = input[left];
            input[left] = input[right];
            input[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        char[] emp = "".toCharArray();
        char[] one = "a".toCharArray();
        char[] two = "ab".toCharArray();
        char[] three = "abc".toCharArray();
        char[] four = "four".toCharArray();
        char[] five = "three".toCharArray();

        reverse2(emp);
        System.out.println(emp);
        reverse2(one);
        System.out.println(one);
        reverse2(two);
        System.out.println(two);
        reverse2(three);
        reverse2(four);
        reverse2(five);



        System.out.println(three);
        System.out.println(four);
        System.out.println(five);


    }
}
