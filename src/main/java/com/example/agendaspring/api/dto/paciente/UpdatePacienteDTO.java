package com.example.agendaspring.api.dto.paciente;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

public record UpdatePacienteDTO(

        @JsonProperty("nome")
        @NotBlank(message = "Nome do paciente é obrigatório")
        String nome,

        @JsonProperty("sobrenome")
        String sobrenome,

        @JsonProperty("Endereco")
        String endereco,

        @JsonProperty("email")
        @NotBlank(message = "Email do paciente é obrigatório")
        String email
) {
}
