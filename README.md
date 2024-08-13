# Introduction

Code example for the
article [Workflow Orchestration with Temporal and Spring Boot](https://techdozo.dev/workflow-orchestration-with-temporal-and-spring-boot/)
.

## Modules

### common

Contains interface for Activities. These Activities interface is used by order service and microservice that implements
Activity.

Also contains common object such as `OrderDTO` and error handling code (for now not used).

### order-svc (Order Microservice)

Entry point of Order Fulfillment workflow. Contains Workflow Definition `OrderFulfillmentWorkflow` and
implementation `OrderFulfillmentWorkflowImpl`

Code is organized in the package based on the clean/hexagonal architecture principles.

- application: contains business logic. There is no direct dependency on Temporal code.
- common: common configuration such as Spring bean definition
- infrastructure: Temporal specific code such as Workflow, Activity and Worker.
- persistence: Spring JPA related code.
- resource: REST API specific implementation.

### payment-svc (Payment Microservice)

Contains Activity implementation `DebitPaymentActivityImpl` and worker `PaymentWorker`

Code is organized in the package based on the clean/hexagonal architecture principles.

- application: contains business logic. There is no direct dependency on Temporal code.
- common: common configuration such as Spring bean definition
- infrastructure: Temporal specific code such as Activity and Worker.
- persistence: Spring JPA related code.
- resource: REST API specific implementation.

### inventory-svc (Inventory Microservice)

Contains Activity implementation `ReserveInventoryActivityImpl` and worker `InventoryWorker`

Code is organized in the package based on the clean/hexagonal architecture principles.

- application: contains business logic. There is no direct dependency on Temporal code.
- common: common configuration such as Spring bean definition
- infrastructure: Temporal specific code such as Activity and Worker.
- persistence: Spring JPA related code.
- resource: REST API specific implementation.

### shipment-svc (Shipment Microservice)

Contains Activity implementation `ShipGoodsActivityImpl` and worker `ShipmentWorker`

Code is organized in the package based on the clean/hexagonal architecture principles.

- application: contains business logic. There is no direct dependency on Temporal code.
- common: common configuration such as Spring bean definition
- infrastructure: Temporal specific code such as Activity and Worker.
- persistence: Spring JPA related code.
- resource: REST API specific implementation.

## Installing Temporal Locally

Make sure you have Docker installed locally

````commandline
git clone https://github.com/temporalio/docker-compose.git
cd  docker-compose
docker-compose up
````

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