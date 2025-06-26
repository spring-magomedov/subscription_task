# User and Subscription Management Microservice

The microservice provides a REST API for managing users and their subscriptions to digital services.
Built with Spring Boot 3 using Java 17 and PostgreSQL.

## Requirements

- Java 17
- Docker и Docker Compose
- Maven (for local builds)

## Running the Application

### 1. Using Docker Compose

```bash
docker-compose up --build
```
The application will be accessible at port 8080, PostgreSQL at port 5432.

## API Endpoints

### User Management

| Метод | Эндпоинт        | Описание      |
|-------|-----------------|---------------|
| POST  | /users          | Create a user |
| GET   | /users/{id}     | Get a user    |
| PUT   | /users/{id}     | Update a user |
| DELETE| /users/{id}     | Delete a user |

### Subscription Management

| Метод | Эндпоинт                     | Описание                    |
|-------|------------------------------|-----------------------------|
| POST  | /users/{id}/subscriptions    | Add a subscription          |
| GET   | /users/{id}/subscriptions    | List user subscriptions     |
| DELETE| /users/{id}/subscriptions/{sub_id} | Remove a subscription |

### Subscription Analytics

| Метод | Эндпоинт                     | Описание                         |
|-------|------------------------------|----------------------------------|
| GET   | /subscriptions/top           | Get TOP 3 popular subscriptions  |

## Logging
Logging is configured via SLF4J with output to console. Default log level: INFO.