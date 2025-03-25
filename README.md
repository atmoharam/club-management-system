# Club Management System  

## Overview  
The **Club Management System** is a microservices-based application built using Java Spring Boot. It provides functionalities such as user security check-ins, membership renewals, sports training schedules, and management reports. The system follows modern architectural patterns like **Domain-Driven Design (DDD), Clean Architecture, and Hexagonal Architecture** to ensure maintainability and scalability.  

## Features  
- **Security Check-in and Check-out** for users  
- **Membership Renewal and Online Payments**  
- **Sports Training Schedule Viewing**  
- **Family Members’ Activity Tracking**  
- **Management Reports** (age demographics, activity tracking, peak usage times)  

## Architecture  
The system is designed using a combination of **DDD, Clean, and Hexagonal Architectures**, ensuring high modularity and separation of concerns. Key architectural patterns include:  

- **Microservices Architecture**: Independent services communicating via Kafka  
- **Database-per-Service Pattern**: Each microservice has its own dedicated database  
- **CQRS (Command Query Responsibility Segregation)**: Separates read and write operations for performance optimization  
- **Event-Driven Architecture**: Uses **Kafka** for asynchronous event processing  
- **SAGA Pattern**: Ensures data consistency across distributed transactions  
- **Outbox Pattern with Batch Processing**: Improves reliability of event-driven messages  

## Technologies Used  
- **Java Spring Boot** (Microservices)  
- **Spring Cloud** (Service discovery, configuration management)  
- **Kafka** (Event-driven communication)  
- **Avro** (Optimized serialization for reducing latency)  
- **API Gateway** (Handles request routing, authentication, and rate limiting)  
- **IP Limiting Filter in API Gateway** (Prevents excessive API requests per user)  
- **Docker & Kubernetes (GKE)** (Containerization and orchestration)  
- **PostgreSQL / MongoDB** (Each service has its own database)  

## Future Enhancements  
- Implement **GraphQL** for efficient querying  
- Add **gRPC** for optimized inter-service communication  
- Implement **Observability** using Prometheus & Grafana  

## How to Run  
1. Clone the repository:  
   ```sh
   git clone https://github.com/atmoharam/club-management-system.git  
   cd club-management-system  
  docker-compose up -d  
  mvn clean install && docker-compose up  ```
