package com.github.ericdahl.spring_mvc_mersenne_primes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Service
public class WebhookPublisher implements PrimeListener<PrimeResult> {

    private static final Logger LOGGER = LoggerFactory.getLogger(WebhookPublisher.class);

    private List<URL> listeners = new ArrayList<URL>();

    @Autowired
    public WebhookPublisher(LucasLehmerCalculator calculator) {
        calculator.listen(this);
    }

    public void subscribe(URL endpoint) {
        listeners.add(endpoint);
    }

    @Override
    public void onPrimeEvent(PrimeResult event) {
        LOGGER.info("Publishing event [{}] to [{}] endpoints", event, listeners.size());
        for (URL endpoint : listeners) {
            LOGGER.info("Publishing event [{}] to webhook client [{}]", event, endpoint);
            // TODO
        }
    }

}
