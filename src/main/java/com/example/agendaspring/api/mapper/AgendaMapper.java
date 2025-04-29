package com.example.agendaspring.api.mapper;

import com.example.agendaspring.api.dto.agenda.AgendaDTO;
import com.example.agendaspring.api.dto.agenda.CreateAgendaDTO;
import com.example.agendaspring.domain.entity.Agenda;
import com.example.agendaspring.domain.entity.Paciente;
import com.example.agendaspring.domain.service.Paciente.PacienteServiceImpl;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.ERROR,
        uses = {PacienteMapper.class})
public interface AgendaMapper {

    @Mapping(target = "paciente", source = "paciente")
    AgendaDTO toDTO(Agenda agenda);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "paciente", source = "paciente")
    @Mapping(target = "data_criacao", expression = "java(LocalDateTime.now())")
    Agenda toAgenda(CreateAgendaDTO agendaDTO, Paciente paciente);
}
