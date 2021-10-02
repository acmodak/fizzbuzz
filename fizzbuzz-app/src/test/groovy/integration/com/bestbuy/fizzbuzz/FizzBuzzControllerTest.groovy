package integration.com.bestbuy.fizzbuzz

import com.bestbuy.fizzbuzz.app.FizzBuzzApplication
import com.bestbuy.fizzbuzz.config.FizzBuzzConfig
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.test.annotation.DirtiesContext
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.junit4.SpringRunner
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

@SpringBootTest(classes = FizzBuzzApplication,
    webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@RunWith(SpringRunner)
@DirtiesContext
@ActiveProfiles("test")
class FizzBuzzControllerTest extends Specification {

    @Shared
    def fizzBuzzConfig = new FizzBuzzConfig(fizzComparator: "3",
        buzzComparator: "5", fizzMessage: "Fizz", buzzMessage: "Buzz",
        fizzBuzzMessage: "FizzBuzz"
    )

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

    @Shared
    String url = "http://localhost:8080/fizzbuzz/v1"

    @Autowired
    private TestRestTemplate restTemplate

    @Unroll
    def "call fizz buzz api - #descr"() {
        when:
        String output = restTemplate.getForEntity(url + "?input=" + inputs, String).body
        then:
        output == expected
        where:
        descr     | inputs                               | expected
        "input 1" | ["3"]                                | fizzBuzzConfig.fizzMessage
        "input 2" | ["5"]                                | fizzBuzzConfig.buzzMessage
        "input 3" | ["1", "3", "5", "", "15", "A", "23"] | expectedResult
        "input 4" | ["-3"]                               | "Invalid Input"
    }
}
