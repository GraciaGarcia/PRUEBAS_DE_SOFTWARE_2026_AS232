# 🚀 Guía de Configuración - Reto CI/CD

## 📋 Requisitos Previos

### Software Necesario
- ✅ Java 17 o superior
- ✅ Maven 3.8+
- ✅ Jenkins (última versión)
- ✅ SonarQube 9.x
- ✅ Apache JMeter 5.x
- ✅ Git

---

## 1️⃣ Configuración de Jenkins

### Instalación de Plugins
1. Ir a **Manage Jenkins** → **Manage Plugins**
2. Instalar los siguientes plugins:
   - Pipeline
   - Git
   - SonarQube Scanner
   - Slack Notification
   - JUnit

### Configuración de Credenciales

#### Token de SonarQube
1. En SonarQube: **My Account** → **Security** → **Generate Token**
2. En Jenkins: **Manage Jenkins** → **Manage Credentials**
3. Agregar credencial tipo **Secret text**:
   - ID: `sonar-token`
   - Secret: [tu token de SonarQube]

#### Webhook de Slack
1. En Slack: Crear un Incoming Webhook
   - Ir a https://api.slack.com/apps
   - Crear nueva app → Incoming Webhooks
   - Copiar la URL del webhook
2. En Jenkins: **Manage Jenkins** → **Manage Credentials**
3. Agregar credencial tipo **Secret text**:
   - ID: `slack-webhook`
   - Secret: [tu webhook URL]

### Crear Pipeline
1. **New Item** → **Pipeline**
2. Nombre: `Proyecto-Base-CI`
3. En **Pipeline**:
   - Definition: **Pipeline script from SCM**
   - SCM: **Git**
   - Repository URL: [tu repositorio]
   - Script Path: `Jenkinsfile`

---

## 2️⃣ Configuración de SonarQube

### Iniciar SonarQube
```bash
# Windows
bin\windows-x86-64\StartSonar.bat

# Linux/Mac
bin/linux-x86-64/sonar.sh start
```

### Acceder a SonarQube
- URL: http://localhost:9000
- Usuario: admin
- Contraseña: admin (cambiar en primer acceso)

### Crear Proyecto
1. **Projects** → **Create Project**
2. Project key: `proyecto-base-ci`
3. Display name: `Proyecto Base CI/CD`
4. **Locally** → **Generate Token**
5. Copiar el token generado

### Configurar Quality Gate (Opcional)
1. **Quality Gates** → **Create**
2. Configurar umbrales según necesidad

---

## 3️⃣ Configuración de Slack

### Crear Workspace (si no tienes)
1. Ir a https://slack.com/create
2. Crear workspace

### Configurar Incoming Webhook
1. Ir a https://api.slack.com/apps
2. **Create New App** → **From scratch**
3. Nombre: `Jenkins CI/CD`
4. Seleccionar workspace
5. **Incoming Webhooks** → **Activate**
6. **Add New Webhook to Workspace**
7. Seleccionar canal (ej: #jenkins-notifications)
8. Copiar Webhook URL

---

## 4️⃣ Configuración de JMeter

### Instalación
1. Descargar desde: https://jmeter.apache.org/download_jmeter.cgi
2. Extraer en `C:\jmeter` (Windows) o `/opt/jmeter` (Linux)
3. Agregar al PATH:
   ```bash
   # Windows
   setx PATH "%PATH%;C:\jmeter\bin"
   
   # Linux/Mac
   export PATH=$PATH:/opt/jmeter/bin
   ```

### Verificar Instalación
```bash
jmeter -v
```

### Ejecutar Plan de Pruebas (Manual)
```bash
jmeter -n -t jmeter/LoadTest.jmx -l results.jtl -e -o report
```

---

## 5️⃣ Ejecución del Proyecto

### Compilar y Ejecutar Localmente
```bash
# Compilar
mvn clean install

# Ejecutar
mvn spring-boot:run
```

### Probar Endpoints
```bash
# GET /products
curl http://localhost:8081/products

# POST /login
curl -X POST http://localhost:8081/login \
  -H "Content-Type: application/json" \
  -d '{"username":"admin","password":"admin123"}'
```

### Ejecutar Pipeline en Jenkins
1. Ir al proyecto en Jenkins
2. Click en **Build Now**
3. Ver progreso en **Console Output**

---

## 6️⃣ Verificación de Resultados

### Jenkins
- Ver estado del pipeline
- Revisar logs de cada stage
- Verificar artefactos generados

### SonarQube
- Acceder a http://localhost:9000
- Ver proyecto `proyecto-base-ci`
- Revisar:
  - Code Smells
  - Bugs
  - Vulnerabilities
  - Coverage
  - Duplications

### Slack
- Verificar notificaciones en el canal configurado
- Mensaje de éxito ✅
- Mensaje de error ❌ (si falla)

### JMeter
- Revisar archivo `jmeter/results/results.jtl`
- Abrir reporte HTML en `jmeter/results/html/index.html`
- Analizar:
  - Tiempo de respuesta promedio
  - Throughput
  - Tasa de error

---

## 🔧 Solución de Problemas Comunes

### Error: "mvn: command not found"
```bash
# Verificar instalación de Maven
mvn -v

# Agregar Maven al PATH si es necesario
```

### Error: "Port 8081 already in use"
```bash
# Windows
netstat -ano | findstr :8081
taskkill /PID [PID] /F

# Linux/Mac
lsof -i :8081
kill -9 [PID]
```

### Error: "SonarQube connection refused"
- Verificar que SonarQube esté ejecutándose
- Verificar URL en `sonar-project.properties`
- Verificar token de autenticación

### Error: "Slack notification failed"
- Verificar webhook URL
- Verificar credencial en Jenkins
- Probar webhook manualmente con curl

---

## 📊 Métricas Esperadas

### JMeter (50 usuarios, 5 iteraciones)
- **Throughput**: > 100 req/s
- **Tiempo de respuesta promedio**: < 500ms
- **Tasa de error**: < 1%

### SonarQube
- **Bugs**: 0
- **Vulnerabilities**: 0
- **Code Smells**: < 10
- **Coverage**: > 70%

---

## 📝 Notas Adicionales

- El pipeline está configurado para Windows (usa `bat` en lugar de `sh`)
- Ajustar rutas según tu sistema operativo
- Los resultados de JMeter se archivan automáticamente en Jenkins
- Las notificaciones de Slack incluyen información del build

---

## 🆘 Soporte

Si encuentras problemas:
1. Revisar logs en Jenkins Console Output
2. Verificar configuración de credenciales
3. Consultar documentación oficial de cada herramienta
