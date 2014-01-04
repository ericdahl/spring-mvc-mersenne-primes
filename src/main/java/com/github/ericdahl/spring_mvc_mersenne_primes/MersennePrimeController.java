package com.github.ericdahl.spring_mvc_mersenne_primes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MersennePrimeController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MersennePrimeController.class);

    private final LucasLehmerCalculator calculator;

    @Autowired
    public MersennePrimeController(LucasLehmerCalculator calculator) {
        this.calculator = calculator;
    }

    @RequestMapping("/{n}")
    public @ResponseBody PrimeResult checkPrimality(@PathVariable int n) {
        LOGGER.info("Processing request for n [{}]", n);
        return calculator.checkPrimality(n);
    }
}
