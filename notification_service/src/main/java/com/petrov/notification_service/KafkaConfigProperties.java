package com.petrov.notification_service;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "spring.kafka")
@Getter
@Setter
public class KafkaConfigProperties {

    private String bootstrapServers;
    private String acksConfig;
    private String enableIdempotenceConfig;
    private String maxInFlightRequestsPerConnection;
}
