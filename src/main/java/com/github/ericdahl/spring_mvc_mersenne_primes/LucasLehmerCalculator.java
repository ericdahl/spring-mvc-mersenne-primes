package com.github.ericdahl.spring_mvc_mersenne_primes;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service
public class LucasLehmerCalculator {

    private final BigInteger TWO = new BigInteger("2");

    @Cacheable("mersennePrimes")
    public PrimeResult checkPrimality(int n) {

        BigInteger s = new BigInteger("4");

        if (n == 2) {
            return new PrimeResult(n, true);
        }

        BigInteger m = new BigInteger("2").pow(n).subtract(BigInteger.ONE);
        for (int i = 0; i < (n - 2); ++i) {
            s = s.pow(2).subtract(TWO).remainder(m);
        }
        if (s.equals(BigInteger.ZERO)) {
            return new PrimeResult(n, true);
        } else {
            return new PrimeResult(n, false);
        }
    }
}
