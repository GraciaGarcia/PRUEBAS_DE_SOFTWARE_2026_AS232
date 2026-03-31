package vallegrande.edu.pe.service;

import vallegrande.edu.pe.calculator.CalculadoraDescuento;
import vallegrande.edu.pe.model.TipoCliente;
import vallegrande.edu.pe.validator.ValidadorPedido;

/**
 * Servicio para gestionar el cálculo de totales de pedidos.
 * Aplica descuentos según el tipo de cliente y el monto total.
 */
public class PedidoService {
    
    private final ValidadorPedido validador;
    private final CalculadoraDescuento calculadora;
    
    /**
     * Constructor por defecto
     */
    public PedidoService() {
        this.validador = new ValidadorPedido();
        this.calculadora = new CalculadoraDescuento();
    }
    
    /**
     * Constructor con inyección de dependencias (para testing)
     */
    public PedidoService(ValidadorPedido validador, CalculadoraDescuento calculadora) {
        this.validador = validador;
        this.calculadora = calculadora;
    }

    /**
     * Calcula el total de un pedido aplicando descuentos.
     * MÉTODO LEGACY - Mantiene compatibilidad con código existente.
     * 
     * @param precio Precio unitario del producto
     * @param cantidad Cantidad de productos
     * @param tipoCliente Tipo de cliente como String ("VIP", "REGULAR", etc.)
     * @return Total del pedido con descuentos aplicados
     * @deprecated Usar {@link #calcularTotal(double, int, TipoCliente)} en su lugar
     */
    @Deprecated
    public double calcularTotal(double precio, int cantidad, String tipoCliente) {
        TipoCliente tipo = TipoCliente.fromString(tipoCliente);
        return calcularTotal(precio, cantidad, tipo);
    }
    
    /**
     * Calcula el total de un pedido aplicando descuentos.
     * Versión refactorizada que usa Enum.
     * 
     * @param precio Precio unitario del producto
     * @param cantidad Cantidad de productos
     * @param tipoCliente Tipo de cliente (Enum)
     * @return Total del pedido con descuentos aplicados
     * @throws IllegalArgumentException si los parámetros son inválidos
     */
    public double calcularTotal(double precio, int cantidad, TipoCliente tipoCliente) {
        // 1. Validar entradas
        validador.validar(precio, cantidad, tipoCliente);
        
        // 2. Calcular subtotal
        double total = calcularSubtotal(precio, cantidad);
        
        // 3. Aplicar descuento por tipo de cliente
        total = calculadora.aplicarDescuentoCliente(total, tipoCliente);
        
        // 4. Aplicar descuento adicional si corresponde
        total = calculadora.aplicarDescuentoAdicional(total);
        
        return total;
    }
    
    /**
     * Calcula el subtotal (precio * cantidad)
     * @param precio Precio unitario
     * @param cantidad Cantidad de productos
     * @return Subtotal
     */
    private double calcularSubtotal(double precio, int cantidad) {
        return precio * cantidad;
    }
}