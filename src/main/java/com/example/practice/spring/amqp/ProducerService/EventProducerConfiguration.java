package com.example.practice.spring.amqp.ProducerService;

import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EventProducerConfiguration {

    @Value("${producer.exchange}")
    private String exchange;

    @Bean
    TopicExchange eventExchange(){
        return new TopicExchange(exchange);
    }
}
