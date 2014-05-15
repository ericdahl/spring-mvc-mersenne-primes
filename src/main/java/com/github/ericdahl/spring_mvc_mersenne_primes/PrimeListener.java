package com.github.ericdahl.spring_mvc_mersenne_primes;

public interface PrimeListener<T> {
    public void onPrimeEvent(T event);
}
