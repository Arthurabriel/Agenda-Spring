package com.example.agendaspring.domain.service.Paciente;

import com.example.agendaspring.api.dto.paciente.CreatePacienteDTO;
import com.example.agendaspring.api.dto.paciente.PacienteDTO;
import com.example.agendaspring.api.dto.paciente.UpdatePacienteDTO;

import java.util.List;

public interface PacienteService {

    PacienteDTO create(CreatePacienteDTO createPacienteDTO);

    PacienteDTO update(Long id, UpdatePacienteDTO updatePacienteDTO);

    List<PacienteDTO> listar();

    PacienteDTO get(Long id);

    void remove(Long id);

}
