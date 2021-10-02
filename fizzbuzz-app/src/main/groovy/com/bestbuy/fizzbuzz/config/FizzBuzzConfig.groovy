package com.bestbuy.fizzbuzz.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration

@Configuration
@ConfigurationProperties(prefix = "fizzbuzz")
class FizzBuzzConfig {
    String fizzComparator
    String buzzComparator
    String fizzMessage
    String buzzMessage
    String fizzBuzzMessage
}
