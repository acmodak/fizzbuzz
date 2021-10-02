package unit.com.bestbuy.fizzbuzz.controller

import com.bestbuy.fizzbuzz.controller.FizzBuzzController
import com.bestbuy.fizzbuzz.producer.FizzBuzzProducer
import com.bestbuy.fizzbuzz.services.FizzBuzzService
import spock.lang.Specification

class FizzBuzzControllerTest extends Specification {

    def mockFizzBuzzService = Mock(FizzBuzzService)
    def mockFizzBuzzProducer = Mock(FizzBuzzProducer)

    def fizzBuzzController = new FizzBuzzController(
        fizzBuzzService: mockFizzBuzzService,
        fizzBuzzProducer: mockFizzBuzzProducer
    )

    def "fizzbuzz controller is called"() {
        when:
        fizzBuzzController.getFizzBuzzMessages(["1"])
        then:
        1 * mockFizzBuzzService.getFizzBuzzMessages(["1"])
        1 * mockFizzBuzzProducer.sendMessage(_, _)
    }

}
