package unit.com.bestbuy.fizzbuzz.services

import com.bestbuy.fizzbuzz.services.FizzBuzzService
import com.bestbuy.fizzbuzz.services.ResponseMessageService
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

class FizzBuzzServiceTest extends Specification {
    def mockFizBuzzMessageService = Mock(ResponseMessageService)

    FizzBuzzService fizzBuzzService = new FizzBuzzService(
        fizzBuzzMessageService: mockFizBuzzMessageService)

    @Shared
    String divide = "Divide input by type"
    @Shared
    String input = "input"
    @Shared
    String type = "type"

    @Shared
    String message = divide.replace(type, "3") + "\n" + divide.replace(type, "5")

    @Shared
    String expectedResult = message.replace(input, "1") + "\n" +
        "Fizz" + "\n" + "Buzz" + "\n" + "Invalid Input" + "\n" + "FizzBuzz" + "\n" +
        "Invalid Input" + "\n" + message.replace(input, "23")


    @Unroll
    def "call fizz buzz message service"() {
        when:
        String output = fizzBuzzService.getFizzBuzzMessages(["1", "3", "5", "", "15", "A", "23"])
        then:
        1 * mockFizBuzzMessageService.getMessages("1") >> message.replace(input, "1")
        1 * mockFizBuzzMessageService.getMessages("3") >> "Fizz"
        1 * mockFizBuzzMessageService.getMessages("5") >> "Buzz"
        1 * mockFizBuzzMessageService.getMessages("") >> "Invalid Input"
        1 * mockFizBuzzMessageService.getMessages("15") >> "FizzBuzz"
        1 * mockFizBuzzMessageService.getMessages("A") >> "Invalid Input"
        1 * mockFizBuzzMessageService.getMessages("23") >> message.replace(input, "23")
        output == expectedResult
    }
}
