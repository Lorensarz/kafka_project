package com.petrov.notification_service;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Slf4j
@Component
@RequiredArgsConstructor
public class MessageMapper {

    private final ObjectMapper objectMapper;

    public <T> Optional<T> mapRecordMessageToDto(String jsonString, Class<T> clazz) {
        try {
            return Optional.of(objectMapper.readValue(jsonString, clazz));
        } catch (JsonProcessingException e) {
            log.error("Error parsing JSON: {}", e.getMessage());
            return Optional.empty();
        }
    }
}