# Documentación de Pruebas Automatizadas - Microservicios con JUnit

## Información del Estudiante
- **Nombre del Estudiante**: [Tu Nombre]
- **Fecha**: 15 de Marzo de 2026
- **Asignatura**: Pruebas Unitarias con JUnit
- **Tema**: Microservicios y Pruebas Automatizadas

---

## 1. Descripción Breve del Caso Analizado

Se desarrolló un conjunto de pruebas automatizadas para validar el funcionamiento de microservicios REST utilizando la API pública **JSONPlaceholder** (https://jsonplaceholder.typicode.com). Esta API simula un servidor backend con endpoints para gestionar usuarios, posts, comentarios y otros recursos.

El objetivo principal es verificar que los microservicios respondan correctamente ante diferentes tipos de solicitudes HTTP (GET, POST) y que manejen adecuadamente los errores.

---

## 2. Explicación de las Pruebas Diseñadas

### Prueba 1: GET - Consultar Datos de un Usuario

**Endpoint**: `GET /users/1`

**Descripción**: Esta prueba valida que el microservicio devuelve información correcta al consultar un usuario específico.

**Validaciones Implementadas**:
1. **Código de Respuesta HTTP**: Verifica que la respuesta sea 200 (OK)
2. **Existencia de Datos**: Confirma que la respuesta JSON no es nula
3. **Campos Específicos**: Valida que los campos esperados (id, name, email) contienen los valores correctos
4. **Objetos Anidados**: Verifica la existencia de estructuras complejas (address, company)
5. **Datos Anidados**: Valida información dentro de objetos anidados (city dentro de address)

**Código Implementado**:
```java
@Test
@DisplayName("Prueba 1: GET - Consultar datos de un usuario")
void testGetUserData() throws Exception {
    // ARRANGE: Preparar los datos necesarios para la prueba
    String endpoint = "/users/1"; // Endpoint a consultar
    
    // ACT: Ejecutar la acción (realizar la petición GET)
    HttpClientUtil.HttpResponse response = HttpClientUtil.get(endpoint);

    // ASSERT: Validar los resultados
    assertEquals(200, response.statusCode, "El código de respuesta debe ser 200");
    JsonObject user = response.getJsonObject();
    assertNotNull(user, "La respuesta no debe ser nula");
    assertEquals(1, user.get("id").getAsInt(), "El ID debe ser 1");
    assertEquals("Leanne Graham", user.get("name").getAsString(), "El nombre debe ser 'Leanne Graham'");
    assertEquals("Sincere@april.biz", user.get("email").getAsString(), "El email debe ser válido");
    assertTrue(user.has("address"), "Debe existir el campo 'address'");
    assertTrue(user.has("company"), "Debe existir el campo 'company'");
    JsonObject address = user.getAsJsonObject("address");
    assertEquals("Gwenborough", address.get("city").getAsString(), "La ciudad debe ser 'Gwenborough'");
}
```

---

### Prueba 2: POST - Crear un Nuevo Post

**Endpoint**: `POST /posts`

**Descripción**: Esta prueba valida que el microservicio procesa correctamente las solicitudes para crear nuevos recursos.

**Validaciones Implementadas**:
1. **Código de Respuesta**: Verifica que sea 200 o 201 (Created)
2. **Asignación de ID**: Confirma que el servidor asigna un identificador único al nuevo recurso
3. **Integridad de Datos**: Valida que los datos enviados se reflejan correctamente en la respuesta
4. **Estructura de Respuesta**: Verifica que la respuesta contiene todos los campos esperados

**Código Implementado**:
```java
@Test
@DisplayName("Prueba 2: POST - Crear un nuevo post")
void testCreatePost() throws Exception {
    // ARRANGE: Preparar los datos para crear un nuevo post
    String endpoint = "/posts"; // Endpoint para crear posts
    String jsonBody = "{" +
            "\"title\": \"Test Post\", " +
            "\"body\": \"Este es un post de prueba\", " +
            "\"userId\": 1" +
            "}";

    // ACT: Ejecutar la acción (realizar la petición POST)
    HttpClientUtil.HttpResponse response = HttpClientUtil.post(endpoint, jsonBody);

    // ASSERT: Validar los resultados
    assertTrue(response.statusCode == 200 || response.statusCode == 201);
    JsonObject post = response.getJsonObject();
    assertNotNull(post, "La respuesta no debe ser nula");
    assertTrue(post.has("id"), "El post debe tener un ID asignado");
    assertEquals("Test Post", post.get("title").getAsString());
    assertEquals("Este es un post de prueba", post.get("body").getAsString());
    assertEquals(1, post.get("userId").getAsInt());
}
```

---

### Prueba 3: Manejo de Errores - Recurso Inexistente

**Endpoint**: `GET /users/99999`

**Descripción**: Esta prueba valida que el microservicio maneja correctamente las solicitudes para recursos que no existen.

**Validaciones Implementadas**:
1. **Código de Error Apropiado**: Verifica que la respuesta sea 404 (Not Found)
2. **Respuesta Vacía**: Confirma que el servidor devuelve una respuesta vacía o un objeto vacío
3. **Comportamiento Consistente**: Valida que el error se maneja de forma consistente

**Código Implementado**:
```java
@Test
@DisplayName("Prueba 3: Manejo de errores - Recurso inexistente")
void testErrorHandlingNotFound() throws Exception {
    // ARRANGE: Preparar los datos para consultar un usuario inexistente
    String endpoint = "/users/99999"; // ID que no existe en la API

    // ACT: Ejecutar la acción (realizar la petición GET)
    HttpClientUtil.HttpResponse response = HttpClientUtil.get(endpoint);

    // ASSERT: Validar los resultados
    assertEquals(404, response.statusCode, "El código de respuesta debe ser 404");
    String body = response.body.trim();
    assertTrue(body.isEmpty() || body.equals("{}"));
}
```

---

### Prueba Adicional: Validar Estructura de Múltiples Posts

**Endpoint**: `GET /posts?userId=1`

**Descripción**: Valida que el microservicio devuelve correctamente colecciones de recursos.

**Validaciones**:
- Código de respuesta 200
- Respuesta en formato array JSON
- Array no vacío

---

## 3. Resultados de la Ejecución

### Ejecución Exitosa

```
[INFO] -------------------------------------------------------
[INFO]  T E S T S
[INFO] -------------------------------------------------------
[INFO] Running com.example.MicroserviciosTest
[INFO] Tests run: 4, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 2.836 s
[INFO] 
[INFO] Results:
[INFO] Tests run: 4, Failures: 0, Errors: 0, Skipped: 0
[INFO]
[INFO] BUILD SUCCESS
```

**Resumen**:
- ✓ 4 pruebas ejecutadas
- ✓ 0 fallos
- ✓ 0 errores
- ✓ Tiempo de ejecución: 2.836 segundos

---

## 4. Conclusión Personal sobre la Importancia de Probar Microservicios

Las pruebas automatizadas son fundamentales en el desarrollo de microservicios por varias razones:

1. **Confiabilidad**: Garantizan que cada servicio funciona correctamente de forma independiente
2. **Mantenibilidad**: Facilitan la detección de regresiones cuando se realizan cambios
3. **Documentación**: Sirven como especificación ejecutable del comportamiento esperado
4. **Escalabilidad**: Permiten gestionar la complejidad de sistemas distribuidos
5. **Automatización**: Reducen el tiempo de pruebas manuales y aumentan la velocidad de desarrollo

En este proyecto, implementamos pruebas que cubren los escenarios más comunes:
- Consultas exitosas (GET)
- Creación de recursos (POST)
- Manejo de errores (404)

Estas pruebas proporcionan una base sólida para validar la calidad de los microservicios.

---

## 5. Reflexión Final

### ¿Por qué es importante realizar pruebas automatizadas en sistemas basados en microservicios?

Las pruebas automatizadas son críticas en arquitecturas de microservicios porque:

1. **Independencia de Servicios**: Cada microservicio puede ser probado de forma aislada, garantizando que funciona correctamente antes de integrarlo con otros servicios.

2. **Detección Temprana de Errores**: Las pruebas automatizadas identifican problemas en etapas tempranas del desarrollo, reduciendo significativamente los costos de corrección.

3. **Confiabilidad en Despliegues**: Con pruebas automatizadas, se puede desplegar código con mayor confianza, sabiendo que los casos críticos están cubiertos.

4. **Documentación Viva**: Las pruebas sirven como documentación del comportamiento esperado de cada endpoint, facilitando el entendimiento del sistema.

5. **Prevención de Regresiones**: Al ejecutar pruebas regularmente, se evita que cambios futuros rompan funcionalidades existentes.

6. **Escalabilidad**: En arquitecturas de microservicios con múltiples servicios, las pruebas automatizadas son esenciales para mantener la calidad a medida que el sistema crece.

7. **Integración Continua**: Las pruebas automatizadas permiten implementar pipelines de CI/CD efectivos, automatizando el proceso de validación y despliegue.

8. **Comunicación entre Equipos**: Las pruebas claras facilitan la comunicación entre equipos de desarrollo, QA y operaciones.

En conclusión, las pruebas automatizadas no son un lujo sino una necesidad en el desarrollo moderno de microservicios. Proporcionan la confianza necesaria para iterar rápidamente, mantener la calidad y escalar sistemas complejos.

---

**Fecha de Entrega**: 15 de Marzo de 2026
