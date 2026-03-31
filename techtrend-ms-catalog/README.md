# TechTrend - Microservicio de Catálogo

##  Descripción
Este proyecto corresponde al microservicio de Catálogo de la plataforma TechTrend.  
Su función principal es gestionar la información de los productos y validar la disponibilidad de stock.

---

##  Tecnologías utilizadas
- Java  
- Maven  
- JUnit 5  
- Mockito  

---

##  Estructura del proyecto

```
src/
├── main/java/com/techtrend/catalog
│   ├── model
│   ├── service
│   └── controller
└── test/java/com/techtrend/catalog/service
```

---

## Pruebas unitarias

Se implementaron pruebas unitarias para validar el comportamiento del sistema en distintos escenarios:

- Validación de stock suficiente: la verificación retorna un resultado positivo cuando existe disponibilidad.
- Validación de stock insuficiente: la operación falla cuando la cantidad solicitada supera el inventario.
- Manejo de cantidad negativa: se genera una excepción al ingresar valores inválidos.
- Validación de producto inexistente: no se permite la consulta de productos que no existen.

---

##  Ejecución de pruebas

Ejecutar en consola:

```
mvn test
```

También puedes usar Maven Wrapper (recomendado para el equipo):

```bash
# Windows (PowerShell)
.\mvnw.cmd test

# Linux/macOS/Git Bash
./mvnw test
```

---

##  Integrantes

- Yennifer – Validación de stock suficiente  
- (Nombre) – Validación de stock insuficiente  
- (Nombre) – Manejo de cantidad negativa  
- Gracia Garcia – Producto inexistente  

---

##  Buenas prácticas aplicadas

- Separación de capas (model, service, controller)  
- Uso de pruebas unitarias con JUnit  
- Validación de datos de entrada  
- Código limpio y organizado  
- Pruebas enfocadas en la lógica de negocio (service)  


