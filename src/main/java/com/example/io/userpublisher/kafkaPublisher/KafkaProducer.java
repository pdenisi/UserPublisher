package com.example.io.userpublisher.kafkaPublisher;

import com.example.io.userpublisher.dto.RegistrationEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {

    @Autowired
    private KafkaTemplate<String, RegistrationEntity> kafkaTemplate;

    @Value("${neoregister.kafka.topic}")
    String kafkaTopic;

    public void send(RegistrationEntity payload) {
        Message<RegistrationEntity> message = MessageBuilder
                .withPayload(payload)
                .setHeader(KafkaHeaders.TOPIC, kafkaTopic)
                .build();
        kafkaTemplate.send(message);
    }
}
