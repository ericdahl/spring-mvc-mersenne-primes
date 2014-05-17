package com.github.ericdahl.spring_mvc_mersenne_primes;

public class PrimeResult {
    private final int n;
    private final boolean prime;

    public PrimeResult(int n, boolean prime) {
        this.n = n;
        this.prime = prime;
    }

    public int getN() {
        return n;
    }

    public boolean isPrime() {
        return prime;
    }

    @Override
    public String toString() {
        return String.format("[%d] -> [%s]", n, prime);
    }
}
