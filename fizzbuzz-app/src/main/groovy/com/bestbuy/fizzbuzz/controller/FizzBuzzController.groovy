package com.bestbuy.fizzbuzz.controller

import com.bestbuy.fizzbuzz.producer.FizzBuzzProducer
import com.bestbuy.fizzbuzz.services.FizzBuzzService
import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@Slf4j
class FizzBuzzController {

	@Autowired
	FizzBuzzService fizzBuzzService

    @Autowired
    FizzBuzzProducer fizzBuzzProducer

	@RequestMapping(path = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE )
    String getFizzBuzzMessages(@RequestParam(name="input") String input) {
        log.info("Got the request")
        String parsedInput = input.replace("[", "").replace("]", "")
        List<String> inputs = parsedInput.split(",").toList()
		String message = fizzBuzzService.getFizzBuzzMessages(inputs)
        fizzBuzzProducer.sendMessage(UUID.randomUUID().toString(), message)
        return message
	}
}
