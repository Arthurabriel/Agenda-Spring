package com.example.agendaspring.api.dto.agenda;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

public record CreateAgendaDTO(
        String descricao,
        @NotNull
        @Future(message = "A data e hora da consulta deve ser no futuro")
        @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
        LocalDateTime dataConsulta,

        @NotNull
        Long paciente_id
        ) {
}
