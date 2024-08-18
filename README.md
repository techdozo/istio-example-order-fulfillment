# Introduction

Code example for the

.

## Modules

### common

Contains error handling code.

### order-svc (Order Microservice)



### payment-svc (Payment Microservice)



### inventory-svc (Inventory Microservice)



## Installation

Make sure you have Docker installed locally


# Build and Test

To build `./gradlew clean build`

### Build Docker Container
To build docker container use docker build command as
#### Order Service
`docker build services\order-svc\ -t order-svc:1.0.0`
#### Payment Service
`docker build services\payment-svc\ -t payment-svc:1.0.0`
#### Inventory Service
`docker build services\inventory-svc\ -t inventory-svc:1.0.0`

### Load image in Kind
kind load docker-image order-svc:1.0.0 order-svc:1.0.0
kind load docker-image payment-svc:1.0.0 payment-svc:1.0.0
kind load docker-image inventory-svc:1.0.0 inventory-svc:1.0.0


```commandline
curl --location --request POST 'localhost:8081/orders' \
--header 'Content-Type: application/json' \
--data-raw '{
  "productId": 30979484,
  "price": 28.99,
  "quantity": 2
}'
```

To view list of payments

```commandline
curl --location --request GET 'localhost:8083/payments' \
--header 'Accept: application/json'
```

To view list of inventory

```commandline
curl --location --request GET 'localhost:8082/inventories' \
--header 'Accept: application/json'
```