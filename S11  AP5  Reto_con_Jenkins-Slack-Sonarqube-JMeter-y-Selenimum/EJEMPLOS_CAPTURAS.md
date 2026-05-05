# 📸 Ejemplos de lo que Deberías Ver en las Capturas

## 🎯 Esta guía te muestra QUÉ información debe aparecer en cada captura

---

## 1️⃣ JENKINS - 4 Capturas

### Captura 1: Pipeline Completo
**Lo que DEBES ver:**
```
┌─────────────────────────────────────────────────────┐
│ Proyecto-Base-CI #1                                 │
├─────────────────────────────────────────────────────┤
│ [✓] Checkout        [✓] Build         [✓] Test     │
│ [✓] SonarQube       [✓] Start App     [✓] JMeter   │
│                                                      │
│ Status: SUCCESS ✓                                   │
│ Duration: 3 min 45 sec                              │
└─────────────────────────────────────────────────────┘
```

**Información clave:**
- Nombre del proyecto
- Número de build
- 6 stages visibles
- Estado final (SUCCESS o FAILURE)
- Duración total

---

### Captura 2: Console Output
**Lo que DEBES ver:**
```
Started by user admin
Running as SYSTEM
[Pipeline] Start of Pipeline
[Pipeline] node
[Pipeline] {
[Pipeline] stage
[Pipeline] { (Checkout)
[Pipeline] checkout
...
[Pipeline] stage
[Pipeline] { (Build)
[Pipeline] bat
> mvn clean install -DskipTests
[INFO] BUILD SUCCESS
...
[Pipeline] stage
[Pipeline] { (SonarQube Analysis)
> mvn sonar:sonar
[INFO] Analysis report uploaded in 234ms
...
[Pipeline] stage
[Pipeline] { (JMeter Load Test)
> jmeter -n -t jmeter/LoadTest.jmx
summary = 500 in 00:00:45
...
Finished: SUCCESS
```

**Información clave:**
- Comandos ejecutados
- Resultados de Maven
- Mensajes de SonarQube
- Resultados de JMeter
- Estado final

---

### Captura 3: Build History
**Lo que DEBES ver:**
```
Build History
─────────────────
#3  ✓  3 min    (May 5, 2026 10:30 AM)
#2  ✗  2 min    (May 5, 2026 10:15 AM)
#1  ✓  4 min    (May 5, 2026 10:00 AM)
```

**Información clave:**
- Números de build
- Estados (✓ o ✗)
- Duraciones
- Timestamps

---

### Captura 4: Stage Details
**Lo que DEBES ver (ejemplo: SonarQube stage):**
```
[SonarQube Analysis] Stage Logs
────────────────────────────────
[INFO] Scanning for projects...
[INFO] 
[INFO] --------< com.vallegrande:proyecto-base-ci >--------
[INFO] Building Proyecto Base CI/CD 1.0.0
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] --- sonar-maven-plugin:3.10.0.2594:sonar (default-cli) @ proyecto-base-ci ---
[INFO] User cache: C:\Users\...\.sonar\cache
[INFO] SonarQube version: 9.9.0
[INFO] Analyzing on SonarQube server 9.9.0
[INFO] Default locale: "en_US", source code encoding: "UTF-8"
[INFO] Load global settings
[INFO] Load global settings (done) | time=123ms
[INFO] Server id: 9CFC3560-AYjbXAMYcx4D_example
[INFO] User cache: C:\Users\...\.sonar\cache
[INFO] Load/download plugins
[INFO] Load/download plugins (done) | time=234ms
[INFO] Process project properties
[INFO] Execute project builders
[INFO] Execute project builders (done) | time=12ms
[INFO] Project key: proyecto-base-ci
[INFO] Base dir: C:\...\proyecto-base-ci
[INFO] Working dir: C:\...\proyecto-base-ci\target\sonar
[INFO] Load project settings for component key: 'proyecto-base-ci'
[INFO] Load project settings for component key: 'proyecto-base-ci' (done) | time=45ms
[INFO] Load quality profiles
[INFO] Load quality profiles (done) | time=67ms
[INFO] Load active rules
[INFO] Load active rules (done) | time=890ms
[INFO] Indexing files...
[INFO] Project configuration:
[INFO] 5 files indexed
[INFO] Quality profile for java: Sonar way
[INFO] ------------- Run sensors on module proyecto-base-ci
[INFO] Sensor JavaSensor [java]
[INFO] Configured Java source version (sonar.java.source): 17
[INFO] JavaClasspath initialization
[INFO] JavaClasspath initialization (done) | time=23ms
[INFO] JavaTestClasspath initialization
[INFO] JavaTestClasspath initialization (done) | time=12ms
[INFO] Java Main Files AST scan
[INFO] 5 source files to be analyzed
[INFO] Java Main Files AST scan (done) | time=456ms
[INFO] Java Test Files AST scan
[INFO] 1 test files to be analyzed
[INFO] Java Test Files AST scan (done) | time=123ms
[INFO] Sensor JavaSensor [java] (done) | time=1234ms
[INFO] ------------- Run sensors on project
[INFO] Sensor Zero Coverage Sensor
[INFO] Sensor Zero Coverage Sensor (done) | time=12ms
[INFO] SCM Publisher SCM provider for this project is: git
[INFO] SCM Publisher 6 source files to be analyzed
[INFO] SCM Publisher 6/6 source files have been analyzed (done) | time=234ms
[INFO] CPD Executor Calculating CPD for 5 files
[INFO] CPD Executor CPD calculation finished (done) | time=45ms
[INFO] Analysis report generated in 123ms, dir size=89 KB
[INFO] Analysis report compressed in 23ms, zip size=34 KB
[INFO] Analysis report uploaded in 234ms
[INFO] ANALYSIS SUCCESSFUL, you can browse http://localhost:9000/dashboard?id=proyecto-base-ci
[INFO] Note that you will be able to access the updated dashboard once the server has processed the submitted analysis report
[INFO] More about the report processing at http://localhost:9000/api/ce/task?id=AYjbXAMYcx4D_example
[INFO] Analysis total time: 4.567 s
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
```

