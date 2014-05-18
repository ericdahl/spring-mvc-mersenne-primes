package com.github.ericdahl.spring_mvc_mersenne_primes;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.Arrays;

@ComponentScan(basePackages = {"com.github.ericdahl.spring_mvc_mersenne_primes"})
@EnableWebMvc
@EnableCaching
@Configuration
public class AppConfig extends WebMvcConfigurerAdapter {

    @Bean
    public CacheManager cacheManager() {
        SimpleCacheManager cacheManager = new SimpleCacheManager();
        cacheManager.setCaches(Arrays.asList(new ConcurrentMapCache("mersennePrimes")));
        return cacheManager;
    }
}
