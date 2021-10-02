package com.bestbuy.fizzbuzz.services

import org.springframework.stereotype.Component

@Component
class ValidatorService {
    Boolean isValid(Integer input, String compareValue) {
        return (input % compareValue.toInteger() == 0)
    }
}
