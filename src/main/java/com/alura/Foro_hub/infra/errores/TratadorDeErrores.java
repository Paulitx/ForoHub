package com.alura.Foro_hub.infra.errores;

import com.alura.Foro_hub.dominio.ValidacionException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver;

import java.sql.SQLIntegrityConstraintViolationException;

@RestControllerAdvice
public class TratadorDeErrores {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity tratarError404(){
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity tratarError400(MethodArgumentNotValidException e){
        var errores = e.getFieldErrors().stream().map(DatosErrorValidacion::new).toList();
        return ResponseEntity.badRequest().body(errores);
    }

    @ExceptionHandler(ValidacionException.class)
    public ResponseEntity tratarErrorDeValidacion(ValidacionException e){
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    private record DatosErrorValidacion(String campo, String error){
        public DatosErrorValidacion(FieldError error) {
            this(error.getField(), error.getDefaultMessage());
        }
    }

    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public ResponseEntity tratarErrorMensajeDuplicado(SQLIntegrityConstraintViolationException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity tratarError403(HttpMessageNotReadableException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }



}
