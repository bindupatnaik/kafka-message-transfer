package com.example.kafkabyramesh.kafka_service;

import org.slf4j.*;
import org.springframework.kafka.annotation.*;
import org.springframework.stereotype.*;

@Service
public class KafkaConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);

    @KafkaListener(topics = "javaguides", groupId = "myGroup")
    public void consume(String message){
        LOGGER.info(String.format("Message received -> %s", message));
    }
}