**Información clave:**
- Versión de SonarQube
- Archivos analizados
- Tiempo de análisis
- URL del dashboard
- BUILD SUCCESS

---

## 2️⃣ SONARQUBE - 5 Capturas

### Captura 1: Dashboard Principal
**Lo que DEBES ver:**
```
┌─────────────────────────────────────────────────────┐
│ proyecto-base-ci                                    │
├─────────────────────────────────────────────────────┤
│ Quality Gate: PASSED ✓                              │
│                                                      │
│ Reliability:    A  (0 Bugs)                         │
│ Security:       A  (0 Vulnerabilities)              │
│ Maintainability: A  (5 Code Smells)                 │
│ Coverage:       0%  (No tests)                      │
│ Duplications:   0%                                  │
│                                                      │
│ Lines of Code: 150                                  │
│ Last Analysis: May 5, 2026 10:25 AM                │
└─────────────────────────────────────────────────────┘
```

**Información clave:**
- Nombre del proyecto
- Quality Gate status
- Ratings (A, B, C, D, E)
- Números de bugs, vulnerabilities, code smells
- Coverage percentage
- Lines of code
- Timestamp del análisis

---

### Captura 2: Métricas Detalladas
**Lo que DEBES ver:**
```
Reliability
├─ Bugs: 0
├─ Rating: A
└─ Remediation Effort: 0min

Security
├─ Vulnerabilities: 0
├─ Security Hotspots: 2
├─ Rating: A
└─ Remediation Effort: 0min

Maintainability
├─ Code Smells: 5
├─ Rating: A
├─ Technical Debt: 30min
└─ Debt Ratio: 0.5%

Coverage
├─ Coverage: 0.0%
├─ Lines to Cover: 45
└─ Uncovered Lines: 45

Duplications
├─ Duplicated Lines: 0
├─ Duplicated Blocks: 0
└─ Duplications: 0.0%

Size
├─ Lines: 250
├─ Lines of Code: 150
├─ Statements: 45
├─ Functions: 12
└─ Classes: 5
```

**Información clave:**
- Todas las métricas con números
- Ratings
- Technical debt
- Tamaño del proyecto

---

### Captura 3, 4, 5: Problemas Detectados
**Ejemplo de Code Smell:**
```
┌─────────────────────────────────────────────────────┐
│ Code Smell                                          │
├─────────────────────────────────────────────────────┤
│ Severity: MAJOR                                     │
│ Type: Code Smell                                    │
│                                                      │
│ Remove this unused private method                   │
│                                                      │
│ Location:                                           │
│ ProductController.java:45                           │
│                                                      │
│ private void unusedMethod() {                       │
│     // This method is never called                  │
│ }                                                    │
│                                                      │
│ Rule: java:S1144                                    │
│ Effort: 5min                                        │
└─────────────────────────────────────────────────────┘
```

