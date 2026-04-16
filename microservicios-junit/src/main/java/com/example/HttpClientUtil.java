package com.example;

// Importaciones para realizar peticiones HTTP
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.io.entity.StringEntity;

// Importaciones para parsear JSON
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * Clase utilitaria para realizar peticiones HTTP a microservicios REST
 * Proporciona métodos para GET y POST a la API JSONPlaceholder
 */
public class HttpClientUtil {
    // URL base de la API pública JSONPlaceholder
    private static final String BASE_URL = "https://jsonplaceholder.typicode.com";

    /**
     * Realiza una petición GET a un endpoint específico
     * 
     * @param endpoint - El endpoint a consultar (ej: "/users/1")
     * @return HttpResponse - Objeto con código de estado y cuerpo de respuesta
     * @throws Exception - Si ocurre un error en la petición
     */
    public static HttpResponse get(String endpoint) throws Exception {
        // Crear cliente HTTP (se cierra automáticamente con try-with-resources)
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            // Crear petición GET con la URL completa
            HttpGet request = new HttpGet(BASE_URL + endpoint);
            
            // Ejecutar la petición y procesar la respuesta
            return httpClient.execute(request, response -> {
                // Obtener el código de estado HTTP (200, 404, etc.)
                int statusCode = response.getCode();
                
                // Obtener el cuerpo de la respuesta como String
                String body = new String(response.getEntity().getContent().readAllBytes());
                
                // Retornar objeto HttpResponse con los datos
                return new HttpResponse(statusCode, body);
            });
        }
    }

    /**
     * Realiza una petición POST a un endpoint específico con datos JSON
     * 
     * @param endpoint - El endpoint donde enviar los datos (ej: "/posts")
     * @param jsonBody - El cuerpo JSON a enviar (ej: {"title": "Test", "body": "..."})
     * @return HttpResponse - Objeto con código de estado y cuerpo de respuesta
     * @throws Exception - Si ocurre un error en la petición
     */
    public static HttpResponse post(String endpoint, String jsonBody) throws Exception {
        // Crear cliente HTTP (se cierra automáticamente con try-with-resources)
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            // Crear petición POST con la URL completa
            HttpPost request = new HttpPost(BASE_URL + endpoint);
            
            // Establecer el header Content-Type como application/json
            request.setHeader("Content-Type", "application/json");
            
            // Establecer el cuerpo de la petición con los datos JSON
            request.setEntity(new StringEntity(jsonBody));
            
            // Ejecutar la petición y procesar la respuesta
            return httpClient.execute(request, response -> {
                // Obtener el código de estado HTTP (201, 200, etc.)
                int statusCode = response.getCode();
                
                // Obtener el cuerpo de la respuesta como String
                String body = new String(response.getEntity().getContent().readAllBytes());
                
                // Retornar objeto HttpResponse con los datos
                return new HttpResponse(statusCode, body);
            });
        }
    }

    /**
     * Clase interna para encapsular la respuesta HTTP
     * Contiene el código de estado y el cuerpo de la respuesta
     */
    public static class HttpResponse {
        // Código de estado HTTP (200, 201, 404, etc.)
        public int statusCode;
        
        // Cuerpo de la respuesta como String (JSON)
        public String body;

        /**
         * Constructor de HttpResponse
         * 
         * @param statusCode - Código de estado HTTP
         * @param body - Cuerpo de la respuesta
         */
        public HttpResponse(int statusCode, String body) {
            this.statusCode = statusCode;
            this.body = body;
        }

        /**
         * Convierte el cuerpo de la respuesta a un objeto JsonObject
         * Útil para acceder a campos específicos del JSON
         * 
         * @return JsonObject - Objeto JSON parseado
         */
        public JsonObject getJsonObject() {
            return JsonParser.parseString(body).getAsJsonObject();
        }
    }
}
