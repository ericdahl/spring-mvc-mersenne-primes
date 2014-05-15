package com.github.ericdahl.spring_mvc_mersenne_primes;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Service
public class LucasLehmerCalculator {

    private final BigInteger TWO = new BigInteger("2");

    private final List<PrimeListener<PrimeResult>> listenerList = new ArrayList<PrimeListener<PrimeResult>>();

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

        PrimeResult result = new PrimeResult(n, s.equals(BigInteger.ZERO));
        publish(result);
        return result;
    }

    public void listen(PrimeListener<PrimeResult> listener) {
        listenerList.add(listener);
    }

    private void publish(PrimeResult event) {
        for (PrimeListener<PrimeResult> listener : listenerList) {
            listener.onPrimeEvent(event);
        }
    }
}
