package com.github.ericdahl.spring_mvc_mersenne_primes;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@RunWith(MockitoJUnitRunner.class)
public class WebhookControllerTest {

    @Mock private LucasLehmerCalculator calculator;
    @InjectMocks private MersennePrimeController controller;

    @Before
    public void setupMock() {
        when(calculator.checkPrimality(anyInt())).thenReturn(new PrimeResult(2, true));
    }

    @Test
    public void returnsPrimeJson() throws Exception {
        standaloneSetup(controller).build().perform(get("/2"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"));
    }

    @Test
    public void returnsJsonPayload() throws Exception {
        standaloneSetup(controller).build().perform(get("/2"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.n").value(2))
                .andExpect(jsonPath("$.prime").value(true));
    }

    @Test
    public void setsCacheControlHeader() throws Exception {
        standaloneSetup(controller).build().perform(get("/2"))
                .andExpect(status().isOk())
                .andExpect(header().string("Cache-Control", "max-age=31536000"));
    }
}
