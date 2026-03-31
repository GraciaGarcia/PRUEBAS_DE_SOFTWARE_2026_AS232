package vallegrande.edu.pe.model;

/**
 * Enum que representa los tipos de cliente y sus descuentos asociados.
 * Reemplaza el uso de Strings mágicos ("VIP", "REGULAR").
 */
public enum TipoCliente {
    
    /**
     * Cliente VIP con 20% de descuento
     */
    VIP(0.20),
    
    /**
     * Cliente Regular con 10% de descuento
     */
    REGULAR(0.10),
    
    /**
     * Cliente Normal sin descuento
     */
    NORMAL(0.0);
    
    private final double descuento;
    
    /**
     * Constructor del enum
     * @param descuento Porcentaje de descuento (0.0 a 1.0)
     */
    TipoCliente(double descuento) {
        this.descuento = descuento;
    }
    
    /**
     * Obtiene el porcentaje de descuento del tipo de cliente
     * @return Descuento como decimal (ej: 0.20 para 20%)
     */
    public double getDescuento() {
        return descuento;
    }
    
    /**
     * Convierte un String al enum correspondiente
     * @param tipo String con el tipo de cliente
     * @return TipoCliente correspondiente
     * @throws IllegalArgumentException si el tipo no es válido
     */
    public static TipoCliente fromString(String tipo) {
        if (tipo == null || tipo.trim().isEmpty()) {
            return NORMAL;
        }
        
        try {
            return TipoCliente.valueOf(tipo.toUpperCase());
        } catch (IllegalArgumentException e) {
            return NORMAL;
        }
    }
}
