# 📄 Documento de Entrega - Reto CI/CD
## S11 | AP5 | Integración con Jenkins, SonarQube, Slack y JMeter

---

## 👥 Información del Estudiante

**Nombre:** [Tu nombre completo]  
**Código:** [Tu código de estudiante]  
**Fecha:** [Fecha de entrega]  
**Curso:** Pruebas de Software

---

## 1. Descripción del Proceso Realizado

### 1.1 Configuración Inicial
[Describe brevemente cómo configuraste cada herramienta]

**Jenkins:**
- Instalación de plugins necesarios (Pipeline, Git, SonarQube Scanner, Slack)
- Configuración de credenciales (sonar-token, slack-webhook)
- Creación del pipeline desde SCM

**SonarQube:**
- Inicio del servidor en puerto 9000
- Creación del proyecto con key: proyecto-base-ci
- Generación de token de autenticación

**Slack:**
- Creación de workspace/canal para notificaciones
- Configuración de Incoming Webhook
- Integración con Jenkins

**JMeter:**
- Instalación y configuración del PATH
- Creación del plan de pruebas con 50 usuarios concurrentes
- Configuración de endpoints GET /products y POST /login

### 1.2 Ejecución del Pipeline
[Describe el proceso de ejecución]

1. **Stage: Checkout** - Obtención del código desde el repositorio
2. **Stage: Build** - Compilación con `mvn clean install`
3. **Stage: Test** - Ejecución de pruebas unitarias
4. **Stage: SonarQube Analysis** - Análisis de calidad del código
5. **Stage: Start Application** - Inicio de la aplicación en puerto 8081
6. **Stage: JMeter Load Test** - Pruebas de carga con 50 usuarios

---

## 2. Explicación de la Integración de Herramientas

### 2.1 Jenkins ↔ SonarQube
**Conexión:**
- Jenkins ejecuta `mvn sonar:sonar` con el token configurado
- SonarQube recibe el código y realiza el análisis estático
- Los resultados se publican en http://localhost:9000

**Flujo:**
```
Jenkins (Build) → Maven Plugin → SonarQube Scanner → SonarQube Server → Reporte
```

### 2.2 Jenkins ↔ Slack
**Conexión:**
- Jenkins usa el webhook de Slack configurado en credenciales
- En el bloque `post` del pipeline se envían notificaciones
- Slack recibe mensajes JSON con información del build

**Flujo:**
```
Jenkins (Pipeline End) → Webhook URL → Slack API → Canal de Notificaciones
```

### 2.3 Jenkins ↔ JMeter
**Conexión:**
- Jenkins inicia la aplicación Spring Boot
- Ejecuta JMeter en modo no-GUI con el archivo .jmx
- JMeter genera reportes en formato .jtl y HTML
- Jenkins archiva los resultados como artefactos

**Flujo:**
```
Jenkins → Start App → JMeter Test → Generate Reports → Archive Artifacts
```

### 2.4 Diagrama de Integración
```
┌─────────────┐
│   Jenkins   │
│  (Pipeline) │
└──────┬──────┘
       │
       ├──────────────┐
       │              │
       ▼              ▼
┌─────────────┐  ┌──────────┐
│  SonarQube  │  │  JMeter  │
│  (Análisis) │  │ (Pruebas)│
└─────────────┘  └──────────┘
       │              │
       └──────┬───────┘
              ▼
       ┌─────────────┐
       │    Slack    │
       │(Notificación)│
       └─────────────┘
```

---

## 3. Resultados Obtenidos

### 3.1 Ejecución del Pipeline en Jenkins
**Estado:** [✅ Exitoso / ❌ Fallido]

**Capturas:**
- [Insertar captura del pipeline completo]
- [Insertar captura de Console Output]

**Observaciones:**
- Tiempo total de ejecución: [X minutos]
- Stages completados: [X/X]
- Errores encontrados: [Ninguno / Descripción]

---

### 3.2 Análisis de SonarQube
**Estado del Proyecto:** [Passed / Failed]

**Capturas:**
- [Insertar captura del dashboard de SonarQube]
- [Insertar captura de métricas detalladas]

