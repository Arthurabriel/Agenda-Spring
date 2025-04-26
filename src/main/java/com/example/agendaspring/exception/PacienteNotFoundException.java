package com.example.agendaspring.exception;

import com.example.agendaspring.domain.entity.Agenda;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class PacienteNotFoundException extends AgendaException {

    public PacienteNotFoundException(Long id) {
        super("Paciente não encontrado com o ID: "+ id);
    }
}
