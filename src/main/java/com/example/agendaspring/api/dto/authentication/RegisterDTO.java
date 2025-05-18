package com.example.agendaspring.api.dto.authentication;

import com.example.agendaspring.domain.enuns.RoleUser;
import jakarta.validation.constraints.NotBlank;

public record RegisterDTO(
        @NotBlank
        String login,
        @NotBlank
        String password,
        @NotBlank
        RoleUser role
) {
}
