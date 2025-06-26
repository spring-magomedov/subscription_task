package com.example.demo.dto;

import jakarta.validation.constraints.NotBlank;

public record UsersDTO(Long id, @NotBlank(message = "Username can not be blank") String username,
                       @NotBlank(message = "Password can not be blank") String password) {
}
