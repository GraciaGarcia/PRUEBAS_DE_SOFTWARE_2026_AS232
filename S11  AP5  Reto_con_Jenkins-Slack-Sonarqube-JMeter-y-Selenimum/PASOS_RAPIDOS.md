# ⚡ Pasos Rápidos para Completar el Reto

## 🎯 Objetivo
Ejecutar el pipeline completo y obtener todos los entregables en el menor tiempo posible.

---

## 📝 Preparación (15 minutos)

### 1. Instalar Herramientas
```bash
# Verificar instalaciones
java -version        # Debe ser Java 17+
mvn -v              # Maven 3.8+
jmeter -v           # JMeter 5.x
```

### 2. Iniciar SonarQube
```bash
# Windows
cd C:\sonarqube\bin\windows-x86-64
StartSonar.bat

# Esperar 2-3 minutos y acceder a http://localhost:9000
# Usuario: admin / Contraseña: admin
```

### 3. Configurar SonarQube
1. Acceder a http://localhost:9000
2. **My Account** → **Security** → **Generate Token**
3. Nombre: `jenkins-token`
4. Copiar el token generado

### 4. Configurar Slack
1. Ir a https://api.slack.com/apps
2. **Create New App** → **From scratch**
3. Nombre: `Jenkins CI`
4. **Incoming Webhooks** → **Activate**
5. **Add New Webhook to Workspace**
6. Copiar Webhook URL

---

## 🚀 Ejecución Local (10 minutos)

### 1. Compilar Proyecto
```bash
cd "S09  M09  Actividad Práctica Integración de Jenkins con Slack"
mvn clean install
```

### 2. Ejecutar Aplicación
```bash
mvn spring-boot:run
```

### 3. Probar Endpoints (en otra terminal)
```bash
# Windows
scripts\test-endpoints.bat

# Linux/Mac
bash scripts/test-endpoints.sh
```

### 4. Ejecutar Análisis SonarQube
```bash
mvn sonar:sonar \
  -Dsonar.projectKey=proyecto-base-ci \
  -Dsonar.host.url=http://localhost:9000 \
  -Dsonar.login=[TU-TOKEN-AQUI]
```

### 5. Ejecutar JMeter
```bash
jmeter -n -t jmeter/LoadTest.jmx -l jmeter/results/results.jtl -e -o jmeter/results/html
```

---

## 🔧 Configuración de Jenkins (20 minutos)

### 1. Instalar Jenkins
- Descargar desde: https://www.jenkins.io/download/
- Ejecutar instalador
- Acceder a http://localhost:8080

### 2. Instalar Plugins
**Manage Jenkins** → **Manage Plugins** → **Available**
- Pipeline
- Git
- SonarQube Scanner
- Slack Notification
- JUnit

### 3. Configurar Credenciales
**Manage Jenkins** → **Manage Credentials** → **Global** → **Add Credentials**

**Credencial 1: SonarQube Token**
- Kind: Secret text
- Secret: [tu token de SonarQube]
- ID: `sonar-token`

**Credencial 2: Slack Webhook**
- Kind: Secret text
- Secret: [tu webhook URL de Slack]
- ID: `slack-webhook`

### 4. Configurar SonarQube Scanner
**Manage Jenkins** → **Global Tool Configuration**
- **SonarQube Scanner**
  - Name: `SonarScanner`
  - Install automatically: ✅

### 5. Configurar Servidor SonarQube
**Manage Jenkins** → **Configure System** → **SonarQube servers**
- Name: `SonarQube`
- Server URL: `http://localhost:9000`
- Server authentication token: Seleccionar `sonar-token`

### 6. Crear Pipeline
1. **New Item**
2. Nombre: `Proyecto-Base-CI`
3. Tipo: **Pipeline**
4. En **Pipeline**:
   - Definition: **Pipeline script from SCM**
   - SCM: **Git**
   - Repository URL: [tu repositorio o ruta local]
   - Script Path: `Jenkinsfile`
5. **Save**

---

