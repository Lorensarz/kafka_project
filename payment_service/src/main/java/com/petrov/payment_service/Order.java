package com.petrov.payment_service;

import lombok.Data;

@Data
public class Order {

    private Long orderId;
    private String status;

}
