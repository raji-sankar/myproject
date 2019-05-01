package com.challenge.blrk.currencyarbitrage;

import java.util.Scanner;

/**
 * Created by Raji on 6/10/2016.
 */
public class Solution {


    public static int getArbitrage(double begin, double usdToEur, double eurToGbp, double gbpToUsd){
        double eur = begin/usdToEur;
        double gbp = eur/eurToGbp;
        double usd = gbp/gbpToUsd;

        double arb = usd - begin;
        return arb > 0? (int)arb : 0;
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i=0; i<n; i++){
            double usdToEur = in.nextDouble();
            double eurToGbp = in.nextDouble();
            double gbpToUsd = in.nextDouble();

            System.out.println(getArbitrage(100000, usdToEur, eurToGbp, gbpToUsd));
        }

    }




}
