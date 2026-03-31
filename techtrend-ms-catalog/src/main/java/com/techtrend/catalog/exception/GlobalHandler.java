package com.techtrend.catalog.exception;

/* MANEJADOR GLOBAL DE ERRORES
 * Intercepta excepciones lanzadas en cualquier controller.
 * Convierte NotFoundException en una respuesta HTTP 404 con mensaje de error. */

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
public class GlobalHandler {

    /* CAPTURA NotFoundException -> Responde 404 con el mensaje del error */
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<Map<String, String>> handleNotFound(NotFoundException ex) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(Map.of("error", ex.getMessage()));
    }
}
