package com.petrov.payment_service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.petrov.commons.KafkaConfigProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PaymentServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaymentServiceApplication.class, args);
	}

	@Bean
	public ObjectMapper objectMapper() {
		return new ObjectMapper();
	}
	@Bean
	public KafkaConfigProperties kafkaConfigProperties() {
		return new KafkaConfigProperties();
	}

}
