package com.example.agendaspring.api.dto.paciente;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record PacienteDTO(

        Long id,

        @JsonProperty("nome")
        String nome,

        @JsonProperty("sobrenome")
        String sobrenome,

        @JsonProperty("Endereco")
        String endereco,

        @JsonProperty("email")
        String email,

        @JsonProperty("cpf")
        String cpf
) {
}
