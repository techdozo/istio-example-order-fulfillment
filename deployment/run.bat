@echo off
echo Running: gradlew clean build
call gradlew clean build
if %errorlevel% neq 0 exit /b %errorlevel%
echo gradlew clean build ran successfully

echo Running: docker build services\order-svc\ -t order-svc:1.0.0
docker build services\order-svc\ -t order-svc:1.0.0
if %errorlevel% neq 0 exit /b %errorlevel%
echo docker build services\order-svc\ -t order-svc:1.0.0 ran successfully

echo Running: docker build services\payment-svc\ -t payment-svc:1.0.0
docker build services\payment-svc\ -t payment-svc:1.0.0
if %errorlevel% neq 0 exit /b %errorlevel%
echo docker build services\payment-svc\ -t payment-svc:1.0.0 ran successfully

echo Running: docker build services\inventory-svc\ -t inventory-svc:1.0.0
docker build services\inventory-svc\ -t inventory-svc:1.0.0
if %errorlevel% neq 0 exit /b %errorlevel%
echo docker build services\inventory-svc\ -t inventory-svc:1.0.0 ran successfully

echo Running: kind load docker-image order-svc:1.0.0
kind load docker-image order-svc:1.0.0
if %errorlevel% neq 0 exit /b %errorlevel%
echo kind load docker-image order-svc:1.0.0 ran successfully

echo Running: kind load docker-image payment-svc:1.0.0
kind load docker-image payment-svc:1.0.0
if %errorlevel% neq 0 exit /b %errorlevel%
echo kind load docker-image payment-svc:1.0.0 ran successfully

echo Running: kind load docker-image inventory-svc:1.0.0
kind load docker-image inventory-svc:1.0.0
if %errorlevel% neq 0 exit /b %errorlevel%
echo kind load docker-image inventory-svc:1.0.0 ran successfully

echo All commands ran successfully!