# 🧪 PRUEBAS DE SOFTWARE 2026 - AS232

Repositorio de proyectos y prácticas del curso de Pruebas de Software 2026.

---

## 📂 Estructura de Proyectos

### 1. **grabaciones_validacionyerror**
📦 **TechTrend - Microservicio de Catálogo**

Microservicio Spring Boot para gestión de catálogo de productos con validación de stock.

- **Tecnologías**: Java 17, Spring Boot 3.2.5, JUnit 5, Mockito, PostgreSQL
- **Características**:
  - Validación de stock suficiente/insuficiente
  - Manejo de cantidades negativas
  - Validación de productos inexistentes
  - Pruebas unitarias con JUnit y Mockito
  - Cobertura de código con JaCoCo
  - Documentación con Swagger/OpenAPI
- **Ejecutar pruebas**: `mvn test` o `./mvnw test`
- **Ubicación**: `grabaciones_validacionyerror/techtrend-ms-catalog/`

---

### 2. **PATRON_TRIPLE_AAA_ACTIVIDAD_CLASE**
🔐 **Sistema de Login con Patrón AAA**

Implementación de pruebas unitarias en Python usando el patrón AAA (Arrange-Act-Assert).

- **Tecnologías**: Python, pytest
- **Características**:
  - Función de login con validaciones múltiples
  - Pruebas con patrón AAA (Arrange, Act, Assert)
  - Casos de prueba:
    - Usuario bloqueado
    - Login exitoso
    - Password incorrecto
    - Usuario no existe
- **Archivos principales**:
  - `app_test.py`: Implementación y pruebas
  - `login.py`: Módulo de login
  - `CASO1.PY`, `CASO2.PY`: Casos de prueba adicionales

---

## 🚀 Cómo usar este repositorio

1. **Clonar el repositorio**:
   ```bash
   git clone https://github.com/GraciaGarcia/PRUEBAS_DE_SOFTWARE_2026_AS232.git
   cd PRUEBAS_DE_SOFTWARE_2026_AS232
   ```

2. **Cambiar a la rama develop**:
   ```bash
   git checkout develop
   ```

3. **Navegar al proyecto deseado**:
   ```bash
   cd [nombre_del_proyecto]
   ```

---

## 📚 Conceptos aplicados

- ✅ Pruebas unitarias (JUnit, pytest)
- ✅ Patrón AAA (Arrange-Act-Assert)
- ✅ Mocking con Mockito
- ✅ Cobertura de código (JaCoCo)
- ✅ Validación de datos
- ✅ Manejo de excepciones

---

## 👥 Autor

**Gracia Garcia**  
Curso: Pruebas de Software 2026 - AS232

---

## 📄 Licencia

Proyectos académicos - Valle Grande
