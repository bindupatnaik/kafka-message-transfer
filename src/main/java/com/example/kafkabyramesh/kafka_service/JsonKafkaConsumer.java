package com.example.kafkabyramesh.kafka_service;


import com.example.kafkabyramesh.model.*;
import org.slf4j.*;
import org.springframework.kafka.annotation.*;
import org.springframework.stereotype.*;

@Service
public class JsonKafkaConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaConsumer.class);

    @KafkaListener(topics = "${spring.kafka.topic.name}", groupId = "${spring.kafka.consumer.grouo-id}")
    public void consume(User user){
        LOGGER.info(String.format("Json message recieved -> %s", user.toString()));
    }
}
