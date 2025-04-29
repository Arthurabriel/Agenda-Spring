package com.example.agendaspring.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class AgendaNaoExiste extends AgendaException {
    public AgendaNaoExiste(Long id) {
        super("Agenda não encontrado com o ID: "+ id);
    }
}
