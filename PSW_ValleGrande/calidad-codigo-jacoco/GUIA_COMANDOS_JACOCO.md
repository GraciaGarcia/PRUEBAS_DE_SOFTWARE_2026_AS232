# 🚀 GUÍA DE COMANDOS - JaCoCo

**Proyecto**: Calidad de Código con JaCoCo  
**Herramienta**: JaCoCo 0.8.8 + Maven  
**Sistema Operativo**: Windows

---

## 📋 ÍNDICE

1. [Requisitos Previos](#requisitos-previos)
2. [Comandos Básicos](#comandos-básicos)
3. [Generar Reporte de JaCoCo](#generar-reporte-de-jacoco)
4. [Ver el Reporte](#ver-el-reporte)
5. [Comandos Avanzados](#comandos-avanzados)
6. [Solución de Problemas](#solución-de-problemas)

---

## 1️⃣ REQUISITOS PREVIOS

### Verificar que tienes Java instalado

```bash
java -version
```

**Salida esperada:**
```
java version "17.0.x" o superior
```

Si no tienes Java, descárgalo de: https://www.oracle.com/java/technologies/downloads/

---

### Verificar que tienes Maven instalado

```bash
mvn -version
```

**Salida esperada:**
```
Apache Maven 3.6.x o superior
```

Si no tienes Maven, descárgalo de: https://maven.apache.org/download.cgi

---

## 2️⃣ COMANDOS BÁSICOS

### Navegar a la carpeta del proyecto

```bash
cd "C:\Users\graci\OneDrive\Escritorio\PRUEBAS UNITARIAS\PSW_ValleGrande\calidad-codigo-jacoco"
```

O si ya estás en la carpeta `PSW_ValleGrande`:

```bash
cd calidad-codigo-jacoco
```

---

### Compilar el proyecto

```bash
mvn compile
```

**¿Qué hace?**
- Compila el código fuente en `src/main/java/`
- Genera los archivos `.class` en `target/classes/`

**Salida esperada:**
```
[INFO] BUILD SUCCESS
```

---

### Compilar las pruebas

```bash
mvn test-compile
```

**¿Qué hace?**
- Compila las pruebas en `src/test/java/`
- Genera los archivos `.class` en `target/test-classes/`

---

### Ejecutar las pruebas (sin reporte)

```bash
mvn test
```

**¿Qué hace?**
- Ejecuta todas las pruebas unitarias
- Muestra el resultado en consola

**Salida esperada:**
```
[INFO] Tests run: 18, Failures: 0, Errors: 0, Skipped: 0
[INFO] BUILD SUCCESS
```

---

## 3️⃣ GENERAR REPORTE DE JACOCO

### Comando Principal (Recomendado)

```bash
mvn clean test
```

**¿Qué hace?**
1. `clean` → Limpia la carpeta `target/` (elimina compilaciones anteriores)
2. `test` → Compila y ejecuta las pruebas
3. JaCoCo se ejecuta automáticamente y genera el reporte

**Salida esperada:**
```
[INFO] --- jacoco:0.8.8:prepare-agent (prepare-agent) @ calidad-codigo-jacoco ---
[INFO] argLine set to "-javaagent:..."
[INFO] 
[INFO] --- surefire:3.0.0-M7:test (default-test) @ calidad-codigo-jacoco ---
[INFO] Tests run: 18, Failures: 0, Errors: 0, Skipped: 0
[INFO] 
[INFO] --- jacoco:0.8.8:report (report) @ calidad-codigo-jacoco ---
[INFO] Loading execution data file ...
[INFO] Analyzed bundle 'Calidad Codigo con JaCoCo' with 5 classes
[INFO] BUILD SUCCESS
```

---

### Ubicación del Reporte Generado

Después de ejecutar `mvn clean test`, el reporte se genera en:

```
target/site/jacoco/index.html
```

**Ruta completa:**
```
C:\Users\graci\OneDrive\Escritorio\PRUEBAS UNITARIAS\PSW_ValleGrande\calidad-codigo-jacoco\target\site\jacoco\index.html
```

---

## 4️⃣ VER EL REPORTE

### Opción 1: Abrir desde la línea de comandos (Windows)

```bash
start target\site\jacoco\index.html
```

**¿Qué hace?**
- Abre el reporte HTML en tu navegador predeterminado

---

### Opción 2: Abrir manualmente

1. Abre el Explorador de Archivos
2. Navega a la carpeta del proyecto:
   ```
   C:\Users\graci\OneDrive\Escritorio\PRUEBAS UNITARIAS\PSW_ValleGrande\calidad-codigo-jacoco
   ```
3. Entra a la carpeta: `target\site\jacoco\`
4. Haz doble clic en: `index.html`

---

### Opción 3: Abrir con PowerShell

```powershell
Invoke-Item target\site\jacoco\index.html
```

---

### Opción 4: Abrir con un navegador específico

**Chrome:**
```bash
"C:\Program Files\Google\Chrome\Application\chrome.exe" target\site\jacoco\index.html
```

**Firefox:**
```bash
"C:\Program Files\Mozilla Firefox\firefox.exe" target\site\jacoco\index.html
```

**Edge:**
```bash
start msedge target\site\jacoco\index.html
```

---

## 5️⃣ COMANDOS AVANZADOS

### Limpiar el proyecto (eliminar compilaciones anteriores)

```bash
mvn clean
```

**¿Qué hace?**
- Elimina la carpeta `target/` completa
- Útil cuando quieres empezar desde cero

---

### Compilar sin ejecutar pruebas

```bash
mvn compile -DskipTests
```

**¿Qué hace?**
- Compila el código pero NO ejecuta las pruebas
- Útil para verificar que el código compila

---

### Ejecutar solo una prueba específica

```bash
mvn test -Dtest=PedidoServiceTest
```

**¿Qué hace?**
- Ejecuta solo la clase `PedidoServiceTest`
- Útil cuando estás trabajando en una prueba específica

---

### Ejecutar un método de prueba específico

```bash
mvn test -Dtest=PedidoServiceTest#testClienteVIP
```

**¿Qué hace?**
- Ejecuta solo el método `testClienteVIP` de la clase `PedidoServiceTest`

---

### Ver información detallada de las pruebas

```bash
mvn test -X
```

**¿Qué hace?**
- Ejecuta las pruebas en modo DEBUG
- Muestra información muy detallada (útil para debugging)

---

### Generar reporte sin limpiar

```bash
mvn test
```

**¿Qué hace?**
- Ejecuta las pruebas sin limpiar `target/`
- Más rápido si ya compilaste antes
- **Nota:** Puede usar caché, mejor usar `mvn clean test`

---

### Forzar descarga de dependencias

```bash
mvn clean install -U
```

**¿Qué hace?**
- `-U` fuerza la actualización de dependencias desde Maven Central
- Útil si hay problemas con dependencias

---

## 6️⃣ SOLUCIÓN DE PROBLEMAS

### Problema 1: "mvn no se reconoce como comando"

**Solución:**
1. Verifica que Maven esté instalado:
   ```bash
   where mvn
   ```
2. Si no está instalado, descárgalo de: https://maven.apache.org/download.cgi
3. Agrega Maven al PATH de Windows

---

### Problema 2: "No se encuentra el reporte de JaCoCo"

**Solución:**
1. Verifica que ejecutaste:
   ```bash
   mvn clean test
   ```
2. Verifica que existe la carpeta:
   ```bash
   dir target\site\jacoco
   ```
3. Si no existe, revisa que el `pom.xml` tenga configurado JaCoCo

---

### Problema 3: "Las pruebas fallan"

**Solución:**
1. Ejecuta con más detalle:
   ```bash
   mvn test -X
   ```
2. Lee el mensaje de error en la consola
3. Verifica que el código compile:
   ```bash
   mvn compile
   ```

---

### Problema 4: "BUILD FAILURE"

**Solución:**
1. Limpia el proyecto:
   ```bash
   mvn clean
   ```
2. Intenta compilar solo:
   ```bash
   mvn compile
   ```
3. Si compila, ejecuta las pruebas:
   ```bash
   mvn test
   ```

---

### Problema 5: "El reporte muestra 0% de cobertura"

**Solución:**
1. Verifica que las pruebas se ejecutaron:
   ```bash
   mvn clean test
   ```
2. Verifica que existe el archivo:
   ```bash
   dir target\jacoco.exec
   ```
3. Si no existe, revisa la configuración de JaCoCo en `pom.xml`

---

## 7️⃣ FLUJO COMPLETO PASO A PASO

### Para generar el reporte desde cero:

```bash
# Paso 1: Navegar a la carpeta del proyecto
cd "C:\Users\graci\OneDrive\Escritorio\PRUEBAS UNITARIAS\PSW_ValleGrande\calidad-codigo-jacoco"

# Paso 2: Limpiar compilaciones anteriores
mvn clean

# Paso 3: Compilar y ejecutar pruebas (genera reporte JaCoCo)
mvn test

# Paso 4: Abrir el reporte en el navegador
start target\site\jacoco\index.html
```

---

### Para regenerar el reporte (más rápido):

```bash
# Todo en un solo comando
mvn clean test && start target\site\jacoco\index.html
```

**Explicación:**
- `mvn clean test` → Limpia, compila, ejecuta pruebas y genera reporte
- `&&` → Ejecuta el siguiente comando solo si el anterior tuvo éxito
- `start target\site\jacoco\index.html` → Abre el reporte

---

## 8️⃣ COMANDOS ÚTILES ADICIONALES

### Ver la estructura del proyecto

```bash
tree /F
```

**Salida esperada:**
```
├── src
│   ├── main
│   │   └── java
│   │       └── vallegrande
│   │           └── edu
│   │               └── pe
│   │                   ├── calculator
│   │                   ├── model
│   │                   ├── service
│   │                   └── validator
│   └── test
│       └── java
│           └── service
├── target
│   └── site
│       └── jacoco
│           └── index.html
└── pom.xml
```

---

### Ver el contenido del reporte CSV

```bash
type target\site\jacoco\jacoco.csv
```

**¿Qué hace?**
- Muestra las métricas de cobertura en formato CSV
- Útil para análisis automatizado

---

### Buscar archivos de JaCoCo

```bash
dir /s /b target\*.exec
dir /s /b target\*.html
```

**¿Qué hace?**
- Busca todos los archivos `.exec` (datos de ejecución)
- Busca todos los archivos `.html` (reportes)

---

## 9️⃣ ATAJOS Y ALIAS

### Crear un script batch para generar el reporte

Crea un archivo `generar-reporte.bat` con este contenido:

```batch
@echo off
echo ========================================
echo   GENERANDO REPORTE DE JACOCO
echo ========================================
echo.

echo [1/3] Limpiando proyecto...
call mvn clean

echo.
echo [2/3] Ejecutando pruebas y generando reporte...
call mvn test

echo.
echo [3/3] Abriendo reporte en el navegador...
start target\site\jacoco\index.html

echo.
echo ========================================
echo   REPORTE GENERADO EXITOSAMENTE
echo ========================================
pause
```

**Uso:**
```bash
generar-reporte.bat
```

---

### Crear un script PowerShell

Crea un archivo `generar-reporte.ps1` con este contenido:

```powershell
Write-Host "========================================" -ForegroundColor Cyan
Write-Host "  GENERANDO REPORTE DE JACOCO" -ForegroundColor Cyan
Write-Host "========================================" -ForegroundColor Cyan
Write-Host ""

Write-Host "[1/3] Limpiando proyecto..." -ForegroundColor Yellow
mvn clean

Write-Host ""
Write-Host "[2/3] Ejecutando pruebas y generando reporte..." -ForegroundColor Yellow
mvn test

Write-Host ""
Write-Host "[3/3] Abriendo reporte en el navegador..." -ForegroundColor Yellow
Start-Process "target\site\jacoco\index.html"

Write-Host ""
Write-Host "========================================" -ForegroundColor Green
Write-Host "  REPORTE GENERADO EXITOSAMENTE" -ForegroundColor Green
Write-Host "========================================" -ForegroundColor Green
```

**Uso:**
```powershell
.\generar-reporte.ps1
```

---

## 🔟 RESUMEN DE COMANDOS ESENCIALES

| Comando | Descripción |
|---------|-------------|
| `mvn clean test` | Genera el reporte de JaCoCo |
| `start target\site\jacoco\index.html` | Abre el reporte |
| `mvn clean` | Limpia el proyecto |
| `mvn compile` | Compila el código |
| `mvn test` | Ejecuta las pruebas |
| `mvn -version` | Verifica la versión de Maven |
| `java -version` | Verifica la versión de Java |

---

## 📊 INTERPRETACIÓN DEL REPORTE

### Qué verás en el reporte HTML:

1. **Página Principal (index.html)**
   - Resumen de cobertura global
   - Lista de paquetes
   - Barras de color (verde = cubierto, rojo = no cubierto)

2. **Al hacer clic en un paquete**
   - Lista de clases en ese paquete
   - Cobertura por clase

3. **Al hacer clic en una clase**
   - Código fuente con colores:
     - 🟢 Verde: Línea ejecutada por las pruebas
     - 🔴 Rojo: Línea NO ejecutada
     - 🟡 Amarillo: Línea parcialmente cubierta

4. **Métricas mostradas**
   - **Instructions**: Instrucciones de bytecode
   - **Branches**: Ramas (if/else, switch)
   - **Lines**: Líneas de código
   - **Methods**: Métodos
   - **Classes**: Clases

---

## ✅ CHECKLIST DE VERIFICACIÓN

Antes de presentar el reporte, verifica:

- [ ] Ejecutaste `mvn clean test`
- [ ] El comando terminó con `BUILD SUCCESS`
- [ ] Existe el archivo `target\site\jacoco\index.html`
- [ ] El reporte se abre correctamente en el navegador
- [ ] Las métricas de cobertura son visibles
- [ ] Todas las pruebas pasaron (0 failures)

---

## 📞 AYUDA ADICIONAL

Si tienes problemas:

1. Verifica que estás en la carpeta correcta:
   ```bash
   cd
   ```

2. Verifica que existe el archivo `pom.xml`:
   ```bash
   dir pom.xml
   ```

3. Verifica la configuración de JaCoCo en `pom.xml`:
   ```bash
   type pom.xml | findstr jacoco
   ```

---

**Elaborado por**: Equipo de Desarrollo  
**Fecha**: 31 de Marzo, 2026  
**Herramienta**: JaCoCo 0.8.8 + Maven
