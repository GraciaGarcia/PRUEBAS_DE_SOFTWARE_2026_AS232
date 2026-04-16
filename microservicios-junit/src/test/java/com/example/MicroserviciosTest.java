package com.example;

// Importaciones de JUnit 5 para las pruebas
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

// Importaciones de Gson para parsear JSON
import com.google.gson.JsonObject;

// Importaciones de assertions de JUnit
import static org.junit.jupiter.api.Assertions.*;

/**
 * CLASE DE PRUEBAS AUTOMATIZADAS PARA MICROSERVICIOS
 * 
 * Esta clase contiene pruebas automatizadas que validan el funcionamiento
 * de los endpoints de la API JSONPlaceholder, simulando un microservicio
 * de comercio electrónico.
 * 
 * Las pruebas cubren tres escenarios principales:
 * 1. Consulta de datos (GET)
 * 2. Creación de recursos (POST)
 * 3. Manejo de errores (404)
 */
@DisplayName("Pruebas de Microservicios - JSONPlaceholder API")
public class MicroserviciosTest {

    /**
     * PRUEBA 1: GET - CONSULTAR DATOS DE UN USUARIO
     * 
     * Objetivo: Verificar que el microservicio devuelve información válida
     * al consultar un usuario específico.
     * 
     * Endpoint: GET /users/1
     * 
     * Validaciones:
     * - Código de respuesta HTTP 200 (OK)
     * - Existencia de datos en la respuesta JSON
     * - Validación de campos específicos (id, name, email)
     * - Validación de objetos anidados (address, company)
     * - Validación de datos dentro de objetos anidados
     */
    @Test
    @DisplayName("Prueba 1: GET - Consultar datos de un usuario")
    void testGetUserData() throws Exception {
        // ARRANGE: Preparar los datos necesarios para la prueba
        String endpoint = "/users/1"; // Endpoint a consultar
        
        // ACT: Ejecutar la acción (realizar la petición GET)
        HttpClientUtil.HttpResponse response = HttpClientUtil.get(endpoint);

        // ASSERT: Validar los resultados
        
        // Validación 1: Verificar que el código de respuesta es 200 (OK)
        assertEquals(200, response.statusCode, "El código de respuesta debe ser 200");

        // Validación 2: Verificar que la respuesta contiene datos
        JsonObject user = response.getJsonObject();
        assertNotNull(user, "La respuesta no debe ser nula");

        // Validación 3: Verificar el ID del usuario
        assertEquals(1, user.get("id").getAsInt(), "El ID debe ser 1");
        
        // Validación 4: Verificar el nombre del usuario
        assertEquals("Leanne Graham", user.get("name").getAsString(), 
                     "El nombre debe ser 'Leanne Graham'");
        
        // Validación 5: Verificar el email del usuario
        assertEquals("Sincere@april.biz", user.get("email").getAsString(), 
                     "El email debe ser válido");

        // Validación 6: Verificar que existen campos anidados (address)
        assertTrue(user.has("address"), "Debe existir el campo 'address'");
        
        // Validación 7: Verificar que existen campos anidados (company)
        assertTrue(user.has("company"), "Debe existir el campo 'company'");

        // Validación 8: Verificar datos dentro del objeto anidado address
        JsonObject address = user.getAsJsonObject("address");
        assertEquals("Gwenborough", address.get("city").getAsString(), 
                     "La ciudad debe ser 'Gwenborough'");
    }

