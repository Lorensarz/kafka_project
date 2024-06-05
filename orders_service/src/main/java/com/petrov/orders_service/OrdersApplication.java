package com.petrov.orders_service;

import com.petrov.commons.KafkaConfigProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class OrdersApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrdersApplication.class, args);
	}

	@Bean
	public KafkaConfigProperties kafkaConfigProperties() {
		return new KafkaConfigProperties();
	}

}
