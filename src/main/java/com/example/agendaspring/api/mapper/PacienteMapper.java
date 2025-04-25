package com.example.agendaspring.api.mapper;

import com.example.agendaspring.api.dto.paciente.CreatePacienteDTO;
import com.example.agendaspring.api.dto.paciente.PacienteDTO;
import com.example.agendaspring.domain.entity.Paciente;
import org.springframework.stereotype.Component;

@Component
public class PacienteMapper {

    public static PacienteDTO toPacienteDTO(Paciente paciente) {
        if (paciente == null) {
            return null;
        }

        return PacienteDTO.builder()
                .id(paciente.getId())
                .nome(paciente.getNome())
                .sobrenome(paciente.getSobrenome())
                .endereco(paciente.getEndereco())
                .email(paciente.getEmail())
                .cpf(paciente.getCpf())
                .build();
    }

    public static Paciente toPaciente(CreatePacienteDTO createPacienteDTO) {
        return Paciente.builder()
                .nome(createPacienteDTO.getNome())
                .sobrenome(createPacienteDTO.getSobrenome())
                .endereco(createPacienteDTO.getEndereco())
                .email(createPacienteDTO.getEmail())
                .cpf(createPacienteDTO.getCpf())
                .build();
    }
}
