package com.example.demo.dto;

import com.example.demo.entity.enumSubscriptions.SubscriptionsType;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record SubscriptionsDTO(Long id,
                               @NotNull(message = "Subscription type cannot be null")
                               SubscriptionsType serviceName,
                               @NotNull(message = "End date cannot be null")
                               @FutureOrPresent(message = "Date can not be before now")
                               LocalDateTime endDate,
                               @NotNull(message = "User id cannot be null")
                               Long users)
{
}
