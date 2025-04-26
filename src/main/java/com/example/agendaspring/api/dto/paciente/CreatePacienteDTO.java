package com.example.agendaspring.api.dto.paciente;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

public record CreatePacienteDTO(

        @JsonProperty("nome")
        @NotBlank(message = "Nome do paciente é obrigatório")
        String nome,

        @JsonProperty("sobrenome")
        String sobrenome,

        @JsonProperty("Endereco")
        String endereco,

        @JsonProperty("email")
        @NotBlank(message = "Email do paciente é obrigatório")
        String email,

        @JsonProperty("cpf")
        @Pattern(regexp = "\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}", message = "CPF deve estar no formato XXX.XXX.XXX-XX")
        String cpf
) {
}
