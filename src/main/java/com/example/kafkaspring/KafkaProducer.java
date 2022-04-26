package com.example.kafkaspring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
class KafkaProducer {

    private KafkaTemplate<String, String> kafkaTemplate;


    @Autowired
    void KafkaSenderExample(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    void sendMessage(DemoClass message, String topicName) {
        System.out.println(message);
        System.out.println(topicName);
        kafkaTemplate.send(topicName, message.toString());
    }

}