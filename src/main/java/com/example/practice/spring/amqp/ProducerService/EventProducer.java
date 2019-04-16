package com.example.practice.spring.amqp.ProducerService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class EventProducer {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private EventProducerConfiguration eventProducerConfiguration;
    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public EventProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void produceMessage(String message,String routingKey){

        logger.info("Sending the message to the queue");
        rabbitTemplate.setExchange(eventProducerConfiguration.eventExchange().getName());
        rabbitTemplate.convertAndSend(routingKey,message);
        logger.info("Message send on the exchange: "+eventProducerConfiguration.eventExchange().getName()+"with routing key: "+routingKey);
    }
}
