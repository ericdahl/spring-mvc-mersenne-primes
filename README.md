spring-mvc-mersenne-primes
==========================

[![Build Status](https://travis-ci.org/ericdahl/spring-mvc-mersenne-primes.png?branch=master)](https://travis-ci.org/ericdahl/spring-mvc-mersenne-primes)

Experimental project which sets up a web service with Spring that returns mersenne primes.

The main goal here is to set up and configure Travis CI on a nontrivial app.

#### Running with jetty plugin

Just run
```
mvn jetty:run
```
to launch it
and then make a request to 

[http://localhost:8080/3](http://localhost:8080/3)

to have it calculate whether ```2^3-1``` is prime, etc.
