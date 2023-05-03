package com.example.io.userpublisher.controller;

import com.example.io.userpublisher.dto.RegistrationEntity;
import com.example.io.userpublisher.kafkaPublisher.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProducerController {

    @Autowired
    KafkaProducer producerService;

    @PostMapping("/produce")
    public void produceMessage(@RequestBody RegistrationEntity registration) {
        producerService.send(registration);
    }

    @GetMapping("/test")
    public String ciao(){
        return "ciao";
    }
}
