# 📸 Guía Completa para Capturar Evidencias

## 🎯 Objetivo
Esta guía te indica **EXACTAMENTE** qué capturar en cada herramienta para obtener los 20 puntos.

---

## 📋 Checklist de Capturas

### ✅ Jenkins (4 puntos) - Mínimo 4 capturas

#### Captura 1: Pipeline Completo
**Qué capturar:**
- Vista del pipeline con todos los stages
- Debe mostrar: Checkout → Build → Test → SonarQube → Start App → JMeter
- Estado: SUCCESS (verde) o FAILURE (rojo)

**Cómo capturar:**
1. Abre Jenkins: http://localhost:8080
2. Click en tu proyecto "Proyecto-Base-CI"
3. Click en el último build (#1, #2, etc.)
4. Verás la vista "Stage View" con todos los stages
5. **Captura toda la pantalla** (Win + Shift + S)

**Nombre sugerido:** `jenkins-01-pipeline-completo.png`

---

#### Captura 2: Console Output
**Qué capturar:**
- Logs de ejecución del pipeline
- Debe mostrar: comandos ejecutados, resultados, tiempos

**Cómo capturar:**
1. En el mismo build, click en "Console Output"
2. Scroll hasta ver partes importantes:
   - Inicio del build
   - Ejecución de Maven
   - Análisis de SonarQube
   - Ejecución de JMeter
3. **Captura varias secciones** o toda la pantalla

**Nombre sugerido:** `jenkins-02-console-output.png`

---

#### Captura 3: Build History
**Qué capturar:**
- Historial de builds
- Debe mostrar: números de build, estados, tiempos

**Cómo capturar:**
1. En la página principal del proyecto
2. Lado izquierdo verás "Build History"
3. **Captura la lista de builds**

**Nombre sugerido:** `jenkins-03-build-history.png`

---

#### Captura 4: Stage Details
**Qué capturar:**
- Detalles de un stage específico (ej: SonarQube o JMeter)
- Logs específicos de ese stage

**Cómo capturar:**
1. En la vista del build, click en un stage (ej: "SonarQube Analysis")
2. Verás los logs específicos de ese stage
3. **Captura los logs**

**Nombre sugerido:** `jenkins-04-stage-details.png`

---

### ✅ SonarQube (3 puntos) - Mínimo 5 capturas

#### Captura 1: Dashboard Principal
**Qué capturar:**
- Vista general del proyecto
- Debe mostrar: Quality Gate, Bugs, Vulnerabilities, Code Smells, Coverage

**Cómo capturar:**
1. Abre SonarQube: http://localhost:9000
2. Click en tu proyecto "proyecto-base-ci"
3. Verás el dashboard principal
4. **Captura toda la pantalla**

**Nombre sugerido:** `sonarqube-01-dashboard.png`

---

#### Captura 2: Métricas Detalladas
**Qué capturar:**
- Tabla con todas las métricas
- Debe mostrar: Reliability, Security, Maintainability, Coverage, Duplications

**Cómo capturar:**
1. En el dashboard, scroll hacia abajo
2. Verás secciones con métricas detalladas
3. **Captura las métricas**

**Nombre sugerido:** `sonarqube-02-metricas.png`

---

#### Captura 3: Problema 1 (Code Smell, Bug o Vulnerability)
**Qué capturar:**
- Detalle de un problema específico
- Debe mostrar: tipo, severidad, ubicación, descripción

**Cómo capturar:**
1. Click en "Issues" o en el número de "Code Smells"
2. Selecciona un problema de la lista
3. Click para ver detalles
4. **Captura el problema completo**

**Nombre sugerido:** `sonarqube-03-problema-1.png`

**Anota:**
- Tipo: [Bug/Code Smell/Vulnerability]
- Severidad: [Critical/Major/Minor]
- Ubicación: [Archivo:Línea]
- Descripción: [Qué dice SonarQube]

---

#### Captura 4: Problema 2
**Qué capturar:**
- Otro problema diferente al anterior

**Cómo capturar:**
1. Selecciona otro problema de la lista
2. **Captura el detalle**

**Nombre sugerido:** `sonarqube-04-problema-2.png`

---

#### Captura 5: Problema 3
**Qué capturar:**
- Un tercer problema diferente

**Cómo capturar:**
1. Selecciona otro problema
2. **Captura el detalle**

**Nombre sugerido:** `sonarqube-05-problema-3.png`

---

### ✅ Slack (3 puntos) - Mínimo 2 capturas

#### Captura 1: Notificación de Éxito
**Qué capturar:**
- Mensaje de Jenkins en Slack
- Debe mostrar: estado SUCCESS, nombre del proyecto, número de build

**Cómo capturar:**
1. Abre Slack en tu navegador o app
2. Ve al canal configurado (ej: #jenkins-notifications)
3. Busca el mensaje de Jenkins con ✅ SUCCESS
4. **Captura el mensaje completo**

**Nombre sugerido:** `slack-01-notificacion-success.png`

---

#### Captura 2: Notificación de Error (Opcional)
**Qué capturar:**
- Mensaje de error si el pipeline falla
- Debe mostrar: estado FAILURE, nombre del proyecto, número de build

**Cómo capturar:**
1. Si el pipeline falla, verás un mensaje con ❌ FAILURE
2. **Captura el mensaje**

**Nombre sugerido:** `slack-02-notificacion-failure.png`

**Nota:** Si no tienes un error, puedes provocar uno modificando el Jenkinsfile temporalmente.

---

### ✅ JMeter (4 puntos) - Mínimo 4 capturas

#### Captura 1: Summary Report
**Qué capturar:**
- Tabla con resultados de las pruebas
- Debe mostrar: Samples, Average, Min, Max, Error %, Throughput

**Cómo capturar:**
1. Abre el reporte HTML: `jmeter/results/html/index.html`
2. Verás el dashboard principal
3. **Captura la tabla de estadísticas**

**Nombre sugerido:** `jmeter-01-summary-report.png`

---

#### Captura 2: Dashboard Principal
**Qué capturar:**
- Vista general del reporte HTML
- Debe mostrar: gráficos, estadísticas generales

**Cómo capturar:**
1. En el mismo reporte HTML
2. Scroll para ver los gráficos
3. **Captura el dashboard**

**Nombre sugerido:** `jmeter-02-dashboard.png`

---

#### Captura 3: Resultados GET /products
**Qué capturar:**
- Métricas específicas del endpoint GET /products
- Debe mostrar: tiempo de respuesta, throughput, errores

**Cómo capturar:**
1. En el reporte, busca la sección de requests
2. Filtra o busca "GET /products"
3. **Captura las métricas**

**Nombre sugerido:** `jmeter-03-get-products.png`

---

#### Captura 4: Resultados POST /login
**Qué capturar:**
- Métricas específicas del endpoint POST /login
- Debe mostrar: tiempo de respuesta, throughput, errores

**Cómo capturar:**
1. Busca "POST /login" en el reporte
2. **Captura las métricas**

**Nombre sugerido:** `jmeter-04-post-login.png`

---

## 📁 Estructura de Carpetas para Capturas

```
capturas/
├── jenkins/
│   ├── jenkins-01-pipeline-completo.png
│   ├── jenkins-02-console-output.png
│   ├── jenkins-03-build-history.png
│   └── jenkins-04-stage-details.png
├── sonarqube/
│   ├── sonarqube-01-dashboard.png
│   ├── sonarqube-02-metricas.png
│   ├── sonarqube-03-problema-1.png
│   ├── sonarqube-04-problema-2.png
│   └── sonarqube-05-problema-3.png
├── slack/
│   ├── slack-01-notificacion-success.png
│   └── slack-02-notificacion-failure.png (opcional)
└── jmeter/
    ├── jmeter-01-summary-report.png
    ├── jmeter-02-dashboard.png
    ├── jmeter-03-get-products.png
    └── jmeter-04-post-login.png
```

---

## 🎯 Checklist de Calidad de Capturas

Antes de entregar, verifica que cada captura:

- [ ] **Es legible** - Texto claro, no borroso
- [ ] **Muestra información relevante** - No solo una parte vacía
- [ ] **Tiene buen tamaño** - No muy pequeña ni muy grande
- [ ] **Está bien nombrada** - Nombre descriptivo
- [ ] **Está en la carpeta correcta** - Organizada por herramienta
- [ ] **Muestra la URL** - Para verificar que es tu ejecución
- [ ] **Tiene timestamp** - Si es posible, que se vea la fecha/hora

---

## 💡 Tips para Mejores Capturas

### Windows
- **Snipping Tool**: Win + Shift + S
- **Captura completa**: Win + PrtScn
- **Herramienta Recortes**: Buscar en inicio

### Calidad
- Usa resolución alta
- Captura en pantalla completa cuando sea posible
- Asegúrate de que el texto sea legible
- No captures con zoom muy alto o muy bajo

### Contenido
- Incluye la barra de navegación (URL)
- Incluye timestamps si están visibles
- Captura suficiente contexto
- No cortes información importante

---

## 📝 Plantilla para Documentar Problemas de SonarQube

Para cada problema que captures, anota:

### Problema 1:
- **Tipo:** [Bug / Code Smell / Vulnerability / Security Hotspot]
- **Severidad:** [Blocker / Critical / Major / Minor / Info]
- **Ubicación:** [Archivo.java:línea]
- **Descripción:** [Lo que dice SonarQube]
- **Mejora Propuesta:** [Cómo lo solucionarías]

### Problema 2:
- **Tipo:** 
- **Severidad:** 
- **Ubicación:** 
- **Descripción:** 
- **Mejora Propuesta:** 

### Problema 3:
- **Tipo:** 
- **Severidad:** 
- **Ubicación:** 
- **Descripción:** 
- **Mejora Propuesta:** 

---

## ⚡ Orden Recomendado para Capturar

1. **Primero**: Ejecuta todo el pipeline en Jenkins
2. **Segundo**: Mientras corre, prepara las carpetas de capturas
3. **Tercero**: Cuando termine, captura Jenkins inmediatamente
4. **Cuarto**: Ve a SonarQube y captura el análisis
5. **Quinto**: Revisa Slack y captura las notificaciones
6. **Sexto**: Abre el reporte de JMeter y captura
7. **Séptimo**: Organiza todas las capturas en carpetas
8. **Octavo**: Verifica que tienes todas (mínimo 15 capturas)

---

## 🎯 Resumen de Capturas Mínimas

| Herramienta | Capturas Mínimas | Puntos |
|-------------|------------------|--------|
| Jenkins | 4 | 4 |
| SonarQube | 5 (incluyendo 3 problemas) | 3 |
| Slack | 2 | 3 |
| JMeter | 4 | 4 |
| **TOTAL** | **15 capturas** | **20** |

---

## 🆘 Si No Puedes Capturar Algo

### Jenkins no ejecuta
- Verifica que Jenkins esté corriendo en http://localhost:8080
- Revisa los logs de Jenkins
- Verifica credenciales configuradas

### SonarQube no muestra problemas
- Es normal si el código es muy simple
- Busca en "Issues" → "All"
- Filtra por tipo: Code Smells, Bugs, etc.
- Si no hay problemas, documenta que el código está limpio

### Slack no recibe notificaciones
- Verifica el webhook URL
- Prueba el webhook manualmente con curl
- Revisa los logs de Jenkins

### JMeter no genera reporte
- Verifica que la aplicación esté corriendo
- Crea la carpeta results/ manualmente
- Ejecuta JMeter con los parámetros correctos

---

## ✅ Verificación Final

Antes de entregar, verifica:

- [ ] Tengo mínimo 15 capturas
- [ ] Todas las capturas son legibles
- [ ] Están organizadas en carpetas
- [ ] Identifiqué 3 problemas de SonarQube
- [ ] Propuse mejoras para cada problema
- [ ] Las capturas muestran información relevante
- [ ] Los nombres de archivo son descriptivos

---

**¡Listo para capturar! 📸**

**Siguiente paso:** Ejecuta el pipeline y empieza a capturar siguiendo esta guía.
