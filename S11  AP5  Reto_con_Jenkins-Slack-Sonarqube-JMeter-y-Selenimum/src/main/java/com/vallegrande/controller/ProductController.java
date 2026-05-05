package com.vallegrande.controller;

import com.vallegrande.model.Product;
import com.vallegrande.model.LoginRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping
public class ProductController {

    private List<Product> products = new ArrayList<>();

    public ProductController() {
        products.add(new Product(1L, "Laptop", "Laptop HP 15", 1200.00, 10));
        products.add(new Product(2L, "Mouse", "Mouse inalámbrico", 25.00, 50));
        products.add(new Product(3L, "Teclado", "Teclado mecánico", 80.00, 30));
        products.add(new Product(4L, "Monitor", "Monitor 24 pulgadas", 300.00, 15));
        products.add(new Product(5L, "Webcam", "Webcam HD 1080p", 60.00, 25));
    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getProducts() {
        return ResponseEntity.ok(products);
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody LoginRequest request) {
        Map<String, String> response = new HashMap<>();
        
        if ("admin".equals(request.getUsername()) && "admin123".equals(request.getPassword())) {
            response.put("status", "success");
            response.put("message", "Login exitoso");
            response.put("token", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9");
            return ResponseEntity.ok(response);
        }
        
        response.put("status", "error");
        response.put("message", "Credenciales inválidas");
        return ResponseEntity.status(401).body(response);
    }
}