    /**
     * PRUEBA 2: POST - CREAR UN NUEVO POST
     * 
     * Objetivo: Verificar que el microservicio procesa correctamente
     * las solicitudes para crear nuevos recursos.
     * 
     * Endpoint: POST /posts
     * 
     * Validaciones:
     * - Código de respuesta HTTP 201 (Created) o 200 (OK)
     * - Asignación de ID único al nuevo recurso
     * - Integridad de datos (los datos enviados se reflejan en la respuesta)
     * - Estructura correcta de la respuesta
     */
    @Test
    @DisplayName("Prueba 2: POST - Crear un nuevo post")
    void testCreatePost() throws Exception {
        // ARRANGE: Preparar los datos para crear un nuevo post
        String endpoint = "/posts"; // Endpoint para crear posts
        
        // Datos JSON a enviar (título, contenido, usuario)
        String jsonBody = "{" +
                "\"title\": \"Test Post\", " +
                "\"body\": \"Este es un post de prueba\", " +
                "\"userId\": 1" +
                "}";

        // ACT: Ejecutar la acción (realizar la petición POST)
        HttpClientUtil.HttpResponse response = HttpClientUtil.post(endpoint, jsonBody);

        // ASSERT: Validar los resultados
        
        // Validación 1: Verificar que el código de respuesta es 201 o 200
        assertTrue(response.statusCode == 200 || response.statusCode == 201,
                "El código de respuesta debe ser 200 o 201, recibido: " + response.statusCode);

        // Validación 2: Verificar que la respuesta contiene datos
        JsonObject post = response.getJsonObject();
        assertNotNull(post, "La respuesta no debe ser nula");

        // Validación 3: Verificar que el servidor asignó un ID al nuevo post
        assertTrue(post.has("id"), "El post debe tener un ID asignado");
        assertNotNull(post.get("id"), "El ID no debe ser nulo");

        // Validación 4: Verificar que el título coincide con lo enviado
        assertEquals("Test Post", post.get("title").getAsString(), 
                     "El título debe coincidir");
        
        // Validación 5: Verificar que el contenido coincide con lo enviado
        assertEquals("Este es un post de prueba", post.get("body").getAsString(), 
                     "El body debe coincidir");
        
        // Validación 6: Verificar que el userId coincide con lo enviado
        assertEquals(1, post.get("userId").getAsInt(), "El userId debe ser 1");
    }

    /**
     * PRUEBA 3: MANEJO DE ERRORES - RECURSO INEXISTENTE
     * 
     * Objetivo: Verificar que el microservicio maneja correctamente
     * las solicitudes para recursos que no existen.
     * 
     * Endpoint: GET /users/99999 (ID que no existe)
     * 
     * Validaciones:
     * - Código de respuesta HTTP 404 (Not Found)
     * - Respuesta vacía o estructura apropiada para error
     */
    @Test
    @DisplayName("Prueba 3: Manejo de errores - Recurso inexistente")
    void testErrorHandlingNotFound() throws Exception {
        // ARRANGE: Preparar los datos para consultar un usuario inexistente
        String endpoint = "/users/99999"; // ID que no existe en la API

        // ACT: Ejecutar la acción (realizar la petición GET)
        HttpClientUtil.HttpResponse response = HttpClientUtil.get(endpoint);

        // ASSERT: Validar los resultados
        
        // Validación 1: Verificar que el código de respuesta es 404 (Not Found)
        assertEquals(404, response.statusCode, 
                     "El código de respuesta debe ser 404 para recurso no encontrado");

        // Validación 2: Verificar que la respuesta está vacía o es un objeto vacío
        String body = response.body.trim();
        assertTrue(body.isEmpty() || body.equals("{}"), 
                   "La respuesta debe estar vacía o ser un objeto vacío");
    }

    /**
     * PRUEBA ADICIONAL: VALIDAR ESTRUCTURA DE MÚLTIPLES POSTS
     * 
     * Objetivo: Verificar que el microservicio devuelve correctamente
     * colecciones de recursos (arrays JSON).
     * 
     * Endpoint: GET /posts?userId=1 (Posts del usuario 1)
     * 
     * Validaciones:
     * - Código de respuesta HTTP 200 (OK)
     * - Respuesta en formato array JSON
     * - Array no vacío (contiene datos)
     */
    @Test
    @DisplayName("Prueba adicional: Validar estructura de múltiples posts")
    void testGetMultiplePosts() throws Exception {
        // ARRANGE: Preparar los datos para consultar múltiples posts
        String endpoint = "/posts?userId=1"; // Posts del usuario 1

        // ACT: Ejecutar la acción (realizar la petición GET)
        HttpClientUtil.HttpResponse response = HttpClientUtil.get(endpoint);

        // ASSERT: Validar los resultados
        
        // Validación 1: Verificar que el código de respuesta es 200 (OK)
        assertEquals(200, response.statusCode, 
                     "El código de respuesta debe ser 200");

        // Validación 2: Verificar que la respuesta es un array JSON
        // Un array JSON comienza con "[" y termina con "]"
        assertTrue(response.body.startsWith("["), 
                   "La respuesta debe ser un array JSON");

        // Validación 3: Verificar que el array no está vacío
        assertFalse(response.body.equals("[]"), 
                    "El array no debe estar vacío");
    }
}
