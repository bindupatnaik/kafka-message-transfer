package com.example.kafkabyramesh.controller;

import com.example.kafkabyramesh.kafka_service.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/kafka")
public class MessageController {

    //todo - inject the kafka producer service and call sendMessage
    private KafkaProducer kafkaProducer;

    @Autowired
    public MessageController(KafkaProducer kafkaProducer){
        this.kafkaProducer = kafkaProducer;
    }

    // http:localhost:8080/api/v1/kafka/publish?message=hello world
    @GetMapping("/publish")
    public ResponseEntity<String> publish(@RequestParam("message") String message){
        kafkaProducer.sendMessage(message);
        return ResponseEntity.ok("Message sent to the topic");
    }
}
