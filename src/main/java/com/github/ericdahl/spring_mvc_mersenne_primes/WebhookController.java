package com.github.ericdahl.spring_mvc_mersenne_primes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.net.URL;

@Controller
public class WebhookController {

    private final WebhookPublisher webhookPublisher;

    @Autowired
    public WebhookController(WebhookPublisher webhookPublisher) {
        this.webhookPublisher = webhookPublisher;
    }

    @RequestMapping
    public void subscribe(URL endpoint) {
        webhookPublisher.subscribe(endpoint);
    }
}
