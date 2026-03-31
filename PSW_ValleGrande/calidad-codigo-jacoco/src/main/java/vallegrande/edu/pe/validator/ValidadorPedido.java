package vallegrande.edu.pe.validator;

import vallegrande.edu.pe.model.TipoCliente;

/**
 * Clase responsable de validar los datos de entrada de un pedido.
 * Aplica el Principio de Responsabilidad Única (SRP).
 */
public class ValidadorPedido {
    
    /**
     * Valida que los parámetros del pedido sean correctos
     * @param precio Precio unitario del producto
     * @param cantidad Cantidad de productos
     * @param tipoCliente Tipo de cliente
     * @throws IllegalArgumentException si algún parámetro es inválido
     */
    public void validar(double precio, int cantidad, TipoCliente tipoCliente) {
        validarPrecio(precio);
        validarCantidad(cantidad);
        validarTipoCliente(tipoCliente);
    }
    
    /**
     * Valida que el precio sea válido (mayor o igual a 0)
     * @param precio Precio a validar
     * @throws IllegalArgumentException si el precio es negativo
     */
    private void validarPrecio(double precio) {
        if (precio < 0) {
            throw new IllegalArgumentException("El precio no puede ser negativo");
        }
    }
    
    /**
     * Valida que la cantidad sea válida (mayor o igual a 0)
     * @param cantidad Cantidad a validar
     * @throws IllegalArgumentException si la cantidad es negativa
     */
    private void validarCantidad(int cantidad) {
        if (cantidad < 0) {
            throw new IllegalArgumentException("La cantidad no puede ser negativa");
        }
    }
    
    /**
     * Valida que el tipo de cliente no sea nulo
     * @param tipoCliente Tipo de cliente a validar
     * @throws IllegalArgumentException si el tipo de cliente es null
     */
    private void validarTipoCliente(TipoCliente tipoCliente) {
        if (tipoCliente == null) {
            throw new IllegalArgumentException("El tipo de cliente no puede ser null");
        }
    }
}
