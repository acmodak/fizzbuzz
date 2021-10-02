package unit.com.bestbuy.fizzbuzz.services

import com.bestbuy.fizzbuzz.services.ValidatorService
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

class ValidatorServiceTest extends Specification {
    @Shared
    ValidatorService validatorService = new ValidatorService()

    @Unroll
    def "call validator service for fizz - #descr"() {
        when:
        Boolean output = validatorService.isValid(number, compare)
        then:
        output == expectedResult
        where:
        descr                              | compare | number | expectedResult
        "When number is not multiple of 3" | "3"     | 2      | false
        "When number is   multiple of 3"   | "3"     | 3      | true
    }

    @Unroll
    def "call validator service for buzz  - #desc"() {
        when:
        Boolean output = validatorService.isValid(number, compare)
        then:
        output == expectedResult
        where:
        desc                              | compare | number | expectedResult
        "When number isn't multiple of 5" | "5"     | 2      | false
        "When number is multiple of 5"    | "5"     | 5      | true
    }
}
