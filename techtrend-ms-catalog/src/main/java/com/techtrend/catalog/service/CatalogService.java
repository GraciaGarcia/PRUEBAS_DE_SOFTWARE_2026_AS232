package com.techtrend.catalog.service;

/* INTERFAZ PRINCIPAL DEL SERVICIO DE CATÁLOGO
 * Define los contratos que debe cumplir la implementación.
 * Cada método representa una operación disponible sobre productos. */

import com.techtrend.catalog.model.Product;

import java.util.List;

public interface CatalogService {

    /* LISTAR PRODUCTOS -> Retorna todos los productos registrados */
    List<Product> getAllProducts();

    /* BUSCAR POR ID -> Retorna un producto específico por su id */
    Product getProductById(Long id);

    /* VALIDAR STOCK -> Verifica si hay suficiente stock para una cantidad dada */
    boolean checkStock(Long productId, int quantity);

    /* VERIFICAR DISPONIBILIDAD -> Verifica si hay stock suficiente para la cantidad solicitada LORENZO */
    boolean verificarDisponibilidad(Long idProducto, int cantidadSolicitada);

    /* CONSULTAR DETALLES -> Retorna nombre, descripción, precio y stock de un producto */
    Product consultarDetallesProducto(Long idProducto);

    /* LISTAR PRODUCTOS DISPONIBLES -> Retorna productos con stock > 0 y filtros opcionales */
    List<Product> getAvailableProducts(String category, Double minPrice, Double maxPrice);
}
