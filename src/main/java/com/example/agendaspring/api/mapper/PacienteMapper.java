package com.example.agendaspring.api.mapper;

import com.example.agendaspring.api.dto.paciente.CreatePacienteDTO;
import com.example.agendaspring.api.dto.paciente.PacienteDTO;
import com.example.agendaspring.domain.entity.Paciente;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface PacienteMapper {

    PacienteDTO toDTO(Paciente paciente);

    Paciente toPaciente(CreatePacienteDTO createPacienteDTO);
}
