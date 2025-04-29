package com.example.agendaspring.domain.service.agenda;

import com.example.agendaspring.api.dto.agenda.AgendaDTO;
import com.example.agendaspring.api.dto.agenda.CreateAgendaDTO;
import com.example.agendaspring.domain.entity.Agenda;

import java.util.List;

public interface AgendaService {

    AgendaDTO create(CreateAgendaDTO createAgendaDTO);

    List<AgendaDTO> findAll();

    AgendaDTO findByID(Long id);


}
