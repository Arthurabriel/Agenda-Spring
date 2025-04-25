package com.example.agendaspring.domain.service.Paciente;

import com.example.agendaspring.api.dto.paciente.CreatePacienteDTO;
import com.example.agendaspring.api.dto.paciente.PacienteDTO;
import com.example.agendaspring.api.dto.paciente.UpdatePacienteDTO;
import com.example.agendaspring.api.mapper.PacienteMapper;
import com.example.agendaspring.domain.entity.Paciente;
import com.example.agendaspring.domain.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class PacienteServiceImpl implements PacienteService {

    private final PacienteRepository pacienteRepository;

    public PacienteServiceImpl(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    public PacienteDTO create(CreatePacienteDTO createPacienteDTO) {
        if (pacienteRepository.existsByCpf(createPacienteDTO.getCpf())) {
            throw new IllegalArgumentException();
        }
        Paciente paciente = PacienteMapper.toPaciente(createPacienteDTO);
        pacienteRepository.save(paciente);
        return PacienteMapper.toPacienteDTO(paciente);
    }

    public PacienteDTO get(Long id) {
        Paciente paciente = getPaciente(id);
        return PacienteMapper.toPacienteDTO(paciente);
    }

    public List<PacienteDTO> listar() {
        return pacienteRepository.findAll()
                .stream()
                .map(PacienteMapper::toPacienteDTO)
                .toList();
    }

    public PacienteDTO update(Long id, UpdatePacienteDTO updatePacienteDTO) {
        Paciente paciente = getPaciente(id);
        pacienteRepository.save(paciente);
        return PacienteMapper.toPacienteDTO(paciente);
    }

    public void remove(Long id) {
        pacienteRepository.deleteById(id);
    }

    private Paciente getPaciente(Long id) {
        return pacienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Paciente não encontrado com o ID: " + id));
    }
}
