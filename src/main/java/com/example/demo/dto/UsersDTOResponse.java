package com.example.demo.dto;

import java.time.Instant;

public record UsersDTOResponse(Long id, String username, Instant createdAt) {
}
