package com.example.agendaspring.api.dto.agenda;

import com.example.agendaspring.api.dto.paciente.PacienteDTO;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

public record AgendaDTO(
        Long id,
        String descricao,
        @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
        LocalDateTime dataCriacao,
        @DateTimeFormat(pattern = "dd/MM/yyyy HHmmss")
        LocalDateTime dataConsulta,
        PacienteDTO paciente
) {
}
