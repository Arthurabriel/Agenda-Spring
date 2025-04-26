package com.example.agendaspring.api.mapper;

import com.example.agendaspring.api.dto.paciente.CreatePacienteDTO;
import com.example.agendaspring.api.dto.paciente.PacienteDTO;
import com.example.agendaspring.api.dto.paciente.UpdatePacienteDTO;
import com.example.agendaspring.domain.entity.Paciente;
import org.mapstruct.*;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
    unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface PacienteMapper {

    PacienteDTO toDTO(Paciente paciente);

    @Mapping(target = "id", ignore = true)
    Paciente toPaciente(CreatePacienteDTO createPacienteDTO);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "cpf", ignore = true)
    Paciente updatePaciente(@MappingTarget Paciente paciente, UpdatePacienteDTO createPacienteDTO);
}
