package com.techtrend.catalog.service;

import com.techtrend.catalog.exception.NotFoundException;
import com.techtrend.catalog.model.Product;
import com.techtrend.catalog.repository.ProductRepository;
import com.techtrend.catalog.service.impl.CatalogServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class CatalogServiceTest {

    @Test
    void shouldReturnTrueWhenStockIsSufficient() {

        final String testName = "StockSuficiente";
        System.out.println("[START] " + testName + " -> validando que el stock es suficiente");

        // 1. Crear mock del repository
        ProductRepository repository = Mockito.mock(ProductRepository.class);

        // 2. Crear service con el mock (CatalogServiceImpl implementa CatalogService)
        CatalogService service = new CatalogServiceImpl(repository);

        try {
            // 3. Producto simulado
            Product product = new Product(2L, "Laptop", 2500, 10, "A");

            // 4. Simular comportamiento
            when(repository.findById(2L)).thenReturn(Optional.of(product));

            // 5. Ejecutar método
            boolean result = service.checkStock(2L, 5);

            // 6. Validar resultado
            assertTrue(result, "Se esperaba true cuando el stock es suficiente");

            System.out.println("[OK] " + testName + " -> validacion correcta (stock suficiente)");

        } catch (AssertionError assertionError) {
            System.out.println("[FAIL] " + testName + " -> " + assertionError.getMessage());
            throw assertionError;
        } catch (Exception exception) {
            System.out.println("[ERROR] " + testName + " -> error inesperado: " + exception.getMessage());
            throw exception;
        }
    }

    //TESTEO LORENZO
    @Test
    void shouldReturnTrueWhenVerificarDisponibilidadHasEnoughStock() {
        final String testName = "DisponibilidadSuficiente";
        System.out.println("[START] " + testName + " -> validando disponibilidad con stock suficiente");

        ProductRepository repository = Mockito.mock(ProductRepository.class);
        CatalogService service = new CatalogServiceImpl(repository);

        try {
            Product product = new Product(3L, "Monitor", 900, 7, "A");
            when(repository.findById(3L)).thenReturn(Optional.of(product));

            boolean result = service.verificarDisponibilidad(3L, 4);

            assertTrue(result, "Se esperaba true cuando verificarDisponibilidad tiene stock suficiente");
            System.out.println("[OK] " + testName + " -> validacion correcta (stock suficiente)");
        } catch (AssertionError assertionError) {
            System.out.println("[FAIL] " + testName + " -> " + assertionError.getMessage());
            throw assertionError;
        } catch (Exception exception) {
            System.out.println("[ERROR] " + testName + " -> error inesperado: " + exception.getMessage());
            throw exception;
        }
    }

    @Test
    void shouldReturnFalseWhenVerificarDisponibilidadHasInsufficientStock() {
        final String testName = "DisponibilidadInsuficiente";
        System.out.println("[START] " + testName + " -> validando disponibilidad con stock insuficiente");

        ProductRepository repository = Mockito.mock(ProductRepository.class);
        CatalogService service = new CatalogServiceImpl(repository);

        try {
            Product product = new Product(4L, "Teclado", 120, 2, "A");
            when(repository.findById(4L)).thenReturn(Optional.of(product));

            boolean result = service.verificarDisponibilidad(4L, 5);

            assertFalse(result, "Se esperaba false cuando verificarDisponibilidad no tiene stock suficiente");
            System.out.println("[OK] " + testName + " -> validacion correcta (stock insuficiente)");
        } catch (AssertionError assertionError) {
            System.out.println("[FAIL] " + testName + " -> " + assertionError.getMessage());
            throw assertionError;
        } catch (Exception exception) {
            System.out.println("[ERROR] " + testName + " -> error inesperado: " + exception.getMessage());
            throw exception;
        }
    }

    // Miembro 4 - prueba: consultar detalles de un producto existente
    @Test
    void shouldReturnProductDetailsWhenProductExists() {
        ProductRepository repository = Mockito.mock(ProductRepository.class);
        CatalogService service = new CatalogServiceImpl(repository);

        Product product = new Product(1L, "Laptop", 3500, 10, "A");
        when(repository.findById(1L)).thenReturn(Optional.of(product));

        Product result = service.consultarDetallesProducto(1L);

        assertNotNull(result);
        assertEquals("Laptop", result.getName());
        assertEquals(3500, result.getPrice());
        assertEquals(10, result.getStock());
    }

    // Miembro 4 - prueba: producto inexistente lanza NotFoundException
    @Test
    void shouldThrowNotFoundWhenProductDoesNotExist() {
        ProductRepository repository = Mockito.mock(ProductRepository.class);
        CatalogService service = new CatalogServiceImpl(repository);

        when(repository.findById(99L)).thenReturn(Optional.empty());

        assertThrows(NotFoundException.class, () -> service.consultarDetallesProducto(99L));
    }
}
