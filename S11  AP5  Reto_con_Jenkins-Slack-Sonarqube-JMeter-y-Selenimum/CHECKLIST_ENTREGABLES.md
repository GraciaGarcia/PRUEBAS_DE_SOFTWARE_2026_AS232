# ✅ Checklist de Entregables - Reto CI/CD

## 📋 Lista de Verificación

### 1. Captura del Pipeline en Jenkins (4 puntos)
- [ ] Captura del pipeline completo ejecutándose
- [ ] Captura mostrando todas las etapas (stages)
- [ ] Captura del Console Output
- [ ] Captura mostrando el estado final (SUCCESS/FAILURE)

**Ubicación sugerida:** Carpeta `capturas/jenkins/`

---

### 2. Captura del Análisis en SonarQube (3 puntos)
- [ ] Captura del dashboard principal del proyecto
- [ ] Captura mostrando las métricas:
  - [ ] Bugs
  - [ ] Vulnerabilities
  - [ ] Code Smells
  - [ ] Coverage
  - [ ] Duplications
  - [ ] Security Hotspots
- [ ] Captura de al menos 3 problemas detectados

**Ubicación sugerida:** Carpeta `capturas/sonarqube/`

#### Identificación de 3 Problemas y Mejoras
- [ ] **Problema 1**: Descripción, ubicación y mejora propuesta
- [ ] **Problema 2**: Descripción, ubicación y mejora propuesta
- [ ] **Problema 3**: Descripción, ubicación y mejora propuesta

---

### 3. Captura de Notificación en Slack (3 puntos)
- [ ] Captura de notificación exitosa (SUCCESS)
- [ ] Captura de notificación de error (FAILURE) - opcional
- [ ] Captura mostrando:
  - [ ] Nombre del proyecto
  - [ ] Número de build
  - [ ] Estado del pipeline
  - [ ] Timestamp

**Ubicación sugerida:** Carpeta `capturas/slack/`

---

### 4. Captura de Resultados de JMeter (4 puntos)
- [ ] Captura del Summary Report
- [ ] Captura del reporte HTML generado
- [ ] Captura mostrando métricas de:
  - [ ] GET /products
  - [ ] POST /login
- [ ] Captura mostrando:
  - [ ] Número de usuarios (50)
  - [ ] Tiempo de respuesta promedio
  - [ ] Throughput
  - [ ] Tasa de error

**Ubicación sugerida:** Carpeta `capturas/jmeter/`

---

### 5. Documento de Entrega (6 puntos)

#### 5.1 Descripción del Proceso (2 puntos)
- [ ] Explicación de configuración de Jenkins
- [ ] Explicación de configuración de SonarQube
- [ ] Explicación de configuración de Slack
- [ ] Explicación de configuración de JMeter
- [ ] Descripción de la ejecución del pipeline

#### 5.2 Explicación de Integración (2 puntos)
- [ ] Cómo se conecta Jenkins con SonarQube
- [ ] Cómo se conecta Jenkins con Slack
- [ ] Cómo se conecta Jenkins con JMeter
- [ ] Diagrama de integración (opcional pero recomendado)
- [ ] Flujo de datos entre herramientas

#### 5.3 Resultados Obtenidos (2 puntos)
- [ ] Resultado de la ejecución del pipeline
- [ ] Análisis de métricas de SonarQube
- [ ] Análisis de resultados de JMeter
- [ ] Identificación de éxitos y errores
- [ ] Conclusiones y aprendizajes

**Archivo:** `DOCUMENTO_ENTREGA.md` (completado)

---

## 📁 Estructura de Carpetas Sugerida

```
proyecto-base-ci/
├── capturas/
│   ├── jenkins/
│   │   ├── pipeline-completo.png
│   │   ├── console-output.png
│   │   └── stages-detalle.png
│   ├── sonarqube/
│   │   ├── dashboard.png
│   │   ├── metricas.png
│   │   ├── problema-1.png
│   │   ├── problema-2.png
│   │   └── problema-3.png
│   ├── slack/
│   │   ├── notificacion-success.png
│   │   └── notificacion-failure.png (opcional)
│   └── jmeter/
│       ├── summary-report.png
│       ├── reporte-html.png
│       ├── get-products.png
│       └── post-login.png
├── DOCUMENTO_ENTREGA.md (completado)
└── README.md
```

---

## 🎯 Puntos Clave para Máxima Calificación

### Jenkins (4 pts)
✅ Pipeline ejecutándose sin errores  
✅ Todas las etapas visibles y completadas  
✅ Console output legible  
✅ Artefactos generados correctamente  

### SonarQube (3 pts)
✅ Análisis completado exitosamente  
✅ Métricas claramente visibles  
✅ 3 problemas identificados con mejoras propuestas  
✅ Explicación técnica de cada problema  

### Slack (3 pts)
✅ Notificaciones recibidas correctamente  
✅ Formato del mensaje correcto  
✅ Información completa del build  
✅ Integración funcionando automáticamente  

### JMeter (4 pts)
✅ Pruebas con 50 usuarios ejecutadas  
✅ Ambos endpoints probados  
✅ Métricas de rendimiento claras  
✅ Análisis de resultados incluido  

### Documento (6 pts)
✅ Descripción clara y completa del proceso  
✅ Explicación técnica de integraciones  
✅ Resultados bien documentados  
✅ Conclusiones y aprendizajes  
✅ Formato profesional  
✅ Máximo 1 página (o según indicaciones)  

---

## ⏰ Antes de Entregar

- [ ] Todas las capturas están en buena calidad
- [ ] Las capturas muestran información relevante
- [ ] El documento está completo y sin secciones vacías
- [ ] Se identificaron y explicaron 3 problemas de SonarQube
- [ ] Se propusieron mejoras para cada problema
- [ ] El documento no excede 1 página (o según indicaciones)
- [ ] Todos los archivos están organizados
- [ ] Se revisó ortografía y redacción
- [ ] Se incluyó nombre y código de estudiante

---

## 📊 Distribución de Puntos

| Entregable | Puntos | Estado |
|------------|--------|--------|
| Pipeline Jenkins | 4 | ⬜ |
| Análisis SonarQube | 3 | ⬜ |
| Notificación Slack | 3 | ⬜ |
| Resultados JMeter | 4 | ⬜ |
| Documento | 6 | ⬜ |
| **TOTAL** | **20** | **⬜** |

---

## 💡 Consejos Finales

1. **Capturas de pantalla**: Usa herramientas como Snipping Tool o Lightshot
2. **Calidad**: Asegúrate de que las capturas sean legibles
3. **Contexto**: Incluye suficiente información en cada captura
4. **Documento**: Sé conciso pero completo
5. **Revisión**: Pide a alguien que revise tu documento antes de entregar
6. **Backup**: Guarda copias de todo antes de entregar

---

**¡Éxito en tu entrega! 🚀**
