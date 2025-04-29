package com.example.agendaspring.api.controller;

import com.example.agendaspring.api.dto.agenda.AgendaDTO;
import com.example.agendaspring.api.dto.agenda.CreateAgendaDTO;
import com.example.agendaspring.domain.service.agenda.AgendaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agenda")
@RequiredArgsConstructor
public class AgendaController {
    
    private final AgendaService agendaService;

    @PostMapping
    public ResponseEntity<AgendaDTO> create(@RequestBody @Valid CreateAgendaDTO createAgendaDTO) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(agendaService.create(createAgendaDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AgendaDTO> getById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(agendaService.findByID(id));
    }

    @GetMapping
    public ResponseEntity<List<AgendaDTO>> getAll() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(agendaService.findAll());
    }
}
