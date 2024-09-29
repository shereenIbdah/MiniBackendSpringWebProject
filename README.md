# TrainingProject

## Overview

This project demonstrates the use of **microservices architecture** for managing `Employee`, `Department`, and `Address` services. It leverages multiple technologies and tools like **Spring Boot**, **MongoDB**, **MySQL**, **Kafka**, **Docker**, and more to build a scalable, flexible system. API versioning is also implemented to ensure backward compatibility.

### Main Components

- **Config Server**: Centralized configuration management for all microservices.
- **Gateway**: Acts as a single entry point for routing API requests to the appropriate microservice.
- **Discovery Server (Eureka)**: Manages service discovery, allowing microservices to register and discover other services dynamically.
- **Employee Microservice**: Manages employee information and connects to a **MySQL** database.
- **Department Microservice**: Manages department data and connects to a **MongoDB** database.
- **Address Microservice**: Manages employee addresses and connects to the **MySQL** database.
- **Kafka**: Used for communication between microservices.
- **Docker**: Each microservice and dependency is containerized for easy deployment using Docker.

## Features

- **Microservices Architecture**: Decoupled services that can be deployed independently.
- **API Versioning**: Supports multiple versions of the Employee API (V1 and V2) for backward compatibility.
- **Service Discovery**: Dynamic service registration and discovery using Eureka.

## Technologies Used

- **Spring Boot** for building microservices.
- **Spring Cloud** for config server, service discovery, and gateway.
- **MongoDB** for Department microservice.
- **MySQL** for Employee and Address microservices.
- **Kafka** for asynchronous communication between microservices.
- **Docker** for containerizing services and dependencies.
- **Docker Compose** for managing multi-container Docker applications.
- **Eureka** for service discovery.
- **API Versioning** for managing multiple versions of the Employee API.

## Running the Project

### Prerequisites

- **Docker** and **Docker Compose** installed
- **Java 17** 
- **Maven** for building Spring Boot projects

### Running with Docker
 1. Clone the repository:
   ```bash
   git clone https://github.com/shereenIbdah/TrainingProject.git
   cd TrainingProject
