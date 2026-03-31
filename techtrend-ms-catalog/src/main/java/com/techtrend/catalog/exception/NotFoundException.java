package com.techtrend.catalog.exception;

/* EXCEPCIÓN PERSONALIZADA
 * Se lanza cuando no se encuentra un producto por su id.
 * Extiende RuntimeException para no forzar un try/catch en quien la llama. */
public class NotFoundException extends RuntimeException {

    public NotFoundException(Long id) {
        super("Producto no encontrado con id: " + id);
    }
}
