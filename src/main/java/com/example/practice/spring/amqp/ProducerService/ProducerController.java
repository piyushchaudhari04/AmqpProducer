package com.example.practice.spring.amqp.ProducerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class ProducerController {

    @Autowired
    EventProducer eventProducer;

    @PostMapping("message/send")
    public void sendMessage(@RequestBody Map<String,String> payload){

        String message = payload.get("message");
        String routingKey = payload.get("routing");
        System.out.println("sending the message");
        eventProducer.produceMessage(message,routingKey);

    }
}
