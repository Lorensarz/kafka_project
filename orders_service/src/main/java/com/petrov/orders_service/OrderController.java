package com.petrov.orders_service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
@Slf4j
public class OrderController {
    private final OrderKafkaService orderService;

    @PostMapping()
    public void createOrder(@RequestBody Order order) {
      log.info("Order: id={}, status={}", order.getOrderId(), order.getStatus());
        orderService.createOrder(order);
    }
}
