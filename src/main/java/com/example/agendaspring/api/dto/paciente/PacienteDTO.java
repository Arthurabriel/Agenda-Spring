package com.example.agendaspring.api.dto.paciente;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PacienteDTO {

    @JsonProperty("id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty("nome")
    @NotBlank
    private String nome;

    @JsonProperty("Endereco")
    private String endereco;

    @JsonProperty("email")
    @NotBlank
    private String email;

    @JsonIgnore
    @NotBlank
    @Pattern(
            regexp = "^\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}$",
            message = "CPF inválido. Use o formato XXX.XXX.XXX-XX"
    )
    private String cpf;
}
