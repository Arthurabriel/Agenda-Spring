package com.example.agendaspring.api.dto.paciente;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdatePacienteDTO {

    @JsonProperty("nome")
    @NotBlank
    private String nome;

    @JsonProperty("Endereco")
    private String endereco;

    @JsonProperty("email")
    @NotBlank
    private String email;
}
