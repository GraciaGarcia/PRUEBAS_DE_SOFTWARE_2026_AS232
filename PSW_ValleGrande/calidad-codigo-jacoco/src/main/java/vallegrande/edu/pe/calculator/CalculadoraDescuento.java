package vallegrande.edu.pe.calculator;

import vallegrande.edu.pe.model.TipoCliente;

/**
 * Clase responsable de calcular descuentos en pedidos.
 * Aplica el Principio de Responsabilidad Única (SRP).
 */
public class CalculadoraDescuento {
    
    /**
     * Umbral de monto para aplicar descuento adicional
     */
    private static final double UMBRAL_DESCUENTO_ADICIONAL = 500.0;
    
    /**
     * Monto del descuento adicional cuando se supera el umbral
     */
    private static final double DESCUENTO_ADICIONAL = 20.0;
    
    /**
     * Aplica el descuento correspondiente según el tipo de cliente
     * @param total Total antes del descuento
     * @param tipoCliente Tipo de cliente
     * @return Total con descuento aplicado
     */
    public double aplicarDescuentoCliente(double total, TipoCliente tipoCliente) {
        double descuento = total * tipoCliente.getDescuento();
        return total - descuento;
    }
    
    /**
     * Aplica descuento adicional si el total supera el umbral definido
     * @param total Total a evaluar
     * @return Total con descuento adicional aplicado (si corresponde)
     */
    public double aplicarDescuentoAdicional(double total) {
        if (total > UMBRAL_DESCUENTO_ADICIONAL) {
            return total - DESCUENTO_ADICIONAL;
        }
        return total;
    }
    
    /**
     * Obtiene el umbral para descuento adicional
     * @return Umbral de descuento adicional
     */
    public double getUmbralDescuentoAdicional() {
        return UMBRAL_DESCUENTO_ADICIONAL;
    }
    
    /**
     * Obtiene el monto del descuento adicional
     * @return Monto del descuento adicional
     */
    public double getDescuentoAdicional() {
        return DESCUENTO_ADICIONAL;
    }
}