**Métricas Obtenidas:**
| Métrica | Valor | Estado |
|---------|-------|--------|
| Bugs | [X] | [🟢/🔴] |
| Vulnerabilities | [X] | [🟢/🔴] |
| Code Smells | [X] | [🟢/🔴] |
| Coverage | [X%] | [🟢/🔴] |
| Duplications | [X%] | [🟢/🔴] |
| Security Hotspots | [X] | [🟢/🔴] |

#### 3.2.1 Problemas Detectados y Mejoras Propuestas

**Problema 1:**
- **Tipo:** [Bug / Code Smell / Vulnerability]
- **Descripción:** [Descripción del problema]
- **Ubicación:** [Archivo:Línea]
- **Severidad:** [Critical / Major / Minor]
- **Mejora Propuesta:** [Cómo solucionarlo]

**Problema 2:**
- **Tipo:** [Bug / Code Smell / Vulnerability]
- **Descripción:** [Descripción del problema]
- **Ubicación:** [Archivo:Línea]
- **Severidad:** [Critical / Major / Minor]
- **Mejora Propuesta:** [Cómo solucionarlo]

**Problema 3:**
- **Tipo:** [Bug / Code Smell / Vulnerability]
- **Descripción:** [Descripción del problema]
- **Ubicación:** [Archivo:Línea]
- **Severidad:** [Critical / Major / Minor]
- **Mejora Propuesta:** [Cómo solucionarlo]

---

### 3.3 Notificaciones en Slack
**Estado:** [✅ Recibidas / ❌ No recibidas]

**Capturas:**
- [Insertar captura de notificación exitosa]
- [Insertar captura de notificación de error (si aplica)]

**Contenido del Mensaje:**
- Nombre del proyecto
- Número de build
- Estado (SUCCESS/FAILURE)
- Timestamp

---

### 3.4 Pruebas de Carga con JMeter
**Configuración:**
- Usuarios concurrentes: 50
- Ramp-up period: 10 segundos
- Iteraciones por usuario: 5
- Total de requests: 500

**Capturas:**
- [Insertar captura del Summary Report]
- [Insertar captura del reporte HTML]

**Resultados:**

#### Endpoint: GET /products
| Métrica | Valor |
|---------|-------|
| Samples | [X] |
| Average (ms) | [X] |
| Min (ms) | [X] |
| Max (ms) | [X] |
| Std. Dev. | [X] |
| Error % | [X%] |
| Throughput (req/s) | [X] |

#### Endpoint: POST /login
| Métrica | Valor |
|---------|-------|
| Samples | [X] |
| Average (ms) | [X] |
| Min (ms) | [X] |
| Max (ms) | [X] |
| Std. Dev. | [X] |
| Error % | [X%] |
| Throughput (req/s) | [X] |

**Análisis de Rendimiento:**
- [Describe si el rendimiento fue aceptable]
- [Identifica cuellos de botella si los hay]
- [Sugiere mejoras si es necesario]

---

## 4. Conclusiones

### 4.1 Logros
- ✅ [Lista los objetivos cumplidos]
- ✅ [Integración exitosa de herramientas]
- ✅ [Automatización del pipeline]

### 4.2 Dificultades Encontradas
- [Describe problemas durante la configuración]
- [Explica cómo los resolviste]

### 4.3 Aprendizajes
- [Qué aprendiste sobre CI/CD]
- [Importancia de la automatización]
- [Valor del análisis de código]

### 4.4 Mejoras Futuras
- [Qué agregarías al pipeline]
- [Cómo optimizarías el proceso]

---

## 5. Referencias

- Documentación de Jenkins: https://www.jenkins.io/doc/
- Documentación de SonarQube: https://docs.sonarqube.org/
- Documentación de JMeter: https://jmeter.apache.org/usermanual/
- Slack API: https://api.slack.com/

---

## 📎 Anexos

### Archivos Adjuntos
- [ ] Capturas de pantalla (Jenkins, SonarQube, Slack, JMeter)
- [ ] Jenkinsfile
- [ ] sonar-project.properties
- [ ] LoadTest.jmx
- [ ] Reportes de JMeter (HTML)

---

**Firma:** ___________________  
**Fecha:** ___________________
