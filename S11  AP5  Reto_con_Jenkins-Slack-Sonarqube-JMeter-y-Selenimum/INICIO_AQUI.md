# 🎯 EMPIEZA AQUÍ - Reto CI/CD

## 👋 Bienvenido

Este proyecto contiene **TODO** lo necesario para completar tu reto de integración continua con Jenkins, SonarQube, Slack y JMeter.

---

## 📚 Archivos Importantes

### 🚀 Para Empezar
1. **`QUE_FALTA_HACER.md`** ⭐ **LEE ESTO PRIMERO**
   - Lista completa de lo que debes hacer
   - Checklist de tareas
   - Tiempo estimado

2. **`PASOS_RAPIDOS.md`** ⚡
   - Guía paso a paso
   - Comandos listos para copiar
   - Solución de problemas

### 📖 Documentación
3. **`GUIA_CONFIGURACION.md`** 🔧
   - Configuración detallada de cada herramienta
   - Instalación de plugins
   - Configuración de credenciales

4. **`README.md`** 📄
   - Descripción del proyecto
   - Endpoints disponibles
   - Estructura del código

### ✅ Para la Entrega
5. **`DOCUMENTO_ENTREGA.md`** 📝
   - Plantilla para tu documento final
   - Secciones pre-formateadas
   - Tablas para métricas

6. **`CHECKLIST_ENTREGABLES.md`** ✔️
   - Lista de verificación completa
   - Distribución de puntos
   - Estructura de carpetas

---

## 🎬 Inicio Rápido (3 pasos)

### Paso 1: Verifica Requisitos
```bash
java -version    # Debe ser 17+
mvn -v          # Maven 3.8+
jmeter -v       # JMeter 5.x
```

### Paso 2: Prueba el Proyecto
```bash
# Compilar
mvn clean install

# Ejecutar
mvn spring-boot:run

# Probar (en otra terminal)
curl http://localhost:8081/products
```

### Paso 3: Lee la Guía
Abre **`QUE_FALTA_HACER.md`** y sigue las instrucciones.

---

## 📂 Estructura del Proyecto

```
proyecto-base-ci/
│
├── 📄 INICIO_AQUI.md              ← Estás aquí
├── 📄 QUE_FALTA_HACER.md          ← Lee esto primero
├── 📄 PASOS_RAPIDOS.md            ← Guía paso a paso
├── 📄 GUIA_CONFIGURACION.md       ← Configuración detallada
├── 📄 DOCUMENTO_ENTREGA.md        ← Plantilla para entregar
├── 📄 CHECKLIST_ENTREGABLES.md    ← Verificación final
├── 📄 README.md                   ← Documentación del proyecto
│
├── 🔧 Jenkinsfile                 ← Pipeline configurado
├── 🔧 sonar-project.properties    ← Config de SonarQube
├── 🔧 pom.xml                     ← Dependencias Maven
│
├── 📁 src/
│   ├── main/java/                 ← Código fuente
│   │   └── com/vallegrande/
│   │       ├── Application.java
│   │       ├── controller/
│   │       │   └── ProductController.java
│   │       └── model/
│   │           ├── Product.java
│   │           └── LoginRequest.java
│   └── test/java/                 ← Pruebas unitarias
│       └── com/vallegrande/
│           └── controller/
│               └── ProductControllerTest.java
│
├── 📁 jmeter/
│   ├── LoadTest.jmx               ← Plan de pruebas (50 usuarios)
│   └── results/                   ← Resultados (se genera)
│
└── 📁 scripts/
    ├── test-endpoints.bat         ← Probar endpoints (Windows)
    └── test-endpoints.sh          ← Probar endpoints (Linux/Mac)
```

---

## 🎯 Objetivos del Reto

### Lo que debes lograr:
1. ✅ Configurar Jenkins con pipeline automatizado
2. ✅ Integrar análisis de código con SonarQube
3. ✅ Configurar notificaciones en Slack
4. ✅ Ejecutar pruebas de carga con JMeter
5. ✅ Capturar evidencias de todo el proceso
6. ✅ Documentar el proceso y resultados

### Lo que debes entregar:
- 📸 Capturas de Jenkins (4 puntos)
- 📸 Capturas de SonarQube + 3 problemas identificados (3 puntos)
- 📸 Capturas de Slack (3 puntos)
- 📸 Capturas de JMeter (4 puntos)
- 📄 Documento de entrega (6 puntos)

**Total: 20 puntos**

---

## 🛠️ Herramientas Necesarias

### Debes instalar:
- [ ] **Java 17+** - https://adoptium.net/
- [ ] **Maven 3.8+** - https://maven.apache.org/download.cgi
- [ ] **Jenkins** - https://www.jenkins.io/download/
- [ ] **SonarQube** - https://www.sonarqube.org/downloads/
- [ ] **JMeter** - https://jmeter.apache.org/download_jmeter.cgi
- [ ] **Git** - https://git-scm.com/downloads

