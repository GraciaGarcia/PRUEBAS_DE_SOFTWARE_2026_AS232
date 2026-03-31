package com.techtrend.catalog.controller;

import com.techtrend.catalog.model.Product;
import com.techtrend.catalog.service.CatalogService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/catalog")
public class CatalogController {

    private final CatalogService service;

    public CatalogController(CatalogService service) {
        this.service = service;
    }

    // Listar todos los productos
    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return service.getAllProducts();
    }

    // Obtener producto por ID
    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getProductById(id));
    }

    /* CONSULTAR DETALLES DEL PRODUCTO (Miembro 4)
     * GET /api/catalog/productos/{id}
     * Retorna 200 OK con el producto, o 404 si no existe. */
    @GetMapping("/productos/{id}")
    public ResponseEntity<Product> consultarDetallesProducto(@PathVariable Long id) {
        return ResponseEntity.ok(service.consultarDetallesProducto(id));
    }

    // Validar stock
    @GetMapping("/stock")
    public boolean checkStock(
            @RequestParam Long id,
            @RequestParam int quantity
    ) {
        return service.checkStock(id, quantity);
    }

    // Listar productos disponibles con filtros opcionales
    @GetMapping("/available")
    public List<Product> getAvailableProducts(
            @RequestParam(required = false) String category,
            @RequestParam(required = false) Double minPrice,
            @RequestParam(required = false) Double maxPrice
    ) {
        return service.getAvailableProducts(category, minPrice, maxPrice);
    }
}
