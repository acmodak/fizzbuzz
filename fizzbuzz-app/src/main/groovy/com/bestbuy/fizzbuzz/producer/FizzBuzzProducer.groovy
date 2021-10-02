package com.bestbuy.fizzbuzz.producer

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Service

@Service
class FizzBuzzProducer {
    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate
    private String topicName = "fizz-buzz"

    @Async
    void sendMessage(String key, Object msg) {
        kafkaTemplate.send(topicName, key, msg)
    }
}
