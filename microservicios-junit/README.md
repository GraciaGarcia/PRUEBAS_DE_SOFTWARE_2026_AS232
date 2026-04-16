# Pruebas Automatizadas de Microservicios con JUnit

## Descripción del Caso de Estudio

Este proyecto implementa pruebas automatizadas para validar el funcionamiento de microservicios REST utilizando la API pública **JSONPlaceholder** (https://jsonplaceholder.typicode.com). El objetivo es verificar que los endpoints respondan correctamente ante diferentes tipos de solicitudes.

## Estructura del Proyecto

```
microservicios-junit/
├── pom.xml                          # Configuración Maven
├── src/
│   ├── main/java/com/example/
│   │   └── HttpClientUtil.java      # Utilidad para hacer peticiones HTTP
│   └── test/java/com/example/
│       └── MicroserviciosTest.java  # Pruebas unitarias
└── README.md
```

## Dependencias

- **JUnit 5**: Framework de pruebas unitarias
- **Apache HttpClient 5**: Para realizar peticiones HTTP
- **Gson**: Para parsear y manipular JSON
- **AssertJ**: Para assertions mejoradas

## Pruebas Implementadas

### 1. Prueba GET - Consultar Datos de un Usuario
**Endpoint**: `GET /users/1`

**Validaciones**:
- ✓ Código de respuesta HTTP 200
- ✓ Existencia de datos en la respuesta JSON
- ✓ Validación de campos específicos (id, name, email)
- ✓ Validación de objetos anidados (address, company)

**Propósito**: Verificar que el microservicio devuelve información válida al consultar un recurso existente.

### 2. Prueba POST - Crear un Nuevo Post
**Endpoint**: `POST /posts`

**Validaciones**:
- ✓ Código de respuesta HTTP 200 o 201
- ✓ Asignación de ID al nuevo recurso
- ✓ Coincidencia de datos enviados con los recibidos
- ✓ Estructura correcta de la respuesta

**Propósito**: Simular el envío de datos al microservicio para crear un nuevo recurso y validar su procesamiento.

### 3. Prueba de Manejo de Errores - Recurso Inexistente
**Endpoint**: `GET /users/99999`

**Validaciones**:
- ✓ Código de respuesta HTTP 404
- ✓ Respuesta vacía o estructura apropiada para error

**Propósito**: Verificar que el sistema responde correctamente ante solicitudes inválidas o recursos inexistentes.

### 4. Prueba Adicional - Validar Múltiples Posts
**Endpoint**: `GET /posts?userId=1`

**Validaciones**:
- ✓ Código de respuesta HTTP 200
- ✓ Respuesta en formato array JSON
- ✓ Datos no vacíos

## Cómo Ejecutar las Pruebas

### Requisitos Previos
- Java 11 o superior
- Maven 3.6 o superior

### Ejecutar todas las pruebas
```bash
mvn test
```

### Ejecutar una prueba específica
```bash
mvn test -Dtest=MicroserviciosTest#testGetUserData
```

### Ejecutar con salida detallada
```bash
mvn test -X
```

## Resultados Esperados

Todas las pruebas deben pasar exitosamente:
- ✓ testGetUserData
- ✓ testCreatePost
- ✓ testErrorHandlingNotFound
- ✓ testGetMultiplePosts

## Importancia de las Pruebas Automatizadas en Microservicios

### ¿Por qué es importante realizar pruebas automatizadas en sistemas basados en microservicios?

1. **Independencia de Servicios**: Cada microservicio puede ser probado de forma aislada, garantizando que funciona correctamente antes de integrarlo con otros.

2. **Detección Temprana de Errores**: Las pruebas automatizadas identifican problemas en etapas tempranas del desarrollo, reduciendo costos de corrección.

3. **Confiabilidad en Despliegues**: Con pruebas automatizadas, se puede desplegar código con mayor confianza, sabiendo que los casos críticos están cubiertos.

4. **Documentación Viva**: Las pruebas sirven como documentación del comportamiento esperado de cada endpoint.

5. **Regresión Prevención**: Al ejecutar pruebas regularmente, se evita que cambios futuros rompan funcionalidades existentes.

6. **Escalabilidad**: En arquitecturas de microservicios con múltiples servicios, las pruebas automatizadas son esenciales para mantener la calidad.

7. **Integración Continua**: Las pruebas automatizadas permiten implementar pipelines de CI/CD efectivos.

## Conclusión

Las pruebas automatizadas son fundamentales en el desarrollo de microservicios. Permiten validar que cada servicio cumple con sus responsabilidades, facilitando el mantenimiento, la escalabilidad y la confiabilidad del sistema completo. En este proyecto, hemos demostrado cómo implementar pruebas para casos comunes: consultas, creación de recursos y manejo de errores.
