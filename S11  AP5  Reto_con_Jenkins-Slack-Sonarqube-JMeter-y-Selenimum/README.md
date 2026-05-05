# 🚀 Proyecto Base - CI/CD con Jenkins, SonarQube, Slack y JMeter

## 📌 Descripción
Proyecto base para el reto de integración continua que incluye:
- ✅ API REST con Spring Boot
- ✅ Pipeline de Jenkins automatizado
- ✅ Análisis de código con SonarQube
- ✅ Notificaciones en Slack
- ✅ Pruebas de carga con JMeter

---

## 🏗️ Estructura del Proyecto

```
proyecto-base-ci/
├── src/
│   ├── main/
│   │   ├── java/com/vallegrande/
│   │   │   ├── Application.java
│   │   │   ├── controller/
│   │   │   │   └── ProductController.java
│   │   │   └── model/
│   │   │       ├── Product.java
│   │   │       └── LoginRequest.java
│   │   └── resources/
│   │       └── application.properties
│   └── test/
│       └── java/
├── jmeter/
│   ├── LoadTest.jmx
│   └── results/
├── Jenkinsfile
├── sonar-project.properties
├── pom.xml
├── GUIA_CONFIGURACION.md
├── DOCUMENTO_ENTREGA.md
└── README.md
```

---

## 🔧 Tecnologías Utilizadas

- **Java 17**
- **Spring Boot 3.2.0**
- **Maven 3.8+**
- **Jenkins** (Pipeline)
- **SonarQube 9.x**
- **Apache JMeter 5.x**
- **Slack** (Webhooks)

---

## 🚀 Inicio Rápido

### 1. Clonar el Repositorio
```bash
git clone [tu-repositorio]
cd proyecto-base-ci
```

### 2. Compilar el Proyecto
```bash
mvn clean install
```

### 3. Ejecutar la Aplicación
```bash
mvn spring-boot:run
```

La aplicación estará disponible en: http://localhost:8081

---

## 📡 Endpoints Disponibles

### GET /products
Obtiene la lista de productos disponibles.

**Request:**
```bash
curl http://localhost:8081/products
```

**Response:**
```json
[
  {
    "id": 1,
    "name": "Laptop",
    "description": "Laptop HP 15",
    "price": 1200.00,
    "stock": 10
  },
  ...
]
```

### POST /login
Autentica un usuario.

**Request:**
```bash
curl -X POST http://localhost:8081/login \
  -H "Content-Type: application/json" \
  -d '{
    "username": "admin",
    "password": "admin123"
  }'
```

**Response (Exitoso):**
```json
{
  "status": "success",
  "message": "Login exitoso",
  "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9"
}
```

**Response (Error):**
```json
{
  "status": "error",
  "message": "Credenciales inválidas"
}
```

---

## 🔄 Pipeline de Jenkins

El pipeline incluye las siguientes etapas:

1. **Checkout** - Obtiene el código del repositorio
2. **Build** - Compila el proyecto con Maven
3. **Test** - Ejecuta pruebas unitarias
4. **SonarQube Analysis** - Analiza la calidad del código
5. **Start Application** - Inicia la aplicación Spring Boot
6. **JMeter Load Test** - Ejecuta pruebas de carga

### Notificaciones
- ✅ **Success**: Notificación verde en Slack
- ❌ **Failure**: Notificación roja en Slack

---

## 📊 Análisis con SonarQube

### Ejecutar Análisis Local
```bash
mvn sonar:sonar \
  -Dsonar.projectKey=proyecto-base-ci \
  -Dsonar.host.url=http://localhost:9000 \
  -Dsonar.login=[tu-token]
```

### Métricas Analizadas
- Bugs
- Vulnerabilities
- Code Smells
- Coverage
- Duplications
- Security Hotspots

---

## ⚡ Pruebas de Carga con JMeter

### Ejecutar Pruebas Manualmente
```bash
jmeter -n -t jmeter/LoadTest.jmx \
  -l jmeter/results/results.jtl \
  -e -o jmeter/results/html
```

### Configuración de Pruebas
- **Usuarios concurrentes**: 50
- **Ramp-up period**: 10 segundos
- **Iteraciones**: 5 por usuario
- **Total requests**: 500

### Ver Resultados
Abrir en navegador: `jmeter/results/html/index.html`

---

## 📝 Documentación Adicional

- [GUIA_CONFIGURACION.md](GUIA_CONFIGURACION.md) - Guía completa de configuración
- [DOCUMENTO_ENTREGA.md](DOCUMENTO_ENTREGA.md) - Plantilla para el documento de entrega

---

## 🔐 Credenciales de Prueba

### Login
- **Usuario**: admin
- **Contraseña**: admin123

---

## 🐛 Solución de Problemas

### Puerto 8081 en uso
```bash
# Windows
netstat -ano | findstr :8081
taskkill /PID [PID] /F

# Linux/Mac
lsof -i :8081
kill -9 [PID]
```

### Maven no encontrado
```bash
mvn -v
# Si no está instalado, descargar desde: https://maven.apache.org/
```

### SonarQube no conecta
- Verificar que SonarQube esté ejecutándose en http://localhost:9000
- Verificar el token de autenticación
- Revisar firewall/antivirus

---

## 📦 Dependencias Principales

```xml
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-test</artifactId>
    </dependency>
</dependencies>
```

---

## 🤝 Contribuciones

Este es un proyecto educativo para el curso de Pruebas de Software.

---

## 📄 Licencia

Proyecto educativo - Valle Grande

---

## 👨‍💻 Autor

[Tu nombre]  
Curso: Pruebas de Software  
Institución: Valle Grande

---

## 📞 Soporte

Para dudas o problemas:
1. Revisar [GUIA_CONFIGURACION.md](GUIA_CONFIGURACION.md)
2. Consultar logs en Jenkins Console Output
3. Verificar documentación oficial de cada herramienta

---

**¡Buena suerte con el reto! 🚀**
