package com.example.agendaspring.api.mapper;


import com.example.agendaspring.api.dto.agenda.AgendaDTO;
import com.example.agendaspring.api.dto.authentication.RegisterDTO;
import com.example.agendaspring.domain.entity.Agenda;
import com.example.agendaspring.domain.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.ERROR,
        uses = {PacienteMapper.class})
public interface UserMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "authorities", ignore = true)
    User register(RegisterDTO registerDTO);
}
