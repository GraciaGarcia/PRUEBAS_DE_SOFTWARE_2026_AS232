package com.techtrend.catalog.service.impl;

import com.techtrend.catalog.exception.NotFoundException;
import com.techtrend.catalog.model.Product;
import com.techtrend.catalog.repository.ProductRepository;
import com.techtrend.catalog.service.CatalogService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatalogServiceImpl implements CatalogService {

    private final ProductRepository repository;

    public CatalogServiceImpl(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    @Override
    public Product getProductById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException(id));
    }

    @Override
    public boolean checkStock(Long productId, int quantity) {
        if (quantity < 0) {
            throw new IllegalArgumentException("La cantidad no puede ser negativa");
        }
        Product product = getProductById(productId);
        return product.getStock() >= quantity;
    }

    @Override
    public boolean verificarDisponibilidad(Long idProducto, int cantidadSolicitada) {
        return checkStock(idProducto, cantidadSolicitada);
    }

    /* CONSULTAR DETALLES DEL PRODUCTO 
     * Busca el producto por id y retorna su información completa.
     * Si no existe, lanza NotFoundException y GlobalHandler responde 404. */
    @Override
    public Product consultarDetallesProducto(Long idProducto) {
        return repository.findById(idProducto)
                .orElseThrow(() -> new NotFoundException(idProducto));
    }

    /* LISTAR PRODUCTOS DISPONIBLES CON FILTROS OPCIONALES
     * Retorna productos con stock > 0, status activo y filtros opcionales por categoría y precio */
    @Override
    public List<Product> getAvailableProducts(String category, Double minPrice, Double maxPrice) {
        List<Product> products = repository.findAll();

        // Filtrar por productos con stock > 0 y status activo
        return products.stream()
                .filter(p -> p.getStock() > 0)
                .filter(p -> "A".equalsIgnoreCase(p.getStatus()))
                .filter(p -> category == null || category.equalsIgnoreCase(p.getCategory()))
                .filter(p -> minPrice == null || p.getPrice() >= minPrice)
                .filter(p -> maxPrice == null || p.getPrice() <= maxPrice)
                .toList();
    }
}
