package com.bestbuy.fizzbuzz.services

import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
@Slf4j
class FizzBuzzService {
    @Autowired
    ResponseMessageService fizzBuzzMessageService

    String getFizzBuzzMessages(List<String> inputs) {
        List<String> messages =
            inputs.collect { String input ->
                return fizzBuzzMessageService.getMessages(input)
            }.toList()
        return messages.join("\n")
    }
}
