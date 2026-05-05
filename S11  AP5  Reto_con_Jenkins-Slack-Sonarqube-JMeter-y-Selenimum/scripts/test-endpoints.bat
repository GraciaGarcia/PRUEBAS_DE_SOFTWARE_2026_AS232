@echo off
echo =========================================
echo Probando Endpoints de la Aplicacion
echo =========================================
echo.

echo 1. Verificando si la aplicacion esta activa...
curl -s http://localhost:8081/products >nul 2>&1
if %errorlevel% equ 0 (
    echo [OK] Aplicacion esta corriendo en puerto 8081
) else (
    echo [ERROR] Aplicacion no esta corriendo. Ejecuta: mvn spring-boot:run
    exit /b 1
)

echo.
echo 2. Probando GET /products...
echo -------------------------------------------
curl -s http://localhost:8081/products
echo.

echo 3. Probando POST /login (credenciales correctas)...
echo -------------------------------------------
curl -s -X POST http://localhost:8081/login -H "Content-Type: application/json" -d "{\"username\":\"admin\",\"password\":\"admin123\"}"
echo.

echo 4. Probando POST /login (credenciales incorrectas)...
echo -------------------------------------------
curl -s -X POST http://localhost:8081/login -H "Content-Type: application/json" -d "{\"username\":\"wrong\",\"password\":\"wrong\"}"
echo.

echo =========================================
echo [OK] Pruebas completadas
echo =========================================
pause
