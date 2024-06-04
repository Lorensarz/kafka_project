package com.petrov.orders_service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderKafkaService {

    private final KafkaTemplate<String, Order> kafkaTemplate;

    @Value("${spring.kafka.topic.create-order}")
    private String kafkaTopicPayment;


    public void createOrder(Order order) {
        kafkaTemplate.send(kafkaTopicPayment, order);
    }
}
