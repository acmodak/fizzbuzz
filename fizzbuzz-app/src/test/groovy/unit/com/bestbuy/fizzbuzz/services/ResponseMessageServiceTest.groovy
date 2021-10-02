package unit.com.bestbuy.fizzbuzz.services

import com.bestbuy.fizzbuzz.config.FizzBuzzConfig
import com.bestbuy.fizzbuzz.services.ResponseMessageService
import com.bestbuy.fizzbuzz.services.ValidatorService
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

class ResponseMessageServiceTest extends Specification {

    def mockValidatorService = Mock(ValidatorService)

    @Shared
    def fizzBuzzConfig = new FizzBuzzConfig(fizzComparator: 3,
        buzzComparator: 5, fizzMessage: "Fizz", buzzMessage: "Buzz",
        fizzBuzzMessage: "FizzBuzz"
    )

    ResponseMessageService fizzBuzzMessageService = new ResponseMessageService(
        validatorService: mockValidatorService,
        fizzBuzzConfig: fizzBuzzConfig
    )

    @Shared
    String divide = "Divide 1 by type"
    @Shared
    String type = "type"

    @Shared
    String message = divide.replace(type, "3") + "\n" + divide.replace(type, "5")

    @Unroll
    def "call fizz buzz message service- #descr"() {
        when:
        String output = fizzBuzzMessageService.getMessages(number)
        then:
        1 * mockValidatorService.isValid(Integer.valueOf(number), "3") >> fizzValidation
        1 * mockValidatorService.isValid(Integer.valueOf(number), "5") >> buzzValidation
        output == expectedResult
        where:
        descr                                | number | fizzValidation | buzzValidation | expectedResult
        "When it is multiple of both"        | "15"   | true           | true           | fizzBuzzConfig.fizzBuzzMessage
        "When it is multiple of 3"           | "3"    | true           | false          | fizzBuzzConfig.fizzMessage
        "When it is multiple of 5"           | "5"    | false          | true           | fizzBuzzConfig.buzzMessage
        "When it is multiple neither 3 or 5" | "1"    | false          | false          | message
    }

    void "call fizz buzz message service with invalid input"() {
        when:
        String output = fizzBuzzMessageService.getMessages("A")
        then:
        output == "Invalid Input"
    }
}
