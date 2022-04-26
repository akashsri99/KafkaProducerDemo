package com.example.kafkaspring;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/demo")
public class demo {

    @Autowired
    KafkaProducer kafkaProducer;

    @GetMapping("/")
    public Object getData(){

        var data = new DemoClass(LocalDate.now());
        kafkaProducer.sendMessage(data, "reflectoring-1");
        return "Hello String";
    }
}
