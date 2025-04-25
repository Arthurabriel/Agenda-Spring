package com.example.agendaspring.api.controller;

import com.example.agendaspring.api.dto.paciente.CreatePacienteDTO;
import com.example.agendaspring.api.dto.paciente.PacienteDTO;
import com.example.agendaspring.api.dto.paciente.UpdatePacienteDTO;
import com.example.agendaspring.domain.service.Paciente.PacienteService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/paciente")
public class PacienteController {

    private final PacienteService pacienteService;

    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @PostMapping()
    public ResponseEntity<PacienteDTO> save(@RequestBody @Valid CreatePacienteDTO createPacienteDTO) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(pacienteService.create(createPacienteDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PacienteDTO> getByID(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(pacienteService.get(id));
    }

    @GetMapping()
    public ResponseEntity<List<PacienteDTO>> getAll() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(pacienteService.listar());
    }

    @PutMapping("/{id}")
    public ResponseEntity<PacienteDTO> put(@RequestBody @Valid UpdatePacienteDTO updatePacienteDTO, @PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(pacienteService.update(id, updatePacienteDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        pacienteService.remove(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
