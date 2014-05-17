package com.github.ericdahl.spring_mvc_mersenne_primes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.List;

@Controller
@RequestMapping("/webhook")
public class WebhookController {

    private static final Logger LOGGER = LoggerFactory.getLogger(WebhookController.class);

    private final WebhookPublisher webhookPublisher;

    @Autowired
    public WebhookController(WebhookPublisher webhookPublisher) {
        this.webhookPublisher = webhookPublisher;
    }

    @RequestMapping(value = "/endpoints")
    public @ResponseBody List<URL> list() {
        return webhookPublisher.getListeners();
    }


    @RequestMapping(value = "/subscribe", method = RequestMethod.POST)
    public @ResponseBody void subscribe(@RequestBody MultiValueMap<String, String> request) throws MalformedURLException {
        LOGGER.info("Subscribe Request [{}]", request);
        String endpoint = request.getFirst("endpoint");

        webhookPublisher.subscribe(new URL(endpoint));
    }

    @ExceptionHandler
    public @ResponseBody void handleBadEndpoint(MalformedURLException e) {
        LOGGER.warn("Failed to parse endpoint", e);
    }
}
