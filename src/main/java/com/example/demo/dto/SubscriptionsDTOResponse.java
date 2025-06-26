package com.example.demo.dto;

import com.example.demo.entity.enumSubscriptions.SubscriptionsType;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;

import java.time.Instant;
import java.time.LocalDateTime;

public record SubscriptionsDTOResponse(Long id,
                                       SubscriptionsType serviceName,
                                       LocalDateTime startDate,
                                       LocalDateTime endDate) {
}
