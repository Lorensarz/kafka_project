package com.petrov.notification_service;

import com.petrov.commons.OrderDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class KafkaConsumerService {

    private final MessageMapper messageMapper;

    @KafkaListener(topics = "${spring.kafka.topic.notification}", groupId = "order")
    public void receiveOrder(ConsumerRecord<String, String> orderRecord) {

        OrderDto order = messageMapper.mapRecordMessageToDto(orderRecord.value(), OrderDto.class).orElseThrow();

        log.info("Received new order: key={}, value={}, offset={}",
                orderRecord.key(),
                order,
                orderRecord.offset()
        );

        order.setStatus("DELIVERED");

        log.info("Order id: id={}, status: status={}", order.getOrderId(), order.getStatus());

    }


}
