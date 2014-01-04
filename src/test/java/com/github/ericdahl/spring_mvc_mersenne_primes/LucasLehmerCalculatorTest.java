package com.github.ericdahl.spring_mvc_mersenne_primes;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class LucasLehmerCalculatorTest {

    private final LucasLehmerCalculator calculator = new LucasLehmerCalculator();

    @Test
    public void testSmallPrimes() {
        assertThat(calculator.checkPrimality(2).isPrime(), is(true));
        assertThat(calculator.checkPrimality(3).isPrime(), is(true));
        assertThat(calculator.checkPrimality(5).isPrime(), is(true));
        assertThat(calculator.checkPrimality(7).isPrime(), is(true));
        assertThat(calculator.checkPrimality(13).isPrime(), is(true));
        assertThat(calculator.checkPrimality(17).isPrime(), is(true));
    }

    @Test
    public void testSmallComposites() {
        assertThat(calculator.checkPrimality(6).isPrime(), is(false));
    }
}
