package com.leet.bullsandcows;

/**
 * You are playing the following Bulls and Cows game with your friend: You write down a number and ask your friend to
 * guess what the number is. Each time your friend makes a guess, you provide a hint that indicates how many digits
 * in said guess match your secret number exactly in both digit and position (called "bulls") and
 * how many digits match the secret number but locate in the wrong position (called "cows").
 * Your friend will use successive guesses and hints to eventually derive the secret number.
 * <p>
 * Write a function to return a hint according to the secret number and friend's guess, use A to indicate
 * the bulls and B to indicate the cows.
 * <p>
 * Please note that both secret number and friend's guess may contain duplicate digits.
 * <p>
 * Example 1:
 * <p>
 * Input: secret = "1807", guess = "7810"
 * <p>
 * Output: "1A3B"
 * <p>
 * Explanation: 1 bull and 3 cows. The bull is 8, the cows are 0, 1 and 7.
 * Example 2:
 * <p>
 * Input: secret = "1123", guess = "0111"
 * <p>
 * Output: "1A1B"
 * <p>
 * Explanation: The 1st 1 in friend's guess is a bull, the 2nd or 3rd 1 is a cow.
 * Note: You may assume that the secret number and your friend's guess only contain digits, and their lengths
 * are always equal.
 */
public class Solution {


    public String getHint(String secret, String guess){
        int bulls = 0;
        int cows = 0;
        int[] count = new int[10]; //one for each digit

        for(int i=0; i<secret.length(); i++){
            count[secret.charAt(i) - '0']++;
        }

        for(int i=0; i<secret.length(); i++){
            if (secret.charAt(i) == guess.charAt(i)){
                bulls++;
                if(count[secret.charAt(i) - '0']-- <= 0) cows--;
            } else if(count[guess.charAt(i) - '0'] > 0) {
                cows++;
                count[guess.charAt(i) - '0']--;
            }
        }

        return bulls + "A" + cows + "B";


    }
    public String getHintold(String secret, String guess) {

        int bulls = 0;
        int cows = 0;
        int[] match = new int[secret.length()];
        boolean[] used = new boolean[secret.length()];
        for(int i=0; i<match.length; i++){
            match[i] = -1;
        }
        if (secret.length() == guess.length()) {
            for (int i = 0; i < secret.length(); i++) {
                if (secret.charAt(i) == guess.charAt(i)) {
                    bulls++;
                    match[i] = i;
                    used[i] = true;
                }
            }

            for(int i=0; i<match.length; i++){
                if(match[i] == -1){
                    int a = getCharIndexThatIsNotABull(secret, guess, match, used, i, 0);
                    if(a > -1){
                        match[i] = a;
                        used[a] = true;
                    }
                }
            }
        }


        for(int i=0; i< match.length; i++){
            if(match[i]> -1 && match[i] != i)
                cows++;
        }
        return bulls + "A" + cows + "B";
    }

    private int getCharIndexThatIsNotABull(String secret, String guess, int[] match, boolean[] used, int i, int fromIndex){
        if (fromIndex == secret.length()){
            return -1;
        } else if (guess.indexOf(secret.charAt(i), fromIndex) > -1 && !used[guess.indexOf(secret.charAt(i), fromIndex)]){
            return guess.indexOf(secret.charAt(i), fromIndex);
        } else {
            return getCharIndexThatIsNotABull(secret, guess, match, used, i, fromIndex + 1);
        }

    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.getHint("1122", "0001"));
//
        System.out.println(sol.getHint("1807", "7810"));

        System.out.println(sol.getHint("1123", "0111"));

        System.out.println(sol.getHint("1122", "2211"));

        System.out.println(sol.getHint("11", "10"));
    }
}