**Ejemplo de Security Hotspot:**
```
┌─────────────────────────────────────────────────────┐
│ Security Hotspot                                    │
├─────────────────────────────────────────────────────┤
│ Severity: MEDIUM                                    │
│ Type: Security Hotspot                              │
│                                                      │
│ Make sure this hardcoded password is safe          │
│                                                      │
│ Location:                                           │
│ ProductController.java:32                           │
│                                                      │
│ if ("admin123".equals(password)) {                  │
│     // Hardcoded password                           │
│ }                                                    │
│                                                      │
│ Rule: java:S2068                                    │
│ Category: Security                                  │
└─────────────────────────────────────────────────────┘
```

**Ejemplo de Bug:**
```
┌─────────────────────────────────────────────────────┐
│ Bug                                                 │
├─────────────────────────────────────────────────────┤
│ Severity: CRITICAL                                  │
│ Type: Bug                                           │
│                                                      │
│ NullPointerException might be thrown               │
│                                                      │
│ Location:                                           │
│ Product.java:23                                     │
│                                                      │
│ public String getName() {                           │
│     return name.toString(); // name might be null   │
│ }                                                    │
│                                                      │
│ Rule: java:S2259                                    │
│ Effort: 10min                                       │
└─────────────────────────────────────────────────────┘
```

**Información clave en cada problema:**
- Tipo (Bug, Code Smell, Vulnerability, Security Hotspot)
- Severidad (Blocker, Critical, Major, Minor, Info)
- Descripción del problema
- Ubicación exacta (archivo:línea)
- Código afectado
- Regla de SonarQube
- Esfuerzo de remediación

---

## 3️⃣ SLACK - 2 Capturas

### Captura 1: Notificación de Éxito
**Lo que DEBES ver:**
```
┌─────────────────────────────────────────────────────┐
│ Jenkins CI                                    10:30 │
├─────────────────────────────────────────────────────┤
│ ✅ Pipeline Exitoso                                 │
│                                                      │
│ Proyecto: Proyecto-Base-CI                          │
│ Build: #3                                           │
│ Estado: SUCCESS ✅                                  │
│                                                      │
│ Duration: 3 min 45 sec                              │
│ Started by: admin                                   │
└─────────────────────────────────────────────────────┘
```

**Información clave:**
- Icono de éxito (✅)
- Nombre del proyecto
- Número de build
- Estado SUCCESS
- Duración
- Timestamp

---

### Captura 2: Notificación de Error
**Lo que DEBES ver:**
```
┌─────────────────────────────────────────────────────┐
│ Jenkins CI                                    10:15 │
├─────────────────────────────────────────────────────┤
│ ❌ Pipeline Fallido                                 │
│                                                      │
│ Proyecto: Proyecto-Base-CI                          │
│ Build: #2                                           │
│ Estado: FAILURE ❌                                  │
│                                                      │
│ Failed at: SonarQube Analysis                       │
│ Duration: 2 min 12 sec                              │
│ Started by: admin                                   │
└─────────────────────────────────────────────────────┘
```

**Información clave:**
- Icono de error (❌)
- Nombre del proyecto
- Número de build
- Estado FAILURE
- Stage donde falló
- Duración
- Timestamp

---

## 4️⃣ JMETER - 4 Capturas

### Captura 1: Summary Report
**Lo que DEBES ver:**
```
┌──────────────────────────────────────────────────────────────────────────┐
│ APDEX (Application Performance Index)                                   │
│ Overall: 0.95 (Excellent)                                               │
├──────────────────────────────────────────────────────────────────────────┤
│ Statistics                                                               │
├──────────────┬─────────┬─────────┬─────────┬─────────┬─────────┬────────┤
│ Label        │ Samples │ Average │ Min     │ Max     │ Error % │ Thr/s  │
├──────────────┼─────────┼─────────┼─────────┼─────────┼─────────┼────────┤
│ GET /products│   250   │  145ms  │  89ms   │  456ms  │  0.00%  │ 125.3  │
│ POST /login  │   250   │  167ms  │  102ms  │  523ms  │  0.00%  │ 118.7  │
│ TOTAL        │   500   │  156ms  │  89ms   │  523ms  │  0.00%  │ 244.0  │
└──────────────┴─────────┴─────────┴─────────┴─────────┴─────────┴────────┘
```