### Debes configurar:
- [ ] Token de SonarQube
- [ ] Webhook de Slack
- [ ] Credenciales en Jenkins
- [ ] Plugins de Jenkins

---

## ⏰ Tiempo Estimado

| Actividad | Tiempo |
|-----------|--------|
| Instalar herramientas | 30-60 min |
| Configurar todo | 30-45 min |
| Ejecutar y probar | 30-40 min |
| Capturar evidencias | 15-20 min |
| Completar documento | 20-30 min |
| **TOTAL** | **2-3 horas** |

---

## 🚦 Flujo de Trabajo Recomendado

```
1. Instalar Software
   ↓
2. Configurar SonarQube
   ↓
3. Configurar Slack
   ↓
4. Probar Proyecto Localmente
   ↓
5. Configurar Jenkins
   ↓
6. Ejecutar Pipeline
   ↓
7. Capturar Evidencias
   ↓
8. Completar Documento
   ↓
9. Organizar Entrega
   ↓
10. ✅ ENTREGAR
```

---

## 📋 Endpoints de la Aplicación

### GET /products
```bash
curl http://localhost:8081/products
```
Retorna lista de 5 productos.

### POST /login
```bash
curl -X POST http://localhost:8081/login \
  -H "Content-Type: application/json" \
  -d '{"username":"admin","password":"admin123"}'
```
Credenciales válidas: `admin` / `admin123`

---

## 🎓 Lo que Aprenderás

- ✅ Configurar un pipeline de CI/CD completo
- ✅ Integrar múltiples herramientas de DevOps
- ✅ Analizar calidad de código automáticamente
- ✅ Ejecutar pruebas de carga
- ✅ Automatizar notificaciones
- ✅ Documentar procesos técnicos

---

## 💡 Consejos Clave

### ✅ Haz esto:
- Lee **QUE_FALTA_HACER.md** antes de empezar
- Instala todo el software primero
- Prueba localmente antes de usar Jenkins
- Toma capturas inmediatamente
- Guarda tokens y webhooks en lugar seguro

### ❌ Evita esto:
- No modifiques el código (no es necesario)
- No inventes problemas de SonarQube
- No entregues capturas borrosas
- No excedas 1 página en el documento
- No dejes secciones vacías

---

## 🆘 ¿Necesitas Ayuda?

### Consulta estos archivos:
1. **Problemas de configuración** → `GUIA_CONFIGURACION.md`
2. **Dudas sobre pasos** → `PASOS_RAPIDOS.md`
3. **Qué entregar** → `CHECKLIST_ENTREGABLES.md`
4. **Formato del documento** → `DOCUMENTO_ENTREGA.md`

### Problemas comunes:
- Puerto ocupado → Ver `GUIA_CONFIGURACION.md` sección "Solución de Problemas"
- Maven no encontrado → Verificar PATH del sistema
- SonarQube no inicia → Esperar 2-3 minutos
- Jenkins no conecta → Verificar credenciales

---

## 📊 Distribución de Puntos

```
Jenkins (4 pts)     ████████████████████
SonarQube (3 pts)   ███████████████
Slack (3 pts)       ███████████████
JMeter (4 pts)      ████████████████████
Documento (6 pts)   ██████████████████████████████
```

---

## 🎯 Próximos Pasos

### 1. Ahora mismo:
```bash
# Verifica que tienes Java y Maven
java -version
mvn -v

# Si no los tienes, instálalos primero
```

### 2. Luego:
Abre **`QUE_FALTA_HACER.md`** y sigue la lista de tareas.

### 3. Durante el proceso:
Usa **`PASOS_RAPIDOS.md`** como referencia rápida.

### 4. Al final:
Verifica con **`CHECKLIST_ENTREGABLES.md`** que tienes todo.

---

## ✨ Todo Está Listo

- ✅ Código del proyecto completo
- ✅ Pipeline de Jenkins configurado
- ✅ Plan de pruebas de JMeter listo
- ✅ Configuración de SonarQube preparada
- ✅ Documentación completa
- ✅ Scripts de ayuda incluidos

**Solo necesitas instalar las herramientas y seguir las guías.**

---

## 🚀 ¡Comienza Ahora!

**Siguiente archivo a leer:** `QUE_FALTA_HACER.md`

```bash
# Abre el archivo y empieza:
code QUE_FALTA_HACER.md
```

---

**¡Éxito en tu reto! 🎉**

*Recuerda: Todo el código ya está hecho. Tu trabajo es configurar las herramientas, ejecutar el pipeline y documentar el proceso.*
