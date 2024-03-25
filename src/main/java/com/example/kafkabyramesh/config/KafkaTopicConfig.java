package com.example.kafkabyramesh.config;

import org.apache.kafka.clients.admin.*;
import org.springframework.context.annotation.*;
import org.springframework.kafka.config.*;

@Configuration
public class KafkaTopicConfig {

    //todo : create a kafka topic where producer sends messages to.
    @Bean
    public NewTopic javaguidesTopic(){
        return TopicBuilder.name("javaguides")
                .build();
    }

}
