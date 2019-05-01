package com.test.effjava3;


import java.math.BigInteger;
import java.util.stream.Stream;

import static java.math.BigInteger.ONE;


public class MarsennePrime {

    public static final BigInteger TWO = BigInteger.valueOf(2l);

    static Stream<BigInteger> primes(){
        return Stream.iterate(TWO, BigInteger::nextProbablePrime);
    }

    public static void main(String[] args){
        primes().map(p -> TWO.pow(p.intValueExact()).subtract(ONE))
                .filter(marsenne -> marsenne.isProbablePrime(50))
                .limit(20)
                .forEach(System.out::println);

    }
}
