#!/bin/bash

echo "========================================="
echo "Probando Endpoints de la Aplicación"
echo "========================================="
echo ""

# Verificar si la aplicación está corriendo
echo "1. Verificando si la aplicación está activa..."
curl -s http://localhost:8081/products > /dev/null
if [ $? -eq 0 ]; then
    echo "✅ Aplicación está corriendo en puerto 8081"
else
    echo "❌ Aplicación no está corriendo. Ejecuta: mvn spring-boot:run"
    exit 1
fi

echo ""
echo "2. Probando GET /products..."
echo "-------------------------------------------"
curl -s http://localhost:8081/products | jq '.'
echo ""

echo "3. Probando POST /login (credenciales correctas)..."
echo "-------------------------------------------"
curl -s -X POST http://localhost:8081/login \
  -H "Content-Type: application/json" \
  -d '{"username":"admin","password":"admin123"}' | jq '.'
echo ""

echo "4. Probando POST /login (credenciales incorrectas)..."
echo "-------------------------------------------"
curl -s -X POST http://localhost:8081/login \
  -H "Content-Type: application/json" \
  -d '{"username":"wrong","password":"wrong"}' | jq '.'
echo ""

echo "========================================="
echo "✅ Pruebas completadas"
echo "========================================="
