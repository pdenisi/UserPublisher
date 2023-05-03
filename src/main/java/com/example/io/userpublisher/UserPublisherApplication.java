package com.example.io.userpublisher;

import com.example.io.userpublisher.dto.RegistrationEntity;
import com.example.io.userpublisher.kafkaPublisher.KafkaProducer;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UserPublisherApplication {

    @Autowired
    private static KafkaProducer producerService;

    public static void main(String[] args) {
        SpringApplication.run(UserPublisherApplication.class, args);
    }

}
