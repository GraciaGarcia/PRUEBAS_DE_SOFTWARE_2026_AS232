package service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import vallegrande.edu.pe.model.TipoCliente;
import vallegrande.edu.pe.service.PedidoService;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Pruebas unitarias para PedidoService
 * Incluye pruebas para casos positivos, negativos y límite
 */
@DisplayName("Pruebas de PedidoService")
public class PedidoServiceTest {

    private PedidoService service;

    @BeforeEach
    public void setUp() {
        service = new PedidoService();
    }

    // ========================================
    // PRUEBAS EXISTENTES (Compatibilidad con String)
    // ========================================

    @Test
    @DisplayName("Cliente VIP recibe 20% de descuento")
    public void testClienteVIP() {
        double total = service.calcularTotal(100, 2, "VIP");
        assertEquals(160, total, 0.01);
    }

    @Test
    @DisplayName("Cliente Regular recibe 10% de descuento")
    public void testClienteRegular() {
        double total = service.calcularTotal(100, 2, "REGULAR");
        assertEquals(180, total, 0.01);
    }

    @Test
    @DisplayName("Cliente sin categoría no recibe descuento")
    public void testSinDescuento() {
        double total = service.calcularTotal(100, 2, "OTRO");
        assertEquals(200, total, 0.01);
    }

    @Test
    @DisplayName("Descuento adicional de $20 cuando total > $500")
    public void testDescuentoAdicional() {
        double total = service.calcularTotal(100, 6, "REGULAR");
        assertEquals(520, total, 0.01);
    }

    // ========================================
    // NUEVAS PRUEBAS - VALIDACIONES
    // ========================================

    @Test
    @DisplayName("Lanza excepción cuando el precio es negativo")
    public void testPrecioNegativo() {
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> service.calcularTotal(-100, 2, TipoCliente.NORMAL)
        );
        assertEquals("El precio no puede ser negativo", exception.getMessage());
    }

    @Test
    @DisplayName("Lanza excepción cuando la cantidad es negativa")
    public void testCantidadNegativa() {
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> service.calcularTotal(100, -2, TipoCliente.NORMAL)
        );
        assertEquals("La cantidad no puede ser negativa", exception.getMessage());
    }

    @Test
    @DisplayName("Lanza excepción cuando el tipo de cliente es null")
    public void testTipoClienteNull() {
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> service.calcularTotal(100, 2, (TipoCliente) null)
        );
        assertEquals("El tipo de cliente no puede ser null", exception.getMessage());
    }

    // ========================================
    // NUEVAS PRUEBAS - CASOS LÍMITE
    // ========================================

    @Test
    @DisplayName("Total exactamente $500 NO recibe descuento adicional")
    public void testTotalExactamente500() {
        // Cliente NORMAL: 250 * 2 = 500 (sin descuento de cliente)
        double total = service.calcularTotal(250, 2, TipoCliente.NORMAL);
        assertEquals(500, total, 0.01);
    }

    @Test
    @DisplayName("Total $500.01 SÍ recibe descuento adicional de $20")
    public void testTotalJustoDespuesDe500() {
        // Cliente NORMAL: 250.005 * 2 = 500.01
        double total = service.calcularTotal(250.005, 2, TipoCliente.NORMAL);
        assertEquals(480.01, total, 0.01); // 500.01 - 20 = 480.01
    }

    @Test
    @DisplayName("Cliente VIP con total > $500 recibe ambos descuentos")
    public void testClienteVIPConDescuentoAdicional() {
        // VIP: 100 * 7 = 700
        // Descuento VIP (20%): 700 - 140 = 560
        // Descuento adicional: 560 - 20 = 540
        double total = service.calcularTotal(100, 7, TipoCliente.VIP);
        assertEquals(540, total, 0.01);
    }

    @Test
    @DisplayName("Precio cero retorna cero")
    public void testPrecioCero() {
        double total = service.calcularTotal(0, 5, TipoCliente.NORMAL);
        assertEquals(0, total, 0.01);
    }

    @Test
    @DisplayName("Cantidad cero retorna cero")
    public void testCantidadCero() {
        double total = service.calcularTotal(100, 0, TipoCliente.VIP);
        assertEquals(0, total, 0.01);
    }

    // ========================================
    // NUEVAS PRUEBAS - USO DE ENUM
    // ========================================

    @Test
    @DisplayName("Cliente VIP usando Enum recibe 20% de descuento")
    public void testClienteVIPConEnum() {
        double total = service.calcularTotal(100, 2, TipoCliente.VIP);
        assertEquals(160, total, 0.01);
    }

    @Test
    @DisplayName("Cliente REGULAR usando Enum recibe 10% de descuento")
    public void testClienteRegularConEnum() {
        double total = service.calcularTotal(100, 2, TipoCliente.REGULAR);
        assertEquals(180, total, 0.01);
    }

    @Test
    @DisplayName("Cliente NORMAL usando Enum no recibe descuento")
    public void testClienteNormalConEnum() {
        double total = service.calcularTotal(100, 2, TipoCliente.NORMAL);
        assertEquals(200, total, 0.01);
    }

    // ========================================
    // PRUEBAS ADICIONALES - CONVERSIÓN STRING
    // ========================================

    @Test
    @DisplayName("String vacío se convierte a cliente NORMAL")
    public void testStringVacio() {
        double total = service.calcularTotal(100, 2, "");
        assertEquals(200, total, 0.01);
    }

    @Test
    @DisplayName("String null se convierte a cliente NORMAL")
    public void testStringNull() {
        double total = service.calcularTotal(100, 2, (String) null);
        assertEquals(200, total, 0.01);
    }

    @Test
    @DisplayName("String en minúsculas funciona correctamente")
    public void testStringMinusculas() {
        double total = service.calcularTotal(100, 2, "vip");
        assertEquals(160, total, 0.01);
    }
}