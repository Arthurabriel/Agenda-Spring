package com.example.agendaspring.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(AgendaException.class)
    private ResponseEntity<CustomErrorType> handlerAgendaErrors(AgendaException exception){
        ResponseStatus status = exception.getClass().getAnnotation(ResponseStatus.class);
        return ResponseEntity.status(status.value()).body(new CustomErrorType(exception));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleValidationErrors(MethodArgumentNotValidException ex) {
        var errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(error -> Map.of(
                        "field", error.getField(),
                        "error", error.getDefaultMessage()))
                .toList();

        return ResponseEntity.badRequest().body(errors);
    }
}
