@echo off
echo ============================================
echo SCRIPT DE EJECUCION COMPLETA - RETO CI/CD
echo ============================================
echo.
echo Este script ejecutara todo el proyecto paso a paso
echo para que puedas capturar las evidencias facilmente.
echo.
pause

REM Crear carpetas para capturas
echo.
echo [1/8] Creando carpetas para capturas...
mkdir capturas 2>nul
mkdir capturas\jenkins 2>nul
mkdir capturas\sonarqube 2>nul
mkdir capturas\slack 2>nul
mkdir capturas\jmeter 2>nul
echo [OK] Carpetas creadas
echo.

REM Verificar herramientas
echo [2/8] Verificando herramientas instaladas...
echo.
echo Verificando Java...
java -version
if %errorlevel% neq 0 (
    echo [ERROR] Java no esta instalado
    pause
    exit /b 1
)
echo.

echo Verificando Maven...
mvn -v
if %errorlevel% neq 0 (
    echo [ERROR] Maven no esta instalado
    pause
    exit /b 1
)
echo.

echo Verificando JMeter...
jmeter -v
if %errorlevel% neq 0 (
    echo [ADVERTENCIA] JMeter no esta en el PATH
    echo Puedes ejecutarlo manualmente despues
)
echo.

REM Compilar proyecto
echo [3/8] Compilando proyecto...
echo Ejecutando: mvn clean install
mvn clean install
if %errorlevel% neq 0 (
    echo [ERROR] Fallo la compilacion
    pause
    exit /b 1
)
echo [OK] Proyecto compilado exitosamente
echo.
pause

REM Ejecutar aplicacion
echo [4/8] Iniciando aplicacion Spring Boot...
echo La aplicacion se ejecutara en segundo plano
echo Puerto: 8081
start /B mvn spring-boot:run
echo Esperando 30 segundos para que la aplicacion inicie...
timeout /t 30 /nobreak
echo [OK] Aplicacion iniciada
echo.

REM Probar endpoints
echo [5/8] Probando endpoints...
echo.
echo Probando GET /products...
curl -s http://localhost:8081/products
echo.
echo.
echo Probando POST /login...
curl -s -X POST http://localhost:8081/login -H "Content-Type: application/json" -d "{\"username\":\"admin\",\"password\":\"admin123\"}"
echo.
echo.
echo [OK] Endpoints funcionando
echo.
pause

REM Analisis SonarQube
echo [6/8] Ejecutando analisis de SonarQube...
echo.
echo IMPORTANTE: Asegurate de que SonarQube este corriendo en http://localhost:9000
echo Si no lo has iniciado, presiona Ctrl+C y ejecuta SonarQube primero
echo.
pause
echo.
echo Ingresa tu token de SonarQube:
set /p SONAR_TOKEN="Token: "
echo.
echo Ejecutando analisis...
mvn sonar:sonar -Dsonar.projectKey=proyecto-base-ci -Dsonar.host.url=http://localhost:9000 -Dsonar.login=%SONAR_TOKEN%
if %errorlevel% neq 0 (
    echo [ADVERTENCIA] El analisis de SonarQube fallo
    echo Puedes ejecutarlo manualmente despues
) else (
    echo [OK] Analisis completado
    echo.
    echo AHORA CAPTURA:
    echo 1. Abre http://localhost:9000
    echo 2. Ve a tu proyecto "proyecto-base-ci"
    echo 3. Captura el dashboard
    echo 4. Captura las metricas
    echo 5. Captura 3 problemas encontrados
)
echo.
pause

REM Ejecutar JMeter
echo [7/8] Ejecutando pruebas de carga con JMeter...
echo.
mkdir jmeter\results 2>nul
echo Ejecutando JMeter (esto puede tomar 1-2 minutos)...
jmeter -n -t jmeter\LoadTest.jmx -l jmeter\results\results.jtl -e -o jmeter\results\html
if %errorlevel% neq 0 (
    echo [ADVERTENCIA] JMeter fallo
    echo Verifica que JMeter este instalado y en el PATH
) else (
    echo [OK] Pruebas completadas
    echo.
    echo AHORA CAPTURA:
    echo 1. Abre jmeter\results\html\index.html
    echo 2. Captura el dashboard
    echo 3. Captura las metricas de GET /products
    echo 4. Captura las metricas de POST /login
)
echo.
pause

REM Instrucciones finales
echo [8/8] Proceso completado
echo.
echo ============================================
echo CAPTURAS PENDIENTES
echo ============================================
echo.
echo JENKINS:
echo 1. Abre http://localhost:8080
echo 2. Ejecuta el pipeline "Proyecto-Base-CI"
echo 3. Captura: pipeline completo, console output, build history
echo.
echo SONARQUBE:
echo 1. Abre http://localhost:9000
echo 2. Ve al proyecto "proyecto-base-ci"
echo 3. Ya deberia tener el analisis (lo ejecutamos antes)
echo 4. Captura: dashboard, metricas, 3 problemas
echo.
echo SLACK:
echo 1. Abre tu workspace de Slack
echo 2. Ve al canal configurado
echo 3. Captura las notificaciones de Jenkins
echo.
echo JMETER:
echo 1. Abre jmeter\results\html\index.html
echo 2. Ya esta generado (lo ejecutamos antes)
echo 3. Captura: dashboard, metricas de ambos endpoints
echo.
echo ============================================
echo CARPETAS CREADAS
echo ============================================
echo.
echo Guarda tus capturas en:
echo - capturas\jenkins\
echo - capturas\sonarqube\
echo - capturas\slack\
echo - capturas\jmeter\
echo.
echo ============================================
echo SIGUIENTE PASO
echo ============================================
echo.
echo 1. Configura Jenkins con el Jenkinsfile
echo 2. Ejecuta el pipeline
echo 3. Captura todas las evidencias
echo 4. Completa DOCUMENTO_ENTREGA.md
echo 5. Verifica con CHECKLIST_ENTREGABLES.md
echo.
echo Consulta GUIA_CAPTURAS.md para saber exactamente que capturar
echo.
pause

REM Limpiar
echo.
echo Deseas detener la aplicacion Spring Boot? (S/N)
set /p STOP="Respuesta: "
if /i "%STOP%"=="S" (
    echo Deteniendo aplicacion...
    taskkill /F /IM java.exe /T
    echo [OK] Aplicacion detenida
)

echo.
echo ============================================
echo SCRIPT COMPLETADO
echo ============================================
echo.
echo Revisa GUIA_CAPTURAS.md para instrucciones detalladas
echo.
pause
