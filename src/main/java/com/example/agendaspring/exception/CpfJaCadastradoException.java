package com.example.agendaspring.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class CpfJaCadastradoException extends AgendaException {
    public CpfJaCadastradoException() {
        super("CPF do paciente já cadastrado no sistema");
    }
}
