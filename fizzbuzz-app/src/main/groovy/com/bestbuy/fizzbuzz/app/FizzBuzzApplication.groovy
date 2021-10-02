package com.bestbuy.fizzbuzz.app

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@ComponentScan(basePackages = "com.bestbuy.fizzbuzz")
class FizzBuzzApplication {
	static void main(String[] args) {
		SpringApplication.run(FizzBuzzApplication, args)
	}
}
