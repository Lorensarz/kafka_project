package com.petrov.orders_service;

import lombok.Data;

@Data
public class Order {

    private Long orderId;
    private String status;
}
