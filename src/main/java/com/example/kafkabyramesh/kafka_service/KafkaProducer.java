package com.example.kafkabyramesh.kafka_service;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.kafka.core.*;
import org.springframework.stereotype.*;

@Service
public class KafkaProducer {
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaProducer.class);

    //todo - initialize Kafka template with Constructor injection
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String message){
        LOGGER.info(String.format("Message sent %s", message));
        //logger.info("Produced msg {} on topic {}", msg, topic);
        kafkaTemplate.send("javaguides", message);
    }
}
