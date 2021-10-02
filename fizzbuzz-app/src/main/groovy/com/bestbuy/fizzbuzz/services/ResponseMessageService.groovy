package com.bestbuy.fizzbuzz.services

import com.bestbuy.fizzbuzz.config.FizzBuzzConfig
import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
@Slf4j
class ResponseMessageService {
    @Autowired
    ValidatorService validatorService

    @Autowired
    FizzBuzzConfig fizzBuzzConfig

    static String divide = "Divide input by type"
    static String type = "type"
    static String input = "input"

    Integer integerNumber = 0

    String getMessages(String number) {
        try {
            integerNumber = number.toInteger()
        }
        catch (Exception e) {
            log.info("Invalid input")
            return "Invalid Input"
        }
        String isFuzz = validatorService.isValid(integerNumber, fizzBuzzConfig.fizzComparator) ? "1" : "0"
        String isBuzz = validatorService.isValid(integerNumber, fizzBuzzConfig.buzzComparator) ? "1" : "0"
        switch (isFuzz + isBuzz) {
            case "11":
                return "FizzBuzz"
            case "10":
                return "Fizz"
            case "01":
                return "Buzz"
            default:
                return divide.replace(input, number.trim()).replace(type, fizzBuzzConfig.fizzComparator) + "\n" +
                    divide.replace(input, number.trim()).replace(type, fizzBuzzConfig.buzzComparator)
        }
    }
}
