package com.petrov.shipping_service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class KafkaConsumerService {

    private final MessageMapper messageMapper;
    private final KafkaTemplate<String, Order> kafkaTemplate;

    @Value("${spring.kafka.topic.create-notification}")
    private String kafkaTopicNotification;

    @KafkaListener(topics = "${spring.kafka.topic.create-shipping}", groupId = "order")
    public void receiveOrder(ConsumerRecord<String, String> orderRecord) {

        Order order = messageMapper.mapRecordMessageToDto(orderRecord.value(), Order.class).orElseThrow();

        log.info("Received new order: key={}, value={}, offset={}",
                orderRecord.key(),
                order,
                orderRecord.offset()
        );

        order.setStatus("SHIPPING");

        kafkaTemplate.send(kafkaTopicNotification, order);
    }


}
