package com.example.agendaspring.domain.service.Paciente;

import com.example.agendaspring.api.dto.paciente.CreatePacienteDTO;
import com.example.agendaspring.api.dto.paciente.PacienteDTO;
import com.example.agendaspring.api.dto.paciente.UpdatePacienteDTO;
import com.example.agendaspring.api.mapper.PacienteMapper;
import com.example.agendaspring.domain.entity.Paciente;
import com.example.agendaspring.domain.repository.PacienteRepository;
import com.example.agendaspring.exception.CpfJaCadastradoException;
import com.example.agendaspring.exception.PacienteNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;


@Service
@RequiredArgsConstructor
@Transactional
public class PacienteServiceImpl implements PacienteService {

    private final PacienteRepository pacienteRepository;

    private final PacienteMapper pacienteMapper;

    public PacienteDTO create(CreatePacienteDTO createPacienteDTO) {
        if (pacienteRepository.existsByCpf(createPacienteDTO.cpf())) {
            throw new CpfJaCadastradoException();
        }
        Paciente paciente = pacienteMapper.toPaciente(createPacienteDTO);
        pacienteRepository.save(paciente);
        return pacienteMapper.toDTO(paciente);
    }

    public PacienteDTO get(Long id) {
        Paciente paciente = getPaciente(id);
        return pacienteMapper.toDTO(paciente);
    }

    public List<PacienteDTO> listar() {
        return pacienteRepository.findAll()
                .stream()
                .map(pacienteMapper::toDTO)
                .toList();
    }

    public PacienteDTO update(Long id, UpdatePacienteDTO updatePacienteDTO) {
        Paciente paciente = getPaciente(id);
        paciente = pacienteMapper.updatePaciente(paciente, updatePacienteDTO);
        pacienteRepository.save(paciente);
        return pacienteMapper.toDTO(paciente);
    }

    public void remove(Long id) {
        pacienteRepository.deleteById(id);
    }

    private Paciente getPaciente(Long id) {
        return pacienteRepository.findById(id)
                .orElseThrow(() -> new PacienteNotFoundException(id));
    }
}