**Información clave:**
- APDEX score
- Número de samples (500 total)
- Tiempo promedio de respuesta
- Tiempo mínimo y máximo
- Porcentaje de error (debe ser 0% o muy bajo)
- Throughput (requests por segundo)

---

### Captura 2: Dashboard Principal
**Lo que DEBES ver:**
```
┌─────────────────────────────────────────────────────┐
│ Test and Report information                         │
├─────────────────────────────────────────────────────┤
│ Start Time: 2026-05-05 10:25:30                    │
│ End Time:   2026-05-05 10:26:15                    │
│ Duration:   45 seconds                              │
│                                                      │
│ [Gráfico de Response Time Over Time]               │
│ [Gráfico de Throughput Over Time]                  │
│ [Gráfico de Active Threads Over Time]              │
└─────────────────────────────────────────────────────┘
```

**Información clave:**
- Timestamps de inicio y fin
- Duración total
- Gráficos de rendimiento
- Tendencias de tiempo de respuesta

---

### Captura 3: Resultados GET /products
**Lo que DEBES ver:**
```
┌─────────────────────────────────────────────────────┐
│ GET /products                                       │
├─────────────────────────────────────────────────────┤
│ Samples:           250                              │
│ Average:           145 ms                           │
│ Median:            138 ms                           │
│ 90th Percentile:   234 ms                           │
│ 95th Percentile:   312 ms                           │
│ 99th Percentile:   445 ms                           │
│ Min:               89 ms                            │
│ Max:               456 ms                           │
│ Error %:           0.00%                            │
│ Throughput:        125.3/sec                        │
│ Received KB/sec:   45.2                             │
│ Sent KB/sec:       12.3                             │
└─────────────────────────────────────────────────────┘
```

**Información clave:**
- 250 samples (50 usuarios × 5 iteraciones)
- Tiempos de respuesta (promedio, percentiles)
- 0% de error
- Throughput alto

---

### Captura 4: Resultados POST /login
**Lo que DEBES ver:**
```
┌─────────────────────────────────────────────────────┐
│ POST /login                                         │
├─────────────────────────────────────────────────────┤
│ Samples:           250                              │
│ Average:           167 ms                           │
│ Median:            159 ms                           │
│ 90th Percentile:   267 ms                           │
│ 95th Percentile:   345 ms                           │
│ 99th Percentile:   498 ms                           │
│ Min:               102 ms                           │
│ Max:               523 ms                           │
│ Error %:           0.00%                            │
│ Throughput:        118.7/sec                        │
│ Received KB/sec:   23.4                             │
│ Sent KB/sec:       15.6                             │
└─────────────────────────────────────────────────────┘
```

**Información clave:**
- 250 samples
- Tiempos de respuesta similares a GET
- 0% de error
- Throughput alto

---

## ✅ Checklist de Información en Capturas

Antes de entregar, verifica que tus capturas muestren:

### Jenkins
- [ ] Nombre del proyecto visible
- [ ] Número de build visible
- [ ] 6 stages visibles
- [ ] Estado final (SUCCESS/FAILURE)
- [ ] Duración visible
- [ ] Logs de ejecución legibles

### SonarQube
- [ ] Nombre del proyecto visible
- [ ] Quality Gate status
- [ ] Números de bugs, vulnerabilities, code smells
- [ ] Ratings (A, B, C, D, E)
- [ ] 3 problemas con detalles completos
- [ ] Ubicación de cada problema (archivo:línea)
- [ ] Descripción de cada problema

### Slack
- [ ] Nombre del proyecto visible
- [ ] Número de build visible
- [ ] Estado (SUCCESS/FAILURE)
- [ ] Timestamp visible
- [ ] Icono de estado (✅/❌)

### JMeter
- [ ] Número total de samples (500)
- [ ] Tiempos de respuesta (promedio, min, max)
- [ ] Porcentaje de error (0% o muy bajo)
- [ ] Throughput (requests/sec)
- [ ] Métricas separadas para cada endpoint

---

## 💡 Tips Finales

1. **Calidad**: Asegúrate de que el texto sea legible
2. **Contexto**: Incluye suficiente información alrededor
3. **Completo**: No cortes información importante
4. **Organizado**: Guarda en las carpetas correctas
5. **Nombrado**: Usa nombres descriptivos

---

**¡Ahora sabes exactamente qué buscar en cada captura! 📸**
