package com.example.kafkabyramesh.kafka_service;

import com.example.kafkabyramesh.model.*;
import org.slf4j.*;
import org.springframework.kafka.core.*;
import org.springframework.kafka.support.*;
import org.springframework.messaging.*;
import org.springframework.messaging.support.*;
import org.springframework.stereotype.*;

@Service
public class JsonKafkaProducer {
    private static final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaProducer.class);

    private KafkaTemplate<String, User> kafkaTemplate;


    public JsonKafkaProducer(KafkaTemplate<String, User> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(User data){
        LOGGER.info(String.format("Message sent -> %s", data.toString()));
        Message<User> message = MessageBuilder
                .withPayload(data)
                .setHeader(KafkaHeaders.TOPIC, "javaguides")
                .build();
//        kafkaTemplate.send(topic_name, message);
        kafkaTemplate.send(message);
    }

}
