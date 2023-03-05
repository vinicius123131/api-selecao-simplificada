package com.vinicius123131.fila_plugins.rest_configurations;

import com.vinicius123131.use_cases.criar_nova_pessoa.implementations.exceptions.PessoaComPropriedadesInvalidasException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlers {

    @ExceptionHandler(PessoaComPropriedadesInvalidasException.class)
    public ResponseEntity<ExeptionHandlerMessage> handle(PessoaComPropriedadesInvalidasException exception){
        return ResponseEntity.status(400).body(new ExeptionHandlerMessage(exception.getMessage()));

    }
    @AllArgsConstructor
    @Getter
    private static class ExeptionHandlerMessage {
        private final String message;

    }
}
