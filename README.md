# Spring Boot Microservices Project (Spring Data JPA)

This project demonstrates a **Microservices Architecture using Spring Boot and Spring Cloud**.
It includes service discovery, API gateway routing, service-to-service communication, and database integration using **Spring Data JPA**.

The goal of this project is to understand **how real microservices communicate and are managed in a distributed system**.

---

# Architecture

Client applications communicate through a **single entry point (API Gateway)**.
The gateway routes requests to the appropriate microservice using **service discovery (Eureka Server)**.

```
Client
   │
   ▼
API Gateway (8080)
   │
   ▼
Discovery Server (8761)
   │
 ┌───────────────┐
 ▼               ▼
Product Service  Order Service
 (8081)            (8082)
      │               │
      ▼               ▼
   product_db      order_db
```

---

# Microservices Included

### Discovery Server

Service registry where all microservices register themselves.

Port:

```
8761
```

Technology:

* Spring Cloud Netflix Eureka

Dashboard:

```
http://localhost:8761
```

---

### API Gateway

Single entry point for all client requests.
Routes requests to appropriate services.

Port:

```
8080
```

Example routes:

```
GET  /product-service/products
POST /product-service/products

POST /order-service/orders
```

Technology:

* Spring Cloud Gateway

---

### Product Service

Manages product data.

Port:

```
8081
```

Features:

* Create Product
* Get Products
* Reduce Product Quantity

Database:

```
product_db
```

Technologies:

* Spring Boot
* Spring Data JPA
* MySQL

Example API:

Create product

```
POST /products
```

Body:

```json
{
"name": "Laptop",
"price": 50000,
"quantity": 10
}
```

Get products

```
GET /products
```

---

### Order Service

Handles customer orders and communicates with Product Service using **Feign Client**.

Port:

```
8082
```

Features:

* Create Order
* Validate Product
* Reduce Product Stock

Database:

```
order_db
```

Technologies:

* Spring Boot
* Spring Data JPA
* OpenFeign
* MySQL

Example API:

```
POST /orders
```

Body:

```json
{
"productId": 1,
"quantity": 2
}
```

---

# Technologies Used

* Java 17
* Spring Boot
* Spring Cloud
* Eureka Discovery Server
* Spring Cloud Gateway
* Spring Data JPA
* OpenFeign
* MySQL
* Maven

---

# How Service Discovery Works

1. Each microservice registers with the Discovery Server.
2. Eureka stores service locations.
3. Other services discover them using service names instead of IP addresses.

Example:

```
PRODUCT-SERVICE → localhost:8081
ORDER-SERVICE   → localhost:8082
```

---

# How API Gateway Routing Works

Gateway receives request:

```
/product-service/products
```

Gateway removes the prefix and forwards request:

```
/products
```

to Product Service.

This is done using the filter:

```
StripPrefix=1
```

---

# Running the Project

Start services in the following order:

1. discovery-server
2. product-service
3. order-service
4. api-gateway

After starting all services, open:

```
http://localhost:8761
```

to see registered services.

---

# Testing APIs

### Create Product

```
POST http://localhost:8080/product-service/products
```

Body:

```json
{
"name": "Phone",
"price": 30000,
"quantity": 5
}
```

---

### Get Products

```
GET http://localhost:8080/product-service/products
```

---

### Create Order

```
POST http://localhost:8080/order-service/orders
```

Body:

```json
{
"productId": 1,
"quantity": 2
}
```

---

# Key Concepts Demonstrated

* Microservices Architecture
* Service Discovery
* API Gateway Routing
* Service-to-Service Communication
* Spring Data JPA
* Database per Service Pattern

---

# Future Improvements

The following features can be added to extend the system:

* Config Server
* Circuit Breaker (Resilience4j)
* Distributed Logging
* JWT Authentication
* Docker Deployment
* Kafka Event Streaming

---

# Author

Amit Kushwaha