## 📸 Captura de Evidencias (15 minutos)

### 1. Ejecutar Pipeline
- Click en **Build Now**
- Esperar a que complete

### 2. Capturas de Jenkins
- [ ] Pipeline completo (vista de stages)
- [ ] Console Output
- [ ] Build History

### 3. Capturas de SonarQube
- [ ] Dashboard del proyecto
- [ ] Métricas (Bugs, Vulnerabilities, Code Smells)
- [ ] Detalle de 3 problemas encontrados

### 4. Capturas de Slack
- [ ] Notificación de éxito
- [ ] (Opcional) Notificación de error

### 5. Capturas de JMeter
- [ ] Abrir: `jmeter/results/html/index.html`
- [ ] Summary Report
- [ ] Gráficos de rendimiento

---

## 📄 Completar Documento (20 minutos)

### 1. Abrir DOCUMENTO_ENTREGA.md

### 2. Completar Secciones
- [ ] Información personal
- [ ] Descripción del proceso
- [ ] Explicación de integraciones
- [ ] Resultados obtenidos
- [ ] Identificar 3 problemas de SonarQube
- [ ] Proponer mejoras
- [ ] Conclusiones

### 3. Insertar Capturas
- Crear carpeta `capturas/`
- Organizar por herramienta
- Referenciar en el documento

---

## ✅ Verificación Final (5 minutos)

### Checklist
- [ ] Pipeline ejecutado exitosamente
- [ ] 4 capturas de Jenkins
- [ ] 4 capturas de SonarQube (incluyendo 3 problemas)
- [ ] 2 capturas de Slack
- [ ] 4 capturas de JMeter
- [ ] Documento completado (máx 1 página)
- [ ] 3 problemas identificados con mejoras
- [ ] Todas las capturas en buena calidad
- [ ] Ortografía revisada

---

## 🎯 Distribución de Tiempo Total: ~85 minutos

| Actividad | Tiempo |
|-----------|--------|
| Preparación | 15 min |
| Ejecución Local | 10 min |
| Configuración Jenkins | 20 min |
| Captura Evidencias | 15 min |
| Completar Documento | 20 min |
| Verificación Final | 5 min |
| **TOTAL** | **85 min** |

---

## 💡 Tips para Ahorrar Tiempo

1. **Preparación previa**: Instala todas las herramientas antes del día de entrega
2. **Plantillas**: Usa el DOCUMENTO_ENTREGA.md como plantilla
3. **Capturas**: Usa Snipping Tool (Win+Shift+S en Windows)
4. **Organización**: Crea la carpeta de capturas desde el inicio
5. **Pruebas**: Ejecuta todo localmente antes de Jenkins
6. **Backup**: Guarda copias de las capturas inmediatamente

---

## 🆘 Problemas Comunes y Soluciones Rápidas

### Puerto 8081 ocupado
```bash
# Windows
netstat -ano | findstr :8081
taskkill /PID [PID] /F
```

### SonarQube no inicia
- Esperar 2-3 minutos después de iniciar
- Verificar logs en `sonarqube/logs/sonar.log`
- Verificar que no haya otro proceso en puerto 9000

### Jenkins no encuentra Maven
- **Manage Jenkins** → **Global Tool Configuration**
- Configurar Maven installation
- O usar Maven Wrapper incluido en el proyecto

### JMeter no genera reporte
- Verificar que la aplicación esté corriendo
- Crear carpeta `jmeter/results/` manualmente
- Verificar que JMeter esté en el PATH

---

## 📦 Entrega Final

### Estructura de Carpetas
```
entrega/
├── capturas/
│   ├── jenkins/
│   ├── sonarqube/
│   ├── slack/
│   └── jmeter/
├── DOCUMENTO_ENTREGA.md
└── README.md
```

### Comprimir y Entregar
```bash
# Crear ZIP con todo
zip -r entrega-reto-ci.zip capturas/ DOCUMENTO_ENTREGA.md README.md
```

---

**¡Éxito en tu reto! 🚀**
