package com.example.agendaspring.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "paciente")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotBlank
    private String nome;

    @Column(nullable = false)
    private String sobrenome;

    private String endereco;

    @NotBlank
    private String email;

    @NotBlank
    @Pattern(
            regexp = "^\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}$",
            message = "CPF inválido. Use o formato XXX.XXX.XXX-XX"
    )
    @Column(name = "cpf" , nullable = false, unique = true)
    private String cpf;
}
