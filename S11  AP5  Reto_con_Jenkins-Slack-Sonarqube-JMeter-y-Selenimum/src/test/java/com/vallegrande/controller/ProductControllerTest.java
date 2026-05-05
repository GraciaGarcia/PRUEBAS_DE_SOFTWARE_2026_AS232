package com.vallegrande.controller;

import com.vallegrande.model.LoginRequest;
import com.vallegrande.model.Product;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ProductControllerTest {

    private final ProductController controller = new ProductController();

    @Test
    void testGetProducts() {
        ResponseEntity<List<Product>> response = controller.getProducts();
        
        assertNotNull(response);
        assertEquals(200, response.getStatusCodeValue());
        assertNotNull(response.getBody());
        assertEquals(5, response.getBody().size());
    }

    @Test
    void testLoginSuccess() {
        LoginRequest request = new LoginRequest("admin", "admin123");
        ResponseEntity<Map<String, String>> response = controller.login(request);
        
        assertNotNull(response);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals("success", response.getBody().get("status"));
        assertNotNull(response.getBody().get("token"));
    }

    @Test
    void testLoginFailure() {
        LoginRequest request = new LoginRequest("wrong", "credentials");
        ResponseEntity<Map<String, String>> response = controller.login(request);
        
        assertNotNull(response);
        assertEquals(401, response.getStatusCodeValue());
        assertEquals("error", response.getBody().get("status"));
    }
}
