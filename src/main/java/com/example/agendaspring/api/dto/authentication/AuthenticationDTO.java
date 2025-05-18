package com.example.agendaspring.api.dto.authentication;

import jakarta.validation.constraints.NotBlank;

public record AuthenticationDTO(
        @NotBlank
        String login,
        String password
) { }
