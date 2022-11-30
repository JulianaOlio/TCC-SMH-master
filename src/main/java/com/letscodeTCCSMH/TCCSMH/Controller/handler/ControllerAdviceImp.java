package com.letscodeTCCSMH.TCCSMH.Controller.handler;

import com.letscodeTCCSMH.TCCSMH.Model.CadastroUsuario;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ControllerAdviceImp {

    @ExceptionHandler
    public ResponseEntity<String> beanValidationHandler(MethodArgumentNotValidException e, HttpServletRequest req) {
        for (FieldError fe : e.getBindingResult().getFieldErrors()) {
            return ResponseEntity.status(400).body("Erro: " + fe.getDefaultMessage());
        }
        return ResponseEntity.status(400).body("Erro inesperado");
    }

}
