package com.challenge.blrk.fista;

import java.util.Scanner;

/**
 * Created by Raji on 6/10/2016.
 */

class FixedIncomeSecurity {
    private int minimumTradeSize;
    private int increment;
    private int availableUnits;

    public FixedIncomeSecurity(int minimumTradeSize, int increment, int availableUnits){
        this.minimumTradeSize = minimumTradeSize;
        this.increment = increment;
        this.availableUnits = availableUnits;
    }

    public int getMinimumTradeSize() {
        return minimumTradeSize;
    }

    public int getIncrement() {
        return increment;
    }

    public int getTradeableAmount(int n) {
        return minimumTradeSize +  increment * n;
    }

    public int getAvailableUnits() {
        return availableUnits;
    }
}

class FixedIncomeTradeOrder{
    private int portfolioOrder;
}

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        int minimumTradeSize = in.nextInt();
        int increment = in.nextInt();
        int availableUnits = in.nextInt();
        for (int i=0; i < t; i++){

        }
    }
}
