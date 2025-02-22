package com.example.agendaspring.domain.service.Paciente;

import com.example.agendaspring.api.dto.paciente.CreatePacienteDTO;
import com.example.agendaspring.api.dto.paciente.PacienteDTO;
import com.example.agendaspring.api.dto.paciente.UpdatePacienteDTO;
import com.example.agendaspring.domain.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PacienteServiceImpl implements PacienteService{

    private final PacienteRepository pacienteRepository;

    public PacienteServiceImpl(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    @Override
    public PacienteDTO create(CreatePacienteDTO createPacienteDTO) {
        return null;
    }

    @Override
    public PacienteDTO update(Long id, UpdatePacienteDTO updatePacienteDTO) {
        return null;
    }

    @Override
    public List<PacienteDTO> listar() {
        return List.of();
    }

    @Override
    public PacienteDTO get(Long id) {
        return null;
    }

    @Override
    public void remove(Long id) {

    }
}
