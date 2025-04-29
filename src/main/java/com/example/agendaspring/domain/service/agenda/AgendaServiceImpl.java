package com.example.agendaspring.domain.service.agenda;

import com.example.agendaspring.api.dto.agenda.AgendaDTO;
import com.example.agendaspring.api.dto.agenda.CreateAgendaDTO;
import com.example.agendaspring.api.mapper.AgendaMapper;
import com.example.agendaspring.domain.entity.Agenda;
import com.example.agendaspring.domain.entity.Paciente;
import com.example.agendaspring.domain.repository.AgendaRepository;
import com.example.agendaspring.domain.service.Paciente.PacienteService;
import com.example.agendaspring.domain.service.Paciente.PacienteServiceImpl;
import com.example.agendaspring.exception.AgendaNaoExiste;
import com.example.agendaspring.exception.PacienteNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AgendaServiceImpl implements AgendaService {

    private final AgendaRepository agendaRepository;
    private final AgendaMapper agendaMapper;
    private final PacienteService pacienteService;

    @Override
    public AgendaDTO create(CreateAgendaDTO createAgendaDTO) {
        Paciente paciente = pacienteService.getPaciente(createAgendaDTO.paciente_id());
        Agenda agenda = agendaMapper.toAgenda(createAgendaDTO, paciente);
        agendaRepository.save(agenda);
        return agendaMapper.toDTO(agenda);
    }

    @Override
    public List<AgendaDTO> findAll() {
        return agendaRepository.findAll().stream().map(agendaMapper::toDTO).toList();
    }

    @Override
    public AgendaDTO findByID(Long id) {
        Agenda agenda = getAgenda(id);
        return agendaMapper.toDTO(agenda);
    }

    private Agenda getAgenda(Long id) {
        return agendaRepository.findById(id).orElseThrow(() -> new AgendaNaoExiste(id));

    }
}
